package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.request.TeacherRequest;
import com.example.demo.response.CustomTeacherResponse;

import java.util.List;

public interface ITeacherService {

    Teacher addTeacher(TeacherRequest teacherRequest);

    void updateTeacher(Long id, Teacher teacher);

    boolean deleteTeacher(Long id);

    List<CustomTeacherResponse> getAllTeacher();
}
