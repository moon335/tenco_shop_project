package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Question;

@Mapper
public interface QuestionRepository {

	public List<Question> readQuestion();
	public List<Question> searchQuestion(String findWord);
	public Question questionDetail(Integer id);
}
