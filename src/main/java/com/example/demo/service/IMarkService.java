package com.example.demo.service;

import com.example.demo.request.MarksRequest;

public interface IMarkService {

    void createMarks(MarksRequest request);

    void updateMarks(MarksRequest request);

    boolean deleteMarks(Long id);
}
