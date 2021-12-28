package com.example.demo.service;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.response.CustomClazzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
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
    public List<CustomClazz1Response> getAllClazz() {
        List<Clazz> clazzList = clazzRepository.findAllClazz();
        List<Long> ClazzIds = clazzList.stream().map(Clazz::getId).collect(Collectors.toList());
        List<CustomClazz1Response> customClazzResponseList = clazzRepository.listClazz(ClazzIds);

//        clazzList.forEach(clazz -> {
//          CustomClazzResponse customClazzResponse = new CustomClazzResponse();
//            customClazzResponse.setId(clazz.getId());
//            customClazzResponse.setClazzCode(clazz.getClazzCode());
//            customClazzResponse.setClazzName(clazz.getClazzName());
//            customClazzResponse.setTeacher(clazz.getTeacher());
//            customClazzResponse.setFaculty(clazz.getFaculty());
//            customClazzResponse.setStudentTotal(studentRepository.countStudentByClazz(clazz.getId()));
//            customClazzResponse.setStudentName(studentRepository.findStudentNameByClazz(clazz.getId()));
//            classes.add(customClazzResponse);
//        });

//        Comparator<customClazzResponseList> compareByStudentTotal =
//                Comparator.comparing(customClazzResponseList::getStudentTotal);
//        customClazzResponseList.sort(compareByStudentTotal.reversed());
        return customClazzResponseList;
    }

}

