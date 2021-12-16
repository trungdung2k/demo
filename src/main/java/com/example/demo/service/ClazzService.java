package com.example.demo.service;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ClazzService implements IClazzService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    public ClazzService (ClazzRepository clazzRepository,TeacherRepository teacherRepository, FacultyRepository facultyRepository,StudentRepository studentRepository ) {
        this.clazzRepository = clazzRepository;
        this.teacherRepository = teacherRepository;
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addClazz(ClazzRequest clazzRequest) {
        Clazz clazz1 = new Clazz();
        clazz1.setClazzCode(clazzRequest.getClazzCode());
        clazz1.setClazzName(clazzRequest.getClazzName());
        Teacher teacher = teacherRepository.findOne(clazzRequest.getTeacherId());
        clazz1.setTeacher(teacher);
        Faculty faculty = facultyRepository.findOne(clazzRequest.getFacultyId());
        clazz1.setFaculty(faculty);
        clazzRepository.save(clazz1);
    }

    @Override
    public void updateClass(Long id, Clazz clazz){
        if (clazz != null){
            Clazz clazz1 = clazzRepository.findOne(id);
            clazz1.setClazzName(clazz.getClazzName());
            clazz1.setClazzCode(clazz.getClazzCode());
            clazz1.setFaculty(clazz.getFaculty());
            clazz1.setTeacher(clazz.getTeacher());
            clazzRepository.save(clazz1);
        }
    }

    @Override
    public boolean deleteClazz(Long id) {
        if (id > 0) {
            Clazz clazz = clazzRepository.findOne(id);
            clazzRepository.delete(clazz);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomClazzResponse> getAllClazz() {
        List<CustomClazzResponse> classes = new  ArrayList<>();
        List<Clazz> clazzList = clazzRepository.findAllClazz();
        clazzList.forEach(clazz -> {
          CustomClazzResponse customClazzResponse = new CustomClazzResponse();
            customClazzResponse.setId(clazz.getId());
            customClazzResponse.setClazzCode(clazz.getClazzCode());
            customClazzResponse.setClazzName(clazz.getClazzName());
            customClazzResponse.setTeacher(clazz.getTeacher());
            customClazzResponse.setFaculty(clazz.getFaculty());
            customClazzResponse.setStudentTotal(studentRepository.countStudentByClazz(clazz.getId()));
            classes.add(customClazzResponse);
            classes.stream().map(clazz1 -> clazz1.getStudentTotal()).collect(Collectors.toList());
        });
        return classes;
    }


}
