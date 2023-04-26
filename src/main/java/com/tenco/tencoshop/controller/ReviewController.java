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
		List<ReviewResponseDto> reviewList = reviewService.findMyReviewByUserName("cccc");
		model.addAttribute("reviewList", reviewList);
		
		return "/review/myReview";
	}

//	@PostMapping("/myReview-proc")
//	public String myReviewProc(Model model) {
//		List<ProductResponseDto> product = productService.readProduct();
//		model.addAttribute("product", product);
//
//		return "";
//	}

	// 후기 페이지로 이동
	// productId, principal을 매개변수로 받아서 productId기준
	@GetMapping("/reviewInsert/{orderId}")
	public String reviewInsert(Model model, @PathVariable Integer orderId) {

		ProductResponseDto product = reviewService.readByOrderId(orderId);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("product", product);
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/reviewInsert";
	}

	// 후기 올리는 기능
	@PostMapping("/reviewInsert-proc")
	public String reviewInsertProc(ReviewResponseDto reviewResponseDto) {
		List<MultipartFile> fileList = reviewResponseDto.getFileList();

		if (fileList.isEmpty() == false) {

			if (fileList.size() > Define.MAX_FILE_SISE) {
				// 예외 처리 던져주기 "파일 크기는 50MB보다 클 수 없습니다.", HttpStatus.BAD_REQUEST
			}

			try {
				String saveDirectory = Define.UPLOAD_DIRECTORY;
				File dir = new File(saveDirectory);

				if (dir.exists() == false) {
					dir.mkdirs(); // 폴더 없으면 생성해줌 굿 ~
				}

				for (int i = 0; i < fileList.size(); i++) {
					UUID uuid = UUID.randomUUID();

//					 이게 맞음 ? 잘 모르겠다. 
					String fileName = uuid + "_" + fileList.get(i).getOriginalFilename();
					System.out.println("1111111 fileName : " + fileName);
					String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;
					File destination = new File(uploadPath);

					fileList.get(i).transferTo(destination);

					// 콘솔창에 입력은 됨. 로컬 저장소에 파일이 들어가진 않음.
					reviewResponseDto.setOriginFileName(fileList.get(i).getOriginalFilename());
					reviewResponseDto.setUploadFileName(fileName);
				}

			} catch (Exception e) {
				System.out.println("파일 업로드 실패");
			}
		}

		// redirect 추가 ?
		return "redirect:/user/myinfo";
	}
	
	// 내 리뷰 수정 기능
	// /{id}, @PathVariable Integer id
	@GetMapping("/reviewUpdate")
	public String reviewUpdate() {
		
		return "/review/myReviewUpdate";
	}

}