package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;

@Mapper
public interface NoticeRepository {

	public List<NoticeResponseDto.BoardTitleDto> findBoardTitle();
	//공지사항 상세페이지
	public NoticeResponseDto.NoticeContent noticeContent(Integer id);
	
	public int insert(NoticeRequestDto.insertDto insertDto);
}
