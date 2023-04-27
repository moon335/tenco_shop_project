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

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.exception.LoginException;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.AdminService;
import com.tenco.tencoshop.service.LoginService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired // DI 처리
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private AdminService adminService;

	// 관리자가 유저 정보 들어가기
	@GetMapping("/userList")
	public String buyList(Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			throw new LoginException("로그인 먼저해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		userId = principal.getId();
		List<ProductRequestDto> orderList = userService.buyProductList(principal.getId());
		User user = userService.userInfo(principal.getId());
		model.addAttribute("user", user);
		List<User> userList = userService.userInfoAll();
		model.addAttribute("userList", userList);
		System.out.println(userList + "!1111111111111111111");
		if (userList.isEmpty()) {
			model.addAttribute("userList", null);
		} else {
			model.addAttribute("userList", userList);
		}
		return "/admin/userList";
	}

	// 내 정보 수정 화면 들어가기
	@GetMapping("/adminInfoEditor")
	public String myinfoEditor(Integer userId, Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		User user = userService.userInfo(principal.getId());
		model.addAttribute("user", user);
		user.getPassword();
		return "/admin/adminInfoEditor";
	}

	// 내 정보 수정하기
	@PostMapping("/myinfoupdate")
	public String myinfoUpdate(UserInfoRequestDto userInfoRequestDto) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		userService.userInfoUpdate(userInfoRequestDto, principal.getId());
		if (principal.getPassword().equals(userInfoRequestDto.getPassword()) == false) {
			session.invalidate();
			return "redirect:/user/sign-in";
		}

		return "redirect:/admin/adminInfoEditor";
	}

	// 내정보 이미지 넣기
	@PostMapping("/adminInfoupdateimage")
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

	@GetMapping("/admin")
	public String signInAdmin(Integer userId, Model model) {
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
		return "/admin/admin";
	}
	
	
	@GetMapping("salesList")
	public String salesList(Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		User user = userService.userInfo(principal.getId());
		List<Product> salesList = adminService.findProductAll();
		model.addAttribute("user", user);
		if (salesList.isEmpty()) {
			model.addAttribute("salesList", null);
		} else {
			model.addAttribute("salesList", salesList);
		}
		return "/admin/salesList";

	}

	
}