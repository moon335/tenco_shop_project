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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductResponseDtoForReview;
import com.tenco.tencoshop.dto.ReviewRequestDto;
import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.repository.model.Liketo;
import com.tenco.tencoshop.repository.model.Order;
import com.tenco.tencoshop.repository.model.ReviewCategory;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.LiketoService;
import com.tenco.tencoshop.service.OrderService;
import com.tenco.tencoshop.service.ReviewCategoryService;
import com.tenco.tencoshop.service.ReviewService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewCategoryService reviewCategoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private LiketoService liketoService;
	@Autowired
	private OrderService orderService;

	// 구매 내역에 있는 것만 리뷰 쓸 때 사용하기
	@Autowired
	private HttpSession session;

	// 리뷰 게시물 조회 기능
	@GetMapping("/style")
	public String styleOrder(@RequestParam(name = "type", defaultValue = "orderByRecent", required = false) String type,
			Model model) {
		List<ReviewResponseDto> reviewList = reviewService.readReviewByType(type);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		// 리뷰 게시물 조회 기능
		model.addAttribute("reviewList", reviewList);
		// 리뷰 카테고리
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/style";
	}

	// 상품 카테고리 별 출력
	@GetMapping("/prod-category/{reviewCategoryId}")
	public String categoryProd(Model model, @PathVariable Integer reviewCategoryId) {
		List<ReviewResponseDto> reviewList = reviewService.readReviewByProdId(reviewCategoryId);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/style";
	}

	// 리뷰 상세 페이지
	@GetMapping("/detail/{id}")
	public String style(Model model, @PathVariable Integer id) {
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();
		ReviewResponseDto review = reviewService.readDetailById(id);
		
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (principal != null) {
			User user = userService.readUserByUsername(principal.getUsername());
			Liketo heart = liketoService.readByUserIdAndReviewId(user.getId(), id);
			model.addAttribute("heart", heart);
			model.addAttribute("reviewCategoryList", reviewCategoryList);
			model.addAttribute("review", review);
			System.out.println(heart);
			
		} else {
			model.addAttribute("reviewCategoryList", reviewCategoryList);
			model.addAttribute("review", review);
			model.addAttribute("heart", null);
		}
		
		return "/review/detail";
	}

	// myInfo의 내 후기로 들어가기
	@GetMapping("/myReview")
	public String myReview(Model model) {
		// list 받아야 됨 id
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);

		List<ReviewResponseDto> reviewList = reviewService.findMyReviewByUserName(principal.getUsername());
		if (reviewList.isEmpty()) {
			model.addAttribute("reviewList", null);
		} else {
			model.addAttribute("reviewList", reviewList);
		}

		return "/review/myReview";
	}

	// 후기 작성 페이지로 이동
	@GetMapping("/reviewInsert/{orderId}")
	public String reviewInsert(Model model, @PathVariable Integer orderId) {

		ProductResponseDtoForReview product = reviewService.readByOrderId(orderId);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("product", product);
		model.addAttribute("orderId", orderId);
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/reviewInsert";
	}

	// 후기 올리는 기능
	@PostMapping("/reviewInsert-proc")
	public String reviewInsertProc(ReviewRequestDto reviewRequestDto, BindingResult bindingResult) {
		
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		
		MultipartFile file = reviewRequestDto.getFile();
		if (file.isEmpty() == false) {
			
			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("파일 크기가 50MB 이상일 수 없습니다.", HttpStatus.BAD_REQUEST);
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

				File destiination = new File(uploadPath);
				file.transferTo(destiination);

				reviewRequestDto.setOriginFileName(file.getOriginalFilename());
				reviewRequestDto.setUploadFileName(fileName);
			} catch (Exception e) {
				System.out.println("파일 업로드 오류");
			}
		}
		
		if(reviewRequestDto.getOriginFileName() == null || reviewRequestDto.getOriginFileName().isEmpty()) {
			throw new CustomRestfullException("사진을 첨부해주세요", HttpStatus.BAD_REQUEST);
		}
		// orderId 기반으로 상품 id 검색
		Order responseOrder = orderService.readById(reviewRequestDto.getOrderId());
		reviewRequestDto.setProdId(responseOrder.getProductId());
		reviewService.createReview(principal.getUsername(), reviewRequestDto);
		return "redirect:/user/myinfoProc";
	}

	// 내 리뷰 수정페이지로 이동
	@GetMapping("/reviewUpdate/{id}")
	public String reviewUpdate(Model model, @PathVariable Integer id) {
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();
//		ReviewResponseDto review = reviewService.readReviewByUserId(userId); // 세션에서 로그인한 유저 받아와서 처리
		model.addAttribute("reviewCategoryList", reviewCategoryList);
		model.addAttribute("reviewId", id);

		return "/review/myReviewUpdate";
	}

	@PostMapping("/reviewUpdate-proc")
	public String reviewUpdateProc(Model model, Integer id, ReviewRequestDto reviewRequestDto, BindingResult bindingResult) {
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();
		MultipartFile file = reviewRequestDto.getFile();

		if (file.isEmpty() == false) {

			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("파일 크기가 50MB 이상일 수 없습니다.", HttpStatus.BAD_REQUEST);
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

				File destiination = new File(uploadPath);
				file.transferTo(destiination);

				reviewRequestDto.setOriginFileName(file.getOriginalFilename());
				reviewRequestDto.setUploadFileName(fileName);
			} catch (Exception e) {
				System.out.println("파일 업로드 오류");
			}
		}
		
		if(reviewRequestDto.getOriginFileName() == null || reviewRequestDto.getOriginFileName().isEmpty()) {
			throw new CustomRestfullException("사진을 첨부해주세요", HttpStatus.BAD_REQUEST);
		}
		reviewService.updateMyReviewById(id, reviewRequestDto);
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "redirect:/review/myReview";
	}

	// 리뷰 삭제 기능
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		reviewService.deleteMyReviewById(id);

		return "redirect:/review/myReview";
	}

	// detail에서 게시물을 쓴 사람의 스타일로 이동
	@GetMapping("/author-style/{username}")
	public String authorStyle(Model model, @PathVariable String username) {
		List<ReviewResponseDto> reviewList = reviewService.findReviewByUsername(username);
		User user = userService.readUserByUserName(username);

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("user", user);
		return "/review/authorReview";
	}
	
	// validation 처리
	@GetMapping("/delete-heart/{id}/{reviewId}/{type}")
	public String deleteHeart(@PathVariable Integer id, @PathVariable Integer reviewId, @PathVariable String type) {
		liketoService.deleteById(id, reviewId, type);
		
		return "redirect:/review/detail/" + reviewId;
	}

	@PostMapping("/insert-heart")
	public String insertHeart(Liketo liketo, @RequestParam(name = "type", defaultValue = "plus", required = false) String type) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		
		User user = userService.readUserByUsername(principal.getUsername());
		liketo.setUserId(user.getId());
		liketoService.createLiketoByUserId(liketo, type);
		
		return "redirect:/review/detail/" + liketo.getReviewId();
	}
	

}