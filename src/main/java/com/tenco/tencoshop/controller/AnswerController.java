package com.tenco.tencoshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private HttpSession session;
	@Autowired
	private QuestionService questionService;

	// 질문 답글 달기
	@GetMapping("/answerWriting")
	public String helpWriting(@RequestParam Integer id, Model model) {
		Question quest = questionService.readQuestionDetail(id);
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
	public String answerWriting(@RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, AnswerRequsetDto answerRequsetDto,
			QuestionResponseDto questionResponseDto) {
		LoginResponseDto userId = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		questionService.updateQuestion(questionResponseDto, answerRequsetDto, userId.getId());
		answerService.createAnswer(answerRequsetDto, userId.getId());
		questionService.readQuestion(begin, range);
		return "redirect:/admin/find?currentPage=1&begin=0&range=5";
	}
}
