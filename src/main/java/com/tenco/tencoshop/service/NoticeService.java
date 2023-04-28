package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.interfaces.NoticeRepository;
import com.tenco.tencoshop.repository.model.Notice;

@Service
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;

	@Transactional
	public List<NoticeResponseDto.BoardTitleDto> noticeMain() {

		List<NoticeResponseDto.BoardTitleDto> list = noticeRepository.findBoardTitle();
		return list;

	}

	// 공지사항 상세페이지
	@Transactional
	public NoticeResponseDto.NoticeContent noticeContent(Integer id) {
		NoticeResponseDto.NoticeContent noticeList = noticeRepository.noticeContent(id);
		return noticeList;
	}

	// 공지사항 작성
	@Transactional
	public void insertNotice(NoticeRequestDto.insertDto insertDto) {
		int result = noticeRepository.insert(insertDto);
	}

	// 공지사항 삭제
	@Transactional
	public void deleteNotice(Integer id) {
		int delete = noticeRepository.delete(id);
		if (delete != 1) {
			System.out.println("삭제안됨");
		}
	}

	// 공지사항 수정
	@Transactional
	public void noticeUpdate(NoticeRequestDto.updateDto updateDto) {
		int result = noticeRepository.noticeUpdate(updateDto);
	}

	// 자주 묻는 질문
	public List<NoticeResponseDto.faqDto> selectFaq() {
		List<NoticeResponseDto.faqDto> list = noticeRepository.selectFaq();
		return list;
	}

	// 자주 묻는 질문
	public List<NoticeResponseDto.faqDto> selectFaqCategory(String category) {
		category = "%" + category + "%";
		List<NoticeResponseDto.faqDto> list = noticeRepository.selectFaqCategory(category);
		return list;
	}

}
