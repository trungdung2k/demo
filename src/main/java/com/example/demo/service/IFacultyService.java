package com.example.demo.service;
import com.example.demo.entity.Faculty;
import com.example.demo.response.CustomFacultyResponse;

import java.util.List;

public interface IFacultyService {
    Faculty addFaculty(Faculty faculty);

    void updateFaculty(Long id, Faculty faculty);

    boolean deleteFaculty(Long id);

    List<CustomFacultyResponse> getAllFaculty();
}
