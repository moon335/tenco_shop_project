package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// myinfo에서 주문한 제품 보기
	public List<Product> buyProductList(Integer userId) {

		List<Product> list = userRepository.buyList(userId);
		return list;
	}

	// myinfo에서 유저 정보 select하기
	public User userInfo(Integer userId) {
		userId=1;
		User user = userRepository.userInfoSelect(userId);
		return user;
	}
	
	// 로그인 서비스
	@Transactional
	public LoginResponseDto signIn(LoginResponseDto loginResponseDto) {
		User userEntity = userRepository.findByUsername(loginResponseDto);
		if(userEntity == null) {
			throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		boolean isMatched = passwordEncoder.matches(loginResponseDto.getPassword(), userEntity.getPassword());
		if (isMatched == false) {
			throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LoginResponseDto dtoResult = new LoginResponseDto();
		dtoResult.setUsername(userEntity.getUsername());
		dtoResult.setPassword(userEntity.getPassword());
		
		return dtoResult;
	}
	// 회원가입 서비스
	// 예외처리 할거
	// 이미 가입된 아이디
	// 아이디 형식(영문, 소문자, 특수기호, 금칙어)
	// 비밀번호 형식(영문 대,소문자, 숫자, 특수기호)
	@Transactional
	public void createUser(JoinResponseDto joinResponseDto) {
		String rawPwd = joinResponseDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		joinResponseDto.setPassword(hashPwd);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+joinResponseDto);
		int result = userRepository.insert(joinResponseDto);
		
		
		if (result != 1) {
			throw new LoginException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// 회원탈퇴 서비스
	@Transactional
	public void deleteUser(String username) {
		
		int resultCountRaw = userRepository.delete(username);
		if(resultCountRaw != 1) {
			throw new LoginException("회원 탈퇴가 실패하였습니다. 고객센터로 문의하여 주시기 바랍니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
