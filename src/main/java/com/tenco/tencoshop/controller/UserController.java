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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.OrderResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	// myinfo에서 주문한 제품 보기
	@GetMapping("/myinfoProc")
	public String myInfoProc(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range,
			Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userId = principal.getId();
		OrderResponseDto orderCount = userService.orderCounter(principal.getId());
		List<ProductRequestDto> orderList = userService.readBuyProductList(begin, range, principal.getId());
		User user = userService.readUserInfo(principal.getId());
		Double productCount = userService.readBuyListCount(userId);
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
		model.addAttribute("user", user);
		model.addAttribute("orderCount", orderCount);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
			model.addAttribute("principal", principal);
		}
		return "/user/myInfo";
	}

	// 구매목록화면 들어가기
	@GetMapping("/buylist")
	public String buyList(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range,
			Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		User user = userService.readUserInfo(principal.getId());
		List<ProductRequestDto> orderList = userService.readBuyProductList(begin, range, principal.getId());
		Double productCount = userService.readBuyListCount(user.getId());
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
		model.addAttribute("user", user);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
		}
		return "/user/buy";
	}

	// 주문한 제품 search하기
	@GetMapping("/buylistProc")
	public String buyListProc(ProductRequestDto productRequestDto, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		productRequestDto.setUserId(principal.getId());
		User user = userService.readUserInfo(principal.getId());
		List<ProductRequestDto> orderList = userService.readProductListByProductRequestDto(productRequestDto);
		model.addAttribute("user", user);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
		}
		return "/user/buy";
	}

	// 질문 글쓰기
	@GetMapping("/questWriting")
	public String helpWriting() {
		return "/user/questWriting";
	}

	// 내 정보 수정 화면 들어가기
	@GetMapping("/myinfoEditor")
	public String myinfoEditor(Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		User user = userService.readUserInfo(principal.getId());
		model.addAttribute("user", user);
		user.getPassword();
		return "/user/myInfoEditor";

	}

	// 내 정보 수정하기
	// validation
	@PostMapping("/myinfoupdate")
	public String myInfoUpdate(@Valid UserInfoRequestDto userInfoRequestDto, BindingResult bindingResult) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userService.updateUserInfo(userInfoRequestDto, principal.getId());
		if (principal.getPassword().equals(userInfoRequestDto.getPassword()) == false) {
			session.invalidate();
			return "redirect:/user/sign-in";
		}

		return "redirect:/user/myinfoEditor";
	}

	// 내정보 이미지 넣기
	@PostMapping("/myinfoupdateimage")
	public String myinfoUpdateImage(UserInfoRequestDto userInfoRequestDto) {
		// 이미지넣기
		MultipartFile file = userInfoRequestDto.getFile();
		if (file.isEmpty() == false) {

			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("파일 크기가 너무 큽니다.", HttpStatus.BAD_REQUEST);
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
			userService.updateUserInfoImage(userInfoRequestDto, principal.getId());
			User user = userService.readUserInfo(principal.getId());
			principal.setImage(user.getImage());
			return "redirect:/user/myinfoEditor";

		}

		return "redirect:/user/myinfoEditor";
	}

	// 내정보 이미지 삭제하기
	@PostMapping("/userInfoDeleteimage")
	public String userInfoDeleteimage(UserInfoRequestDto userInfoRequestDto) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userService.updateUserInfoImage(userInfoRequestDto, principal.getId());
		User user = userService.readUserInfo(principal.getId());
		principal.setImage(null);
		return "redirect:/user/myinfoEditor";
	}

	@GetMapping("/sign-in")
	public String signIn() {

		return "user/login";
	}

	// 로그인
	@PostMapping("/sign-in")
	public String signInProc(@Valid LoginResponseDto loginResponseDto, BindingResult bindingResult) {

		LoginResponseDto principal = userService.readUser(loginResponseDto);
		if (principal.getRole().equals("admin")) {
			principal.setPassword(loginResponseDto.getPassword());
			session.setAttribute(Define.PRINCIPAL, principal);
			return "redirect:/admin/admin?currentPage=1&begin=0&range=5";
		}
		principal.setPassword(loginResponseDto.getPassword());
		session.setAttribute(Define.PRINCIPAL, principal);
		return "redirect:/main";
	}

	// 회원가입
	@GetMapping("/sign-up")
	public String signUp() {

		return "user/join";
	}

	@PostMapping("/sign-up")
	public String signUpProc(@Valid JoinResponseDto joinResponseDto, BindingResult bindingResult) {

		userService.createUser(joinResponseDto);

		return "user/login";
	}

	// 회원탈퇴
	@GetMapping("/withdraw")
	public String withDraw() {

		return "/user/delete";
	}

	// 진짜 회원탈퇴
	@GetMapping("/realwithdrawal")
	public String realwithDrawal() {

		return "/user/realWithdrawal";
	}

	// 회원 탈퇴
	@PostMapping("/withdraw")
	public String withDrawProc(LoginResponseDto loginResponseDto) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userService.userDelete(principal);
		session.invalidate();
		return "redirect:/main";
	}
	
	@PostMapping("/withdrawUser")
	public String withDrawUserProc(LoginResponseDto principal) {
		userService.userDelete(principal);
		session.invalidate();
		return "redirect:/admin/userList?currentPage=1&begin=0&range=8";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout() {

		session.invalidate();

		return "redirect:/main";
	}

}
