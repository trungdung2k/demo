package com.example.demo.repository;

import com.example.demo.model.Faculty;

import java.util.List;


public interface CustomFacultyRepository {
    List<Faculty> findAllFaculty();
}