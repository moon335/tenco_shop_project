package com.tenco.tencoshop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Answer;
import com.tenco.tencoshop.repository.model.Question;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.AdminService;
import com.tenco.tencoshop.service.AnswerService;
import com.tenco.tencoshop.service.QuestionService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	// 관리자가 유저 정보 들어가기
	@GetMapping("/userList")
	public String buyList(@RequestParam Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			throw new CustomRestfullException("로그인 먼저해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!principal.getRole().equals("admin")) {
			throw new CustomRestfullException("관리자 계정으로 로그인 해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		User user = userService.userInfo(principal.getId());
		Double productCount = userService.userAllCount();
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		Integer startPage = currentPage - 5;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 9;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("user", user);
		List<User> userList = userService.userInfoAll(begin, range);
		model.addAttribute("userList", userList);
		if (userList.isEmpty()) {
			model.addAttribute("userList", null);
		} else {
			model.addAttribute("userList", userList);
		}
		return "/admin/userList";
	}

	// 내 정보 수정 화면 들어가기
	@GetMapping("/adminInfoEditor")
	public String myinfoEditor(Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		User user = userService.userInfo(principal.getId());
		model.addAttribute("user", user);
		user.getPassword();
		return "/admin/adminInfoEditor";
	}

	// 내 정보 수정하기
	@PostMapping("/myinfoupdate")
	public String myInfoUpdate(@Valid UserInfoRequestDto userInfoRequestDto, BindingResult bindingResult) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (principal.getPassword().equals(userInfoRequestDto.getPassword()) == false) {
			session.invalidate();
			return "redirect:/user/sign-in";
		}
		userService.userInfoUpdate(userInfoRequestDto, principal.getId());
		return "redirect:/admin/adminInfoEditor";
	}

	// 내정보 이미지 넣기
	@PostMapping("/adminInfoupdateimage")
	public String myinfoUpdateImage(UserInfoRequestDto userInfoRequestDto) {
		// 이미지넣기
		MultipartFile file = userInfoRequestDto.getFile();
		if (file.isEmpty() == false) {

			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("이거 익셉션 하나 더 만들어야함", HttpStatus.BAD_REQUEST);
			}
			try {
				String saveDirectory = Define.UPLOAD_DIRECTORY;

				File dir = new File(saveDirectory);
				if (dir.exists() == false) {
					dir.mkdirs();
				}
				UUID uuid = UUID.randomUUID();
				String fileName = uuid + "_" + file.getOriginalFilename();
				String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;
				File destination = new File(uploadPath);
				file.transferTo(destination);

				userInfoRequestDto.setOriginFileName(file.getOriginalFilename());
				userInfoRequestDto.setUploadFileName(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
			userService.userInfoUpdateImage(userInfoRequestDto, principal.getId());
			User user = userService.userInfo(principal.getId());
			principal.setImage(user.getImage());
			return "redirect:/admin/adminInfoEditor";

		}

		return "redirect:/admin/adminInfoEditor";
	}

	// 내정보 이미지 삭제하기
	@PostMapping("/adminInfoDeleteimage")
	public String adminDeleteimage(UserInfoRequestDto userInfoRequestDto) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userService.userInfoUpdateImage(userInfoRequestDto, principal.getId());
		User user = userService.userInfo(principal.getId());
		principal.setImage(null);
		return "redirect:/admin/adminInfoEditor";
	}

	// 관리자 계정 로그인
	@GetMapping("/admin")
	public String signInAdmin(@RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			throw new CustomRestfullException("로그인 먼저해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<ProductRequestDto> orderList = userService.buyProductList(begin, range, principal.getId());
		User user = userService.userInfo(principal.getId());
		model.addAttribute("user", user);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
			model.addAttribute("principal", principal);
		}
		return "/admin/admin";
	}

	// 판매 목록 들어가기
	@GetMapping("salesList")
	public String salesList(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer id, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		List<ProductRequestDto> salesList = userRepository.salesList(begin, range);
		Double productCount = userRepository.salesListCount();
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		Integer startPage = currentPage - 5;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 9;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("principal", principal);
		if (salesList.isEmpty()) {
			model.addAttribute("salesList", null);
		} else {
			model.addAttribute("salesList", salesList);
		}
		return "/admin/salesList";

	}

	// 해당 유저 정보 보기(판매 리스트에서)
	@GetMapping("userSelect")
	public String userSelect(@RequestParam Integer userId, Model model) {
		User user = userRepository.userInfoSelect(userId);
		model.addAttribute("user", user);
		return "/admin/userSelect";
	}

	// QnA 모두 검색
	@GetMapping("/find")
	public String findQuestion(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		List<Question> questList = questionService.readQuestion(begin, range);
		Double productCount = questionService.questionCount();
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		Integer startPage = currentPage - 5;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 9;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		LoginResponseDto user = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (user == null) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", user);
		}
		if (questList.isEmpty()) {
			model.addAttribute("questList", null);
		} else {
			model.addAttribute("questList", questList);
		}
		return "/admin/adminQuestion";
	}

	// QnA 상세 정보 들어가기
	@GetMapping("/detail")
	public String questionDetail(@RequestParam Integer id, Model model) {
		Question quest = questionService.questionDetailPage(id);
		Answer answer = answerService.answerDetailPage(id);
		LoginResponseDto user = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (user == null) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", user);
		}
		if (answer == null) {
			model.addAttribute("answer", null);
		} else {
			model.addAttribute("answer", answer);
		}

		if (quest.getId() == null) {
			model.addAttribute("quest", null);
		} else {
			model.addAttribute("quest", quest);
		}
		return "/admin/adminQuestionDetail";
	}

	// question 삭제하기
	@GetMapping("/delete")
	public String questionDelete(Integer id) {
		questionService.questionDelete(id);
		return "redirect:/admin/find";
	}

}