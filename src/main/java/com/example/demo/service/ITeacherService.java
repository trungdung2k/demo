package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.request.TeacherRequest;
import com.example.demo.response.CustomTeacherResponse;

import java.util.List;

public interface ITeacherService {

     void addTeacher(TeacherRequest request);

    void updateTeacher(TeacherRequest request);

    boolean deleteTeacher(Long id);

    List<CustomTeacherResponse> getAllTeacher();
}
