package com.example.demo.service;

import com.example.demo.request.SubjectRequest;
import com.example.demo.response.CustomSubjectResponse;

import java.util.List;

public interface ISubjectService {
    void AddSubject(SubjectRequest request);

    void UpdateSubject(SubjectRequest request);

    boolean deleteSubject(Long id);

    List<CustomSubjectResponse> listSubject();
}
