package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.model.Faq;

@Mapper
public interface NoticeRepository {

	public List<NoticeResponseDto.BoardTitleDto> findBoardTitle();
	//공지사항 상세페이지
	public NoticeResponseDto.NoticeContent findNoticeContent(Integer id);
	// 공지사항 작성
	public int insert(NoticeRequestDto.insertDto insertDto);
	// 공지사항 삭제
	public int delete(Integer id);
	// 공지사항 수정
	public int updateNotice(NoticeRequestDto.updateDto updateDto);
	// 자주묻는질문페이지
	public List<NoticeResponseDto.faqDto> findAllFaq();
	 
	public List<NoticeResponseDto.faqDto> findFaqCategory(String category);
	
	public List<Faq> findFaq(String find);
	
}
