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
	public List<Question> readQuestion(Integer begin, Integer range) {
		List<Question> questList = questionRepository.findQuestion(begin, range);
		return questList;
	}

	// QnA 카운터 하기
	public Double questionCount() {
		Double count = questionRepository.findQuestionCount();
		return count;
	}

	// QnA 검색하여 찾기
	@Transactional
	public List<Question> searchQuestion(String findWord) {
		findWord = "%" + findWord + "%";
		List<Question> questList = questionRepository.findQuestionByWord(findWord);
		return questList;
	}

	// QnA 상세 정보 들어가기
	public Question readQuestionDetail(Integer id) {
		Question quest = questionRepository.findQuestionDetail(id);
		return quest;
	}

	// QnA 작성하기
	@Transactional
	public void createQuestion(QuestionFormDto questionFormDto, Integer principalId) {
		Question quest = new Question();
		quest.setTitle(questionFormDto.getTitle());
		quest.setContent(questionFormDto.getContent());
		quest.setReqStatus(0);
		quest.setUserId(principalId);
		int result = questionRepository.insertQuestion(quest);
		if (result != 1) {
			throw new CustomRestfullException("글쓰기에 실패하셨습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 질문에 답글달리면 상태 변경하기
	@Transactional
	public void updateQuestion(QuestionResponseDto questionResponseDto, AnswerRequsetDto answerRequsetDto,
			Integer principalId) {
		Question quest = new Question();
		quest.setTitle(questionResponseDto.getQuestionTitle());
		quest.setContent(questionResponseDto.getQuestionContent());
		quest.setReqStatus(1);
		quest.setUserId(questionResponseDto.getQuestionUserId());
		quest.setId(answerRequsetDto.getQuestionId());
		int result = questionRepository.updateQuestion(quest);
		if (result != 1) {
			System.out.println("수정실패");
		}
	}

	// 질문 삭제하기
	@Transactional
	public void questionDelete(Integer id) {
		int result = questionRepository.deleteQuestion(id);
		if (result != 1) {
			System.out.println("수정 실패 ");
		}
	}
}
