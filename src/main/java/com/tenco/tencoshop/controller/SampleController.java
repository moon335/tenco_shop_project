package com.tenco.tencoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.repository.interfaces.SampleData;
import com.tenco.tencoshop.repository.model.SampleUser;

@Controller
@RequestMapping("/test")
public class SampleController {
	
	@Autowired
	private SampleData sampleData;
	
	@GetMapping("/main")
	public String main(Model model) {
		List<SampleUser> list = sampleData.findAll();
		
		model.addAttribute("list", list);
		return "/user/index";
	}
	
	
} // end of class
