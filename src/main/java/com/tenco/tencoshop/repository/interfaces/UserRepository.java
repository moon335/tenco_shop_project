package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.repository.model.User;

@Mapper
public interface UserRepository {
	
	public User findByUsername(LoginResponseDto loginResponseDto);
	public int insert(JoinResponseDto joinResponseDto);
	public int delete(String username);
	
	// 구매목록 보기
	public List<ProductRequestDto> buyList(Integer userId);

	// 구매목록 조회하기
	public List<ProductRequestDto> searchBuyList(ProductRequestDto productRequestDto);

	// 유저 정보 보기
	public User userInfoSelect(Integer userId);
	
	// 유저 정보 전부 보기
	public List<User> userInfoAll();

	// 유저 정보 수정하기
	public int userInfoUpdate(User user);

	// 유저 정보 수정하기 이미지
	public int userInfoUpdateImage(LoginResponseDto loginResponseDto);

	public User findByPassword(LoginResponseDto loginResponseDto);

	public int signUp(JoinResponseDto joinResponseDto);

	// 관리자 계정 회원가입
	public int signUpAdmin(JoinResponseDto joinResponseDto);
	
	public User findByUserName(String username);
	
	
}
