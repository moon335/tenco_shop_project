package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.OrderResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.handler.exception.LoginException;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// 회원가입
	@Transactional
	public void createUser(JoinResponseDto joinResponseDto) {
		String rawPwd = joinResponseDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		int resultAdmin = 0;
		int result = 0;
		joinResponseDto.setPassword(hashPwd);
		if (joinResponseDto.getRole() == null || !joinResponseDto.getRole().isEmpty()) {
			if (!joinResponseDto.getRole().equals("green")) {
				throw new CustomRestfullException("관리자 비밀번호가 일치하지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				resultAdmin = userRepository.signUpAdmin(joinResponseDto);
			}
		} else {
			result = userRepository.signUp(joinResponseDto);
		}
		if (result != 1 && resultAdmin == 0) {
			throw new LoginException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (result == 1 && resultAdmin == 0) {
		}
	}

	// 로그인
	@Transactional
	public LoginResponseDto signIn(LoginResponseDto loginResponseDto) {
		User userEntity = userRepository.findByPassword(loginResponseDto);
		if (userEntity == null) {
			throw new CustomRestfullException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (userEntity.getWithdraw() == 0) {
			throw new CustomRestfullException("탈퇴한 아이디입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		boolean isMatched = passwordEncoder.matches(loginResponseDto.getPassword(), userEntity.getPassword());
		if (isMatched == false) {
			throw new CustomRestfullException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LoginResponseDto dtoResult = new LoginResponseDto();
		dtoResult.setId(userEntity.getId());
		dtoResult.setUsername(userEntity.getUsername());
		dtoResult.setPassword(userEntity.getPassword());
		dtoResult.setImage(userEntity.getImage());
		dtoResult.setRole(userEntity.getRole());
		dtoResult.setWithdraw(userEntity.getWithdraw());

		return dtoResult;
	}

	// myinfo에서 주문한 제품 보기
	@Transactional
	public List<ProductRequestDto> buyProductList(Integer userId) {

		List<ProductRequestDto> list = userRepository.buyList(userId);
		return list;
	}

	// 구매목록 조회하기
	@Transactional
	public List<ProductRequestDto> searchProductList(ProductRequestDto productRequestDto) {
		List<ProductRequestDto> searchList = userRepository.searchBuyList(productRequestDto);
		return searchList;
	}

	// myinfo에서 유저 정보 특정유저만 select하기
	@Transactional
	public User userInfo(Integer userId) {

		User user = userRepository.userInfoSelect(userId);
		return user;
	}

	public User readUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	public User readUserByUserId(Integer userId) {
		User user = userRepository.findByUserId(userId);
		return user;
	}

	// myinfo에서 유저 정보 전부 select하기
	@Transactional
	public List<User> userInfoAll(Integer begin, Integer range) {

		List<User> userList = userRepository.userInfoAll(begin,range);
		return userList;
	}
	
	// 유저 몇명인지 카운터
	@Transactional
	public Double userAllCount() {
		Double userCount = userRepository.userAllCount();
		return userCount;
	}

	// myinfo에서 유저정보 update하기
	@Transactional
	public int userInfoUpdate(UserInfoRequestDto userInfoRequestDto, Integer principalId) {
		User user = new User();
		user.setEmail(userInfoRequestDto.getEmail());
		String rawPwd = userInfoRequestDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		user.setPassword(hashPwd);
		user.setLastName(userInfoRequestDto.getLastName());
		user.setTel(userInfoRequestDto.getTel());
		user.setId(principalId);
		int result = userRepository.userInfoUpdate(user);
		if (result != 1) {
			System.out.println("정보 수정에 실패하였습니다.");
		}
		return result;
	}

	// myinfo에서 유저 이미지 update하기
	@Transactional
	public int userInfoUpdateImage(UserInfoRequestDto userInfoRequestDto, Integer principalId) {
		LoginResponseDto user = new LoginResponseDto();
		user.setImage(userInfoRequestDto.getUploadFileName());
		user.setId(principalId);
		int result = userRepository.userInfoUpdateImage(user);
		if (result != 1) {
			System.out.println("정보 수정에 실패하였습니다.");
		}
		return result;
	}

	// 회원 탈퇴하기
	@Transactional
	public int userDelete(LoginResponseDto loginResponseDto) {
		int result = userRepository.userDelete(loginResponseDto);
		if (result != 1) {
			throw new LoginException("회원탈퇴에 실패하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;

	}

	@Transactional
	public User readUserByUserName(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	// 주문 내역 카운트 하기 (myinfo)
	@Transactional
	public OrderResponseDto orderCounter(Integer userId) {
		OrderResponseDto orderResponseDto = userRepository.orderCounter(userId);
		System.out.println(userId);
		System.out.println(orderResponseDto);
		return orderResponseDto;
	}
}
