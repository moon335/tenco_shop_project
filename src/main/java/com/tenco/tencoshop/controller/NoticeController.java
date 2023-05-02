package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.model.Faq;
import com.tenco.tencoshop.service.NoticeService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/notice")
@Validated
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private HttpSession session;

	@GetMapping("/list")
	public String notice(Model model) {
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		List<NoticeResponseDto.BoardTitleDto> list = noticeService.noticeMain();
		model.addAttribute("list", list);
		model.addAttribute("user", principal);
		return "/notice/notice";
	}

	// 공지사항 상세페이지
	@GetMapping("/{id}")
	public String noticeContent(@PathVariable Integer id, Model model) {
		NoticeResponseDto.NoticeContent noticeList = noticeService.noticeContent(id);
		model.addAttribute("noticeList", noticeList);
		return "/notice/noticeDetail";
	}

	// 공지사항 작성 페이지
	@GetMapping("/noticeForm")
	public String noticeForm() {
		return "/notice/noticeForm";
	}

	// 공지사항 작성 제출
	@PostMapping("/insert")
	public String noticeInsert(NoticeRequestDto.insertDto insertDto) {
		noticeService.insertNotice(insertDto);
		return "redirect:/notice/list";
	}

	// 공지사항 게시물 삭제페이지
	@GetMapping("/deleteForm")
	public String DeleteForm(Model model) {
		List<NoticeResponseDto.BoardTitleDto> list = noticeService.noticeMain();
		model.addAttribute("list", list);
		return "/notice/noticeDelete";
	}

	// 공지사항 게시물 삭제
	@GetMapping("/delete")
	public String noticeDelete(@RequestParam Integer id) {
		noticeService.deleteNotice(id);
		return "redirect:/notice/list";
	}

	// 공지사항 수정 페이지
	@GetMapping("/update/{id}")
	public String noticeUpdate(@PathVariable Integer id, Model model) {
		NoticeResponseDto.NoticeContent update = noticeService.noticeContent(id);
		model.addAttribute("update", update);
		return "/notice/noticeUpdate";
	}

	// 공지사항 수정하기
	@PostMapping("/update/{id}")
	public String noticeUpdate(NoticeRequestDto.updateDto updateDto) {
		noticeService.noticeUpdate(updateDto);
		return "redirect:/notice/list";
	}

	// 자주묻는질문 페이지

	@GetMapping("/faq")
	public String FrequentlyAskedQuestions(Model model) {
		List<NoticeResponseDto.faqDto> faqList = noticeService.selectFaq();
		LoginResponseDto principal = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		model.addAttribute("user", principal);
		model.addAttribute("faqList", faqList);
		return "/notice/faq";
	}

	// faq페이지 카테고리
	@GetMapping("/categorySelect")
	public String faqCategorySelect(Model model,
			@RequestParam(name = "type", defaultValue = "all", required = false) String type) {
		if (type.equals("all")) {
			List<NoticeResponseDto.faqDto> faqList = noticeService.selectFaq();
			model.addAttribute("faqList", faqList);
		} else {
			List<NoticeResponseDto.faqDto> faqList = noticeService.selectFaqCategory(type);
			model.addAttribute("faqList", faqList);
		}
		return "/notice/faq";
	}

	// validation 처리
	@GetMapping("/findProc")
	public String findFaq(@RequestParam String find, Model model) {
		List<Faq> faqList = noticeService.findFaq(find);
		if (faqList.isEmpty()) {
			model.addAttribute("faqList", null);
		} else {
			model.addAttribute("faqList", faqList);
		}
		return "/notice/faq";
	}

}
