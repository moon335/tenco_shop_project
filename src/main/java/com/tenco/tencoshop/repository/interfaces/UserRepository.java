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
	public List<ProductRequestDto> findBuyList(@Param("begin") Integer begin, @Param("range") Integer range, @Param("userId") Integer userId);

	// 구매목록 카운터
	public Double findBuyListCount(Integer userId);

	// 구매목록 조회하기
	public List<ProductRequestDto> findBuyListByProductRequestDto(ProductRequestDto productRequestDto);

	// 유저 정보 보기
	public User finduserInfo(Integer userId);

	// 유저 정보 수정하기
	public int updateUserInfo(User user);

	// 유저 정보 수정하기 이미지
	public int updateUserInfoImage(LoginResponseDto loginResponseDto);

	public User findByLoginDto(LoginResponseDto loginResponseDto);

	public int insertUser(JoinResponseDto joinResponseDto);

	// 관리자 계정 회원가입
	public int insertAdmin(JoinResponseDto joinResponseDto);

	// 유저 회원 탈퇴하기
	public int deleteUser(LoginResponseDto loginResponseDto);

	// username 기반 검색
	public User findByUsername(String username);

	public User findByUserId(Integer userId);

	// 판매 내역 보기( 관리자)
	public List<ProductRequestDto> findSalesList(@Param("begin") Integer begin, @Param("range") Integer range);

	// 판매 내역 카운터하기(관리자)
	public Double findSalesListCount();

	// 주문 내역 카운트하기 (myinfo)
	public OrderResponseDto findOrderCount(Integer userId);

	// 아이디 중복체크
	public int findDuplicatedId(String username);

	// 유저 정보 전부 보기
	public List<User> findAllUserInfo(@Param("begin") Integer begin, @Param("range") Integer range);

	// 유저 몇명인지 카운터
	public Double findAllUserCount();
}
