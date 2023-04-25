package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.interfaces.NoticeRepository;

@Service
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	@Transactional
	public List<NoticeResponseDto.BoardTitleDto> noticeMain(){
		
		List<NoticeResponseDto.BoardTitleDto> list = noticeRepository.findBoardTitle();
		return list;
		
	}
	
	// 공지사항 상세페이지
	@Transactional
	public NoticeResponseDto.NoticeContent noticeContent(Integer id){
		NoticeResponseDto.NoticeContent noticeList = noticeRepository.noticeContent(id);
		return noticeList;
	}
	
	
	
}
