package com.tenco.tencoshop.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.AnswerRequsetDto;
import com.tenco.tencoshop.handler.exception.LoginException;
import com.tenco.tencoshop.repository.interfaces.AnswerRepository;
import com.tenco.tencoshop.repository.model.Answer;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	
	/**
	 * QnA 답글 페이지로 이동 
	 * @param questionId
	 * @return
	 */
	@Transactional
	public Answer answerDetailPage(Integer questionId) {
		Answer answer = answerRepository.answerDetail(questionId);
		return answer;
	}
	/**
	 * QnA 답글 다는 기능 
	 * @param answerRequsetDto
	 * @param userId
	 */
	@Transactional
	public void answerWritinng(AnswerRequsetDto answerRequsetDto,Integer userId) {
		Answer answer = new Answer();
		answer.setContent(answerRequsetDto.getContent());
		answer.setQuestionId(answerRequsetDto.getQuestionId());
		answer.setAdminId(userId);
		int result = answerRepository.answerWriting(answer);
		if(result !=1) {
			throw new LoginException("글쓰기에 실패하셨습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
