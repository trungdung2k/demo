package com.example.demo.service;
import com.example.demo.entity.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.CustomStudent1Response;

import java.util.List;

public interface IStudentService {

    void addStudent(StudentRequest studentRequest);

    void updateStudent(StudentRequest request);

    boolean deleteStudent(long id);

    List<CustomStudent1Response> findAllStudent();

}
