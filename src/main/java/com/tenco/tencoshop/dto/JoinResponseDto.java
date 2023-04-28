package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class JoinResponseDto {
   
   private String username;
   private String password;
   private String tel;
   private String address;
   private String email;
   private String firstName;
   private String lastName;
   private String role;
   
}
