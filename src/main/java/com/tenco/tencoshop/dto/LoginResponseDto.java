package com.tenco.tencoshop.dto;

<<<<<<< HEAD
=======
import org.springframework.web.multipart.MultipartFile;

>>>>>>> feature/QnA
import lombok.Data;

@Data
public class LoginResponseDto {

<<<<<<< HEAD
	private Integer id;
	private String username;
	private String password;

}
=======
	private int id;
	private String username;
	private String password;

	private String image;
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;

	public String setUpUserImage() {
		return uploadFileName == null ? "/images/myinfo.png" : "/images/uploads/" + uploadFileName;
	}

}
>>>>>>> feature/QnA
