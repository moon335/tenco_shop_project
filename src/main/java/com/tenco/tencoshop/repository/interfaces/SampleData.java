package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.SampleUser;

@Mapper
public interface SampleData {
	
	public List<SampleUser> findAll();
	
}
