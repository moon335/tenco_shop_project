package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.AnswerRequsetDto;
import com.tenco.tencoshop.dto.QuestionFormDto;
import com.tenco.tencoshop.dto.QuestionResponseDto;
import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.repository.interfaces.QuestionRepository;
import com.tenco.tencoshop.repository.model.Question;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	// QnA 보기
	@Transactional
	public List<Question> readQuestion(Integer begin, Integer range) {
		List<Question> questList = questionRepository.readQuestion(begin, range);
		return questList;
	}
	// QnA 카운터 하기
	@Transactional
	public Double questionCount() {
		Double count = questionRepository.questionCount();
		return count;
	}

	// QnA 검색하여 찾기
	@Transactional
	public List<Question> searchQuestion(String findWord) {
		findWord = "%" + findWord + "%";
		List<Question> questList = questionRepository.searchQuestion(findWord);
		return questList;
	}

	// QnA 상세 정보 들어가기
	@Transactional
	public Question questionDetailPage(Integer id) {
		Question quest = questionRepository.questionDetail(id);
		return quest;
	}

	// QnA 작성하기
	@Transactional
	public void questionWriting(QuestionFormDto questionFormDto, Integer principalId) {
		Question quest = new Question();
		quest.setTitle(questionFormDto.getTitle());
		quest.setContent(questionFormDto.getContent());
		quest.setReqStatus(0);
		quest.setUserId(principalId);
		int result = questionRepository.questionWriting(quest);
		if (result != 1) {
			throw new CustomRestfullException("글쓰기에 실패하셨습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 질문에 답글달리면 상태 변경하기 
	@Transactional
	public void questionUpdate(QuestionResponseDto questionResponseDto,AnswerRequsetDto answerRequsetDto, Integer principalId) {
		Question quest = new Question();
		quest.setTitle(questionResponseDto.getQuestionTitle());
		quest.setContent(questionResponseDto.getQuestionContent());
		quest.setReqStatus(1);
		quest.setUserId(questionResponseDto.getQuestionUserId());
		quest.setId(answerRequsetDto.getQuestionId());
		int result = questionRepository.questionUpdate(quest);
		if (result != 1) {
			System.out.println("수정실패");
		}
	}
	
	// 질문 삭제하기 
	@Transactional
	public void questionDelete(Integer id) {
		int result = questionRepository.questionDelete(id);
		if(result != 1) {
			System.out.println("수정 실패 ");
		}
	}
}
