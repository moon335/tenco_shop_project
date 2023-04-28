package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.exception.LoginException;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

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

	// myinfo에서 유저 정보 select하기
	@Transactional
	public User userInfo(Integer userId) {

		User user = userRepository.userInfoSelect(userId);
		return user;
	}

	// 로그인 서비스
	@Transactional
	public LoginResponseDto signIn(LoginResponseDto loginResponseDto) {
		User userEntity = userRepository.findByUsername(loginResponseDto);
		if (userEntity == null) {
			throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		boolean isMatched = passwordEncoder.matches(loginResponseDto.getPassword(), userEntity.getPassword());
		if (isMatched == false) {
			throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LoginResponseDto dtoResult = new LoginResponseDto();
		dtoResult.setId(userEntity.getId());
		dtoResult.setUsername(userEntity.getUsername());
		dtoResult.setPassword(userEntity.getPassword());
		dtoResult.setImage(userEntity.getImage());
		dtoResult.setRole(userEntity.getRole());

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

	// 회원탈퇴 서비스
	@Transactional
	public void deleteUser(String username) {

		int resultCountRaw = userRepository.delete(username);
		if (resultCountRaw != 1) {
			throw new LoginException("회원 탈퇴가 실패하였습니다. 고객센터로 문의하여 주시기 바랍니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	// myinfo에서 유저 정보 select하기
	@Transactional
	public List<User> userInfoAll() {

		List<User> userList = userRepository.userInfoAll();
		return userList;
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

	// myinfo에서 유저이미지 update하기
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

}
