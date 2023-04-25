package com.tenco.tencoshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.User;

@Service
public class LoginService {

   @Autowired
   private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Transactional
   public LoginResponseDto signIn(LoginResponseDto loginResponseDto) {
      User userEntity = userRepository.findByPassword(loginResponseDto);
      boolean isMatched = passwordEncoder.matches(loginResponseDto.getPassword(), userEntity.getPassword());
      System.out.println(loginResponseDto.getPassword());
      
      if (isMatched == false) {
         throw new LoginException("아이디 혹은 비밀번호가 틀렸습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
      }
      LoginResponseDto dtoResult = new LoginResponseDto();
      dtoResult.setUsername(userEntity.getUsername());
      dtoResult.setPassword(userEntity.getPassword());
      
      return dtoResult;
   }

   @Transactional
   public void createUser(JoinResponseDto joinResponseDto) {
      String rawPwd = joinResponseDto.getPassword();
      String hashPwd = passwordEncoder.encode(rawPwd);
      joinResponseDto.setPassword(hashPwd);

      int result = userRepository.insert(joinResponseDto);
      
      if (result != 1) {
         throw new LoginException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
   @Transactional
   public void deleteUser(LoginResponseDto loginResponseDto) {
      LoginResponseDto dtoResult = new LoginResponseDto();
      User userEntity = userRepository.findByPassword(loginResponseDto);
      System.out.println(userEntity);
      String userPassword = dtoResult.getPassword();
      System.out.println(userPassword);
   }
}