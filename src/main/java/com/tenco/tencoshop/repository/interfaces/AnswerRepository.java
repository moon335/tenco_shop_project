package com.tenco.tencoshop.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Answer;
@Mapper
public interface AnswerRepository {

	public Answer answerDetail(Integer questionId);
	
	public int answerWriting(Answer answer);
}
