package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.model.CourseModel;

public interface CourseService {
	
	CourseModel selectCourse(String id);
	List<CourseModel> selectAllCourse();
}
