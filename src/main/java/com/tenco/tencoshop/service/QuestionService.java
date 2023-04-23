package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.QuestionFormDto;
import com.tenco.tencoshop.repository.interfaces.QuestionRepository;
import com.tenco.tencoshop.repository.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	// QnA 보기 
	@Transactional
	public List<Question> readQuestion(){
		List<Question> questList = questionRepository.readQuestion();
		return questList;
	}
	// QnA 검색하여 찾기 
	@Transactional
	public List<Question> searchQuestion(String findWord){
		findWord = "%"+findWord+"%";
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
	public void questionWrting(QuestionFormDto questionFormDto,Integer principalId) {
		Question quest = new Question();
		quest.setTitle(questionFormDto.getTitle());
		quest.setContent(questionFormDto.getContent());
		quest.setReqStatus(0);
		//principle로 수정해야함
//		quest.setUserId(principalId);
		quest.setUserId(1);
		System.out.println(quest +"@2222222222");
		int result = questionRepository.questionWriting(quest);
		if(result !=1) {
			//수정해야함 던져줘야한다.
			System.out.println("QnA등록에 실패하였습니다.");
		}
	}
}
