package com.tenco.tencoshop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

		// 중복체크 (count함수로 0이면 가입가능 1이면 가입불가능)
		if (userRepository.findDuplicatedId(joinResponseDto.getUsername()) == 1) {
			throw new CustomRestfullException("사용중인 아이디입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		joinResponseDto.setPassword(hashPwd);
		if (joinResponseDto.getRole() == null || !joinResponseDto.getRole().isEmpty()) {
			if (!joinResponseDto.getRole().equals("green")) {
				throw new CustomRestfullException("관리자 비밀번호가 일치하지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				resultAdmin = userRepository.insertAdmin(joinResponseDto);
			}
		} else {
			result = userRepository.insertUser(joinResponseDto);
		}
		if (result != 1 && resultAdmin == 0) {
			throw new LoginException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (result == 1 && resultAdmin == 0) {
		}
	}

	// 로그인
	@Transactional
	public LoginResponseDto readUser(LoginResponseDto loginResponseDto) {
		User userEntity = userRepository.findByLoginDto(loginResponseDto);
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
	   public List<ProductRequestDto> readBuyProductList(Integer begin, Integer range, Integer userId) {
	      List<ProductRequestDto> list = userRepository.findBuyList(begin, range, userId);
	      return list;
	   }

	   // myinfo에서 주문한 제품 카운트하기
	   @Transactional
	   public Double readBuyListCount(Integer userId) {

	      Double count = userRepository.findBuyListCount(userId);
	      return count;
	   }

	// 구매목록 조회하기
	@Transactional
	public List<ProductRequestDto> readProductListByProductRequestDto(ProductRequestDto productRequestDto) {
		List<ProductRequestDto> searchList = userRepository.findBuyListByProductRequestDto(productRequestDto);
		return searchList;
	}

	// myinfo에서 유저 정보 특정유저만 select하기
	@Transactional
	public User readUserInfo(Integer userId) {
		User user = userRepository.finduserInfo(userId);
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

	// myinfo에서 유저정보 update하기
	@Transactional
	public int updateUserInfo(UserInfoRequestDto userInfoRequestDto, Integer principalId) {
		User user = new User();
		user.setEmail(userInfoRequestDto.getEmail());
		String rawPwd = userInfoRequestDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		user.setPassword(hashPwd);
		user.setLastName(userInfoRequestDto.getLastName());
		user.setTel(userInfoRequestDto.getTel());
		user.setId(principalId);
		int result = userRepository.updateUserInfo(user);
		if (result != 1) {
			System.out.println("정보 수정에 실패하였습니다.");
		}
		return result;
	}

	// myinfo에서 유저 이미지 update하기
	@Transactional
	public int updateUserInfoImage(UserInfoRequestDto userInfoRequestDto, Integer principalId) {
		LoginResponseDto user = new LoginResponseDto();
		user.setImage(userInfoRequestDto.getUploadFileName());
		user.setId(principalId);
		int result = userRepository.updateUserInfoImage(user);
		if (result != 1) {
			System.out.println("정보 수정에 실패하였습니다.");
		}
		return result;
	}

	// 회원 탈퇴하기
	@Transactional
	public int userDelete(LoginResponseDto loginResponseDto) {
		int result = userRepository.deleteUser(loginResponseDto);
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
		OrderResponseDto orderResponseDto = userRepository.findOrderCount(userId);
		return orderResponseDto;
	}
	
	// myinfo에서 유저 정보 전부 select하기
	   @Transactional
	   public List<User> readAllUserInfo(Integer begin, Integer range) {

	      List<User> userList = userRepository.findAllUserInfo(begin, range);
	      return userList;
	   }

	   // 유저 몇명인지 카운터
	   @Transactional
	   public Double readAllUserCount() {
	      Double userCount = userRepository.findAllUserCount();
	      return userCount;
	   }
	   
	   public List<ProductRequestDto> readSalesList(Integer begin, Integer range) {
		   List<ProductRequestDto> salesList = userRepository.findSalesList(begin, range);
		   return salesList;
	   }
	   
	   public Double readSalesListCount() {
		   Double count = userRepository.findSalesListCount();
		   return count;
	   }
}
