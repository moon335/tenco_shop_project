package com.tenco.tencoshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.exception.LoginException;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.User;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// 로그인

	@Transactional
	public LoginResponseDto signIn(LoginResponseDto loginResponseDto) {
		User userEntity = userRepository.findByPassword(loginResponseDto);
		if (userEntity == null) {
			throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		boolean isMatched = passwordEncoder.matches(loginResponseDto.getPassword(), userEntity.getPassword());
		if (isMatched == false) {
			throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (userEntity.getWithdraw() == 0) {
			throw new LoginException("탈퇴한 아이디입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
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
				throw new LoginException("관리자 비밀번호가 일치하지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
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

}
