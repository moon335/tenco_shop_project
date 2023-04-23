package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.repository.interfaces.QuestionRepository;
import com.tenco.tencoshop.repository.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	// QnA 보기 
	public List<Question> readQuestion(){
		List<Question> questList = questionRepository.readQuestion();
		System.out.println(questList+"2222222222222222");
		return questList;
	}
	// QnA 검색하여 찾기 
	public List<Question> searchQuestion(String findWord){
		findWord = "%"+findWord+"%";
		List<Question> questList = questionRepository.searchQuestion(findWord);
		return questList;
	}
}
