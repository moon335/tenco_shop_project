package com.tenco.tencoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/notice")
	public String notice(Model model) {
		
		List<NoticeResponseDto.BoardTitleDto> list =  noticeService.noticeMain();
		model.addAttribute("list",list);
		return "/notice/notice";
	}
	
}
