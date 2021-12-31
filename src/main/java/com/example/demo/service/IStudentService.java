package com.example.demo.service;
import com.example.demo.model.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.response.CustomStudent1Response;
import com.example.demo.response.CustomStudentResponse;

import java.util.List;

public interface IStudentService {

    void addStudent(StudentRequest studentRequest);

    void updateStudent(long id, Student student);

    boolean deleteStudent(long id);

    List<CustomStudent1Response> findAllStudent();

}
