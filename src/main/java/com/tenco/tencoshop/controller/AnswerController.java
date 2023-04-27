package com.tenco.tencoshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.AnswerRequsetDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.QuestionResponseDto;
import com.tenco.tencoshop.repository.model.Question;
import com.tenco.tencoshop.service.AnswerService;
import com.tenco.tencoshop.service.QuestionService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private HttpSession session;
	@Autowired
	private QuestionService questionService;
	
	// 질문 글쓰기
	@GetMapping("/answerWriting")
	public String helpWriting(@RequestParam Integer id,Model model) {
		Question quest = questionService.questionDetailPage(id);
		model.addAttribute("id", id);
		if (quest.getId() == null) {
			model.addAttribute("quest", null);
		} else {
			model.addAttribute("quest", quest);
		}
		return "/admin/answerWriting";
	}

	// QnA 답글달기
	@PostMapping("/writing")
	public String answerWriting(AnswerRequsetDto answerRequsetDto,QuestionResponseDto questionResponseDto)  {
		LoginResponseDto userId = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		questionService.questionUpdate(questionResponseDto,answerRequsetDto, userId.getId());
		answerService.answerWritinng(answerRequsetDto, userId.getId());
		questionService.readQuestion();
		return "redirect:/question/find";
	}
}
