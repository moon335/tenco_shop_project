package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.repository.model.Question;

@Mapper
public interface QuestionRepository {

	// 질문 전부 나열하기
	public List<Question> findQuestion(@Param("begin") Integer begin, @Param("range") Integer range);

	// 질문 카운터 하기
	public Double findQuestionCount();

	// 질문 검색
	public List<Question> findQuestionByWord(String findWord);

	// 질문 하나 상세보기
	public Question findQuestionDetail(Integer id);

	// 질문 적기
	public int insertQuestion(Question quest);

	// 질문 수정하기
	public int updateQuestion(Question quest);

	// 질문 삭제하기
	public int deleteQuestion(Integer id);
}
