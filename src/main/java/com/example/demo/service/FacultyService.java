package com.example.demo.service;
import com.example.demo.entity.Faculty;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.response.CustomFacultyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service

public class FacultyService implements IFacultyService{
    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    FacultyRepository facultyRepository;

    public FacultyService(ClazzRepository clazzRepository, FacultyRepository ifacultyRepository) {
        this.clazzRepository = clazzRepository;
        this.facultyRepository = ifacultyRepository;
    }

    @Override
    public Faculty addFaculty(Faculty faculty){
        if (faculty != null){
            return facultyRepository.save(faculty);
        }
        return null;
}

    @Override
    public void updateFaculty(Long id, Faculty faculty){
        if (faculty != null){
            Faculty faculty1 = facultyRepository.getById(id);
            faculty1.setFacultyName(faculty.getFacultyName());
            faculty1.setFacultyCode(faculty.getFacultyCode());
            facultyRepository.save(faculty1);
        }
    }

    @Override
    public boolean deleteFaculty(Long id){
        if (id > 0){
            Faculty faculty = facultyRepository.getById(id);
            facultyRepository.delete(faculty);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomFacultyResponse> getAllFaculty(){
        List<CustomFacultyResponse> facultyResponseList = new ArrayList<>();
        List<Faculty> facultyList = facultyRepository.findAllFaculty();
        facultyList.forEach(faculty -> {
            CustomFacultyResponse customFacultyResponse = new CustomFacultyResponse();
            customFacultyResponse.setId(faculty.getId());
            customFacultyResponse.setFacultyCode(faculty.getFacultyCode());
            customFacultyResponse.setFacultyName(faculty.getFacultyName());
            customFacultyResponse.setClazzTotal(clazzRepository.countClazzByFaculty(faculty.getId()));
            facultyResponseList.add(customFacultyResponse);
        });
        return facultyResponseList;
    }
}
