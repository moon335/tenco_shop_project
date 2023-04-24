package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.NoticeResponseDto;

@Mapper
public interface NoticeRepository {

	public List<NoticeResponseDto.BoardTitleDto> findBoardTitle();
		
}
