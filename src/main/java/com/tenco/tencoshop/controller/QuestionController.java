package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.repository.model.Question;
import com.tenco.tencoshop.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private HttpSession session;
	@Autowired
	private QuestionService questionService;

	// QnA 모두 검색
	@GetMapping("/find")
	public String findQuestion(Model model) {
		List<Question> questList = questionService.readQuestion();
		if (questList.isEmpty()) {
			model.addAttribute("questList", null);
		} else {
			model.addAttribute("questList", questList);
		}
		return "/user/help";
	}

	// QnA 검색하여찾기
	@GetMapping("/findProc")
	public String findQuestionProc(String findWord, Model model) {
		findWord = "사이";
		List<Question> questList = questionService.searchQuestion(findWord);
		if (questList.isEmpty()) {
			model.addAttribute("questList", null);
		} else {
			model.addAttribute("questList", questList);
		}
		return "/user/help";
	}

}
