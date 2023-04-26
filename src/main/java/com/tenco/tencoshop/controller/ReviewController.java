package com.tenco.tencoshop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.ReviewRequestDto;
import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.repository.model.ReviewCategory;
import com.tenco.tencoshop.service.ProductService;
import com.tenco.tencoshop.service.ReviewCategoryService;
import com.tenco.tencoshop.service.ReviewService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewCategoryService reviewCategoryService;
	@Autowired
	private ProductService productService;

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
		model.addAttribute("reviewCategoryList", reviewCategoryList);
		model.addAttribute("review", review);

		// redirect 수정할 수도 있음.
		return "/review/detail";
	}

	// myInfo의 내 후기로 들어가기
	@GetMapping("/myReview")
	public String myReview(Model model) {
		// list 받아야 됨 id
		
//		ReviewResponseDto principal = (ReviewResponseDto)session.getAttribute(Define.PRINCIPAL);
		
		List<ReviewResponseDto> reviewList = reviewService.findMyReviewByUserName("aaaa");
//		System.out.println(reviewList.get(0).getOriginFileName());
		model.addAttribute("reviewList", reviewList);

		return "/review/myReview";
	}

	// 후기 작성 페이지로 이동
	@GetMapping("/reviewInsert/{orderId}")
	public String reviewInsert(Model model, @PathVariable Integer orderId) {

		ProductResponseDto product = reviewService.readByOrderId(orderId);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("product", product);
		model.addAttribute("orderId", orderId);
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/reviewInsert";
	}

	// 후기 올리는 기능
	@PostMapping("/reviewInsert-proc")
	public String reviewInsertProc(ReviewRequestDto reviewRequestDto, ReviewResponseDto reviewResponseDto) {
//		session.getAttribute(Define.PRINCIPAL);

		List<MultipartFile> files = reviewRequestDto.getFiles();
		if (files.isEmpty() == false) {

			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).getSize() > Define.MAX_FILE_SIZE) {
					// 예외처리 : "파일 크기가 50MB 이상일 수 없습니다.", HttpStatus.BAD_REQUEST
				}
			}

			try {
				String saveDirectory = Define.UPLOAD_DIRECTORY;
				File dir = new File(saveDirectory);

				if (dir.exists() == false) {
					dir.mkdirs();
				}

				UUID uuid = UUID.randomUUID();
				for (int i = 0; i < files.size(); i++) {
					String fileName = uuid + "_" + files.get(i).getOriginalFilename();
					String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;

					File destiination = new File(uploadPath);
					files.get(i).transferTo(destiination);

					reviewRequestDto.setOriginFileName(files.get(i).getOriginalFilename());
					reviewRequestDto.setUploadFileName(fileName);
				}
			} catch (Exception e) {
				System.out.println("파일 업로드 오류");
			}
		}
		reviewService.createReview("aaaa", reviewRequestDto);
		return "redirect:/user/myinfo";
	}

	// 내 리뷰 수정 기능
	@GetMapping("/reviewUpdate")
	public String reviewUpdate(Model model) {
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("reviewCategoryList", reviewCategoryList);
		
		return "/review/myReviewUpdate";
	}
	
	@PostMapping("/reviewUpdate-proc")
	public String reviewUpdateProc(Model model, @PathVariable Integer orderId, ReviewRequestDto reviewRequestDto) {
		
		ProductResponseDto product = reviewService.readByOrderId(orderId);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("product", product);
		model.addAttribute("reviewCategoryList", reviewCategoryList);
		
		List<MultipartFile> files = reviewRequestDto.getFiles();
		if (files.isEmpty() == false) {

			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).getSize() > Define.MAX_FILE_SIZE) {
					// 예외처리 : "파일 크기가 50MB 이상일 수 없습니다.", HttpStatus.BAD_REQUEST
				}
			}

			try {
				String saveDirectory = Define.UPLOAD_DIRECTORY;
				File dir = new File(saveDirectory);

				if (dir.exists() == false) {
					dir.mkdirs();
				}

				UUID uuid = UUID.randomUUID();
				for (int i = 0; i < files.size(); i++) {
					String fileName = uuid + "_" + files.get(i).getOriginalFilename();
					String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;

					File destiination = new File(uploadPath);
					files.get(i).transferTo(destiination);

					reviewRequestDto.setOriginFileName(files.get(i).getOriginalFilename());
					reviewRequestDto.setUploadFileName(fileName);
				}
			} catch (Exception e) {
				System.out.println("파일 업로드 오류");
			}
		}
		
		return "redirect:/review/myReview";
	}

}