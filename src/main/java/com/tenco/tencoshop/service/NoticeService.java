package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.NoticeRequestDto;
import com.tenco.tencoshop.dto.NoticeResponseDto;
import com.tenco.tencoshop.repository.interfaces.NoticeRepository;
import com.tenco.tencoshop.repository.model.Faq;

@Service
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;

	@Transactional
	public List<NoticeResponseDto.BoardTitleDto> readNoticeMain() {

		List<NoticeResponseDto.BoardTitleDto> list = noticeRepository.findBoardTitle();
		return list;

	}

	// 공지사항 상세페이지
	@Transactional
	public NoticeResponseDto.NoticeContent readNoticeContent(Integer id) {
		NoticeResponseDto.NoticeContent noticeList = noticeRepository.findNoticeContent(id);
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
	public void updateNotice(NoticeRequestDto.updateDto updateDto) {
		int result = noticeRepository.updateNotice(updateDto);
	}

	// 자주 묻는 질문
	@Transactional
	public List<NoticeResponseDto.faqDto> readAllFaq() {
		List<NoticeResponseDto.faqDto> list = noticeRepository.findAllFaq();
		return list;
	}

	// 자주 묻는 질문
	@Transactional
	public List<NoticeResponseDto.faqDto> readFaqCategory(String category) {
		category = "%" + category + "%";
		List<NoticeResponseDto.faqDto> list = noticeRepository.findFaqCategory(category);
		return list;
	}
	
	// 자주 묻는 질문 검색
	@Transactional
	public List<Faq> readFaq(String find) {
		find = "%" + find + "%";
		List<Faq> list = noticeRepository.findFaq(find);
		return list;
	}

}
