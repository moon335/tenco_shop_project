package com.tenco.tencoshop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.repository.model.Product;
=======
import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.HandlerException;
import com.tenco.tencoshop.handler.exception.LoginException;
>>>>>>> feature/QnA
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.LoginService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired // DI 처리
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;

<<<<<<< HEAD
	@Autowired
	private HttpSession session;

	@GetMapping("/myinfo")
	public String myInfo() {
=======
	// myinfo에서 주문한 제품 보기
	@GetMapping("/myinfoProc")
	public String myInfoProc(Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			throw new LoginException("로그인 먼저해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		userId = principal.getId();
		List<ProductRequestDto> orderList = userService.buyProductList(principal.getId());
		System.out.println(userId + "@#@##");
		User user = userService.userInfo(principal.getId());
		model.addAttribute("user", user);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
			model.addAttribute("principal", principal);
		}
>>>>>>> feature/QnA
		return "/user/myInfo";
	}

	// 구매목록화면 들어가기
	@GetMapping("buylist")
	public String buyList(Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		User user = userService.userInfo(principal.getId());
		List<ProductRequestDto> orderList = userService.buyProductList(principal.getId());
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
		List<ProductRequestDto> orderList = userService.searchProductList(productRequestDto);
		System.out.println("orderList" + orderList);
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
		User user = userService.userInfo(principal.getId());
		model.addAttribute("user", user);
		user.getPassword();
		return "/user/myInfoEditor";
	}

	// 내 정보 수정하기
	@PostMapping("/myinfoupdate")
	public String myinfoUpdate(UserInfoRequestDto userInfoRequestDto) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userService.userInfoUpdate(userInfoRequestDto, principal.getId());
		principal.setPassword(userInfoRequestDto.getPassword());

		return "redirect:/user/myinfoEditor";
	}

<<<<<<< HEAD
	
=======
	// 내정보 이미지 넣기
	@PostMapping("/myinfoupdateimage")
	public String myinfoUpdateImage(UserInfoRequestDto userInfoRequestDto) {
		// 이미지넣기
		MultipartFile file = userInfoRequestDto.getFile();
		if (file.isEmpty() == false) {

			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new LoginException("이거 익셉션 하나 더 만들어야함", HttpStatus.BAD_REQUEST);
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
			return "redirect:/user/myinfoEditor";

		}

		return "redirect:/user/myinfoEditor";
	}

	@GetMapping("/sign-in")
	public String signIn() {

		return "user/login";
	}

	@PostMapping("/sign-in")
	public String signInProc(LoginResponseDto loginResponseDto) {

		if (loginResponseDto.getUsername() == null || loginResponseDto.getUsername().isEmpty()) {
			throw new LoginException("아이디를 입력해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (loginResponseDto.getPassword() == null || loginResponseDto.getPassword().isEmpty()) {
			throw new LoginException("비밀번호를 입력해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LoginResponseDto principal = loginService.signIn(loginResponseDto);
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
	public String signUpProc(JoinResponseDto joinResponseDto) {

		if (joinResponseDto.getUsername() == null || joinResponseDto.getUsername().isEmpty()) {
			throw new LoginException("이메일 주소를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getPassword() == null || joinResponseDto.getPassword().isEmpty()) {
			throw new LoginException("비밀번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getTel() == null || joinResponseDto.getTel().isEmpty()) {
			throw new LoginException("전화번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getAddress() == null || joinResponseDto.getAddress().isEmpty()) {
			throw new LoginException("주소를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getEmail() == null || joinResponseDto.getEmail().isEmpty()) {
			throw new LoginException("이메일을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getFirstName() == null || joinResponseDto.getFirstName().isEmpty()) {
			throw new LoginException("성을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getLastName() == null || joinResponseDto.getLastName().isEmpty()) {
			throw new LoginException("이름을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		loginService.createUser(joinResponseDto);

		return "user/login";
	}

	@GetMapping("/withdraw")
	public String withDraw() {

		return "/layout/main";
	}

	@PostMapping("/withdraw")
	public String withDrawProc(LoginResponseDto loginResponseDto) {

		LoginResponseDto principal = loginService.signIn(loginResponseDto);
		principal.setPassword(null);
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/layout/main";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout() {

		session.invalidate();

		return "/layout/main";

	}
>>>>>>> feature/QnA

}
