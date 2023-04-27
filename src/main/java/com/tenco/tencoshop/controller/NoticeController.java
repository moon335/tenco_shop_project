package com.tenco.tencoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.model.Notice;
import com.tenco.tencoshop.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	
	@GetMapping("/list")
	public String notice(Model model) {
		
		List<NoticeResponseDto.BoardTitleDto> list =  noticeService.noticeMain();
		model.addAttribute("list",list);
		return "/notice/notice";
	}
	
	// 공지사항 상세페이지
	@GetMapping("/{id}")
	public String noticeContent(@PathVariable Integer id, Model model) {
		NoticeResponseDto.NoticeContent noticeList = noticeService.noticeContent(id);
		model.addAttribute("noticeList",noticeList);
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
		return "redirect:/notice";
	}
	
	// 공지사항 게시물 삭제페이지
	@GetMapping("/deleteForm")
	public String DeleteForm(Model model) {
		List<NoticeResponseDto.BoardTitleDto> list =  noticeService.noticeMain();
		model.addAttribute("list",list);
		return "/notice/noticeDelete";
	}
	
	 // 공지사항 게시물 삭제	
	 @GetMapping("/delete") 
	 public String noticeDelete(@RequestParam Integer id) {
		 noticeService.deleteNotice(id); 
		 return "redirect:/notice"; 
	 }
	
	 // 공지사항 수정 페이지
	 @GetMapping("/update/{id}")
	 public String noticeUpdate(@PathVariable Integer id, Model model) {
		 NoticeResponseDto.NoticeContent update = noticeService.noticeContent(id);
		 model.addAttribute("update",update);
		 return"/notice/noticeUpdate";
	 }
	 
	 // 공지사항 수정하기
	 @PostMapping("/update/{id}")
	 public String  noticeUpdate(NoticeRequestDto.updateDto updateDto) {
		 noticeService.noticeUpdate(updateDto);
		 return "redirect:/notice";
	 }
	 
	 // 자주묻는질문 페이지
	 @GetMapping("/faq")
	 public String FrequentlyAskedQuestions(Model model) {
		 List<NoticeResponseDto.faqDto> faqList = noticeService.selectFaq();
		 model.addAttribute("faqList",faqList);
		 return "/notice/faq";
	 }
}
