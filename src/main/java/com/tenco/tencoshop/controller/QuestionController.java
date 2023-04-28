package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.QuestionFormDto;
import com.tenco.tencoshop.repository.model.Answer;
import com.tenco.tencoshop.repository.model.Question;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.AnswerService;
import com.tenco.tencoshop.service.QuestionService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private HttpSession session;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private UserService userService;

	// QnA 모두 검색
	@GetMapping("/find")
	public String findQuestion(Model model) {
		List<Question> questList = questionService.readQuestion();
		LoginResponseDto user = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (user == null) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", user);
		}
		if (questList.isEmpty()) {
			model.addAttribute("questList", null);
		} else {
			model.addAttribute("questList", questList);
		}
		return "/user/question";
	}

	// QnA 검색하여찾기
	@PostMapping("/findProc")
	public String findQuestionProc(String findWord, Model model) {
		List<Question> questList = questionService.searchQuestion(findWord);
		if (questList.isEmpty()) {
			model.addAttribute("questList", null);
		} else {
			model.addAttribute("questList", questList);
		}
		return "/user/question";
	}

	// QnA 상세 정보 들어가기
	@GetMapping("/detail")
	public String questionDetail(@RequestParam Integer id, Model model) {
		Question quest = questionService.questionDetailPage(id);
		Answer answer = answerService.answerDetailPage(id);
		LoginResponseDto user = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		if (user == null) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", user);
		}
		if (answer == null) {
			model.addAttribute("answer", null);
		} else {
			model.addAttribute("answer", answer);
		}

		if (quest.getId() == null) {
			model.addAttribute("quest", null);
		} else {
			model.addAttribute("quest", quest);
		}
		return "/user/questionDetail";
	}

	// QnA 작성하기
	@PostMapping("/writing")
	public String questionWriting(QuestionFormDto questionFormDto) {
		LoginResponseDto userId = (LoginResponseDto) session.getAttribute(Define.PRINCIPAL);
		questionService.questionWriting(questionFormDto, userId.getId());
		return "redirect:/question/find";
	}

	@GetMapping("/delete")
	public String questionDelete(Integer id) {
		questionService.questionDelete(id);
		return "redirect:/question/find";
	}
}
