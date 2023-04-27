package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.QuestionFormDto;
import com.tenco.tencoshop.repository.model.Question;

@Mapper
public interface QuestionRepository {

	public List<Question> readQuestion();
	public List<Question> searchQuestion(String findWord);
	public Question questionDetail(Integer id);
	
	public int questionWriting(Question quest);
	// 질문 수정하기(관리자가 답글달아도 수정)
	public int questionUpdate(Question quest);
}
