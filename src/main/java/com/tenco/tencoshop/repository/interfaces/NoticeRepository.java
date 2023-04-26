package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.model.Notice;

@Mapper
public interface NoticeRepository {

	public List<NoticeResponseDto.BoardTitleDto> findBoardTitle();
	//공지사항 상세페이지
	public NoticeResponseDto.NoticeContent noticeContent(Integer id);
	// 공지사항 작성
	public int insert(NoticeRequestDto.insertDto insertDto);
	// 공지사항 삭제
	public int delete(Integer id);
	 
	
	
}
