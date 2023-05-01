package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.OrderResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.repository.model.User;

@Mapper
public interface UserRepository {
	// 구매목록 보기
	public List<ProductRequestDto> buyList(Integer userId);

	// 구매목록 조회하기
	public List<ProductRequestDto> searchBuyList(ProductRequestDto productRequestDto);

	// 유저 정보 보기
	public User userInfoSelect(Integer userId);

	// 유저 정보 전부 보기
	public List<User> userInfoAll(@Param("begin") Integer begin, @Param("range") Integer range);

	// 유저 몇명인지 카운터
	public Double userAllCount();

	// 유저 정보 수정하기
	public int userInfoUpdate(User user);

	// 유저 정보 수정하기 이미지
	public int userInfoUpdateImage(LoginResponseDto loginResponseDto);

	public User findByPassword(LoginResponseDto loginResponseDto);

	public int signUp(JoinResponseDto joinResponseDto);

	// 관리자 계정 회원가입
	public int signUpAdmin(JoinResponseDto joinResponseDto);

	// 유저 회원 탈퇴하기
	public int userDelete(LoginResponseDto loginResponseDto);

	// username 기반 검색
	public User findByUsername(String username);

	public User findByUserId(Integer userId);

	// 판매 내역 보기( 관리자)
	public List<ProductRequestDto> salesList(@Param("begin") Integer begin, @Param("range") Integer range);

	// 판매 내역 카운터하기(관리자)
	public Double salesListCount();

	// 주문 내역 카운터하기 (myinfo)
	public OrderResponseDto orderCounter(Integer userId);

	// 아이디 중복체크
	public int idCheck(String username);
}
