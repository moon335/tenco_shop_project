package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.repository.model.Question;

@Mapper
public interface QuestionRepository {

	// 질문 전부 나열하기 
	public List<Question> readQuestion(@Param("begin") Integer begin,@Param("range") Integer range);
	
	// 질문 카운터 하기
	public Double questionCount();

	// 질문 검색 
	public List<Question> searchQuestion(String findWord);

	// 질문 하나 상세보기 
	public Question questionDetail(Integer id);
	
	// 질문 적기 
	public int questionWriting(Question quest);

	// 질문 수정하기(관리자가 답글달아도 수정)
	public int questionUpdate(Question quest);

	// 질문 삭제하기
	public int questionDelete(Integer id);
}
