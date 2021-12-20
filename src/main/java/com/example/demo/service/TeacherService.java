package com.example.demo.service;
import com.example.demo.model.Clazz;
import com.example.demo.model.Teacher;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.request.TeacherRequest;
import com.example.demo.response.CustomClazzResponse;
import com.example.demo.response.CustomTeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService implements ITeacherService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(ClazzRepository clazzRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.clazzRepository = clazzRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Teacher addTeacher(TeacherRequest teacherRequest){
        Teacher teacher1 = new Teacher();
        teacher1.setNameTeacher(teacherRequest.getNameTeacher());
        teacher1.setAge(teacherRequest.getAge());
        teacher1.setGender(teacherRequest.getGender());
        Clazz clazz = clazzRepository.findOne(teacherRequest.getClazzId());
        teacher1.setClazz(clazz);
        return teacherRepository.save(teacher1);
        }

    @Override
    public void updateTeacher(Long id, Teacher teacher){
        if (teacher != null){
            Teacher teacher1 = teacherRepository.getById(id);
            teacher1.setNameTeacher(teacher.getNameTeacher());
            teacher1.setAge(teacher.getAge());
            teacher1.setGender(teacher.getGender());
            teacher1.setClazz(teacher.getClazz());
            teacherRepository.save(teacher1);
        }
    }

    @Override
    public boolean deleteTeacher(Long id ){
        if (id > 0){
            Teacher teacher = teacherRepository.getById(id);
            teacherRepository.delete(teacher);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomTeacherResponse> getAllTeacher() {
        List<CustomTeacherResponse> customTeacherResponseList = new ArrayList<>();
        List<Teacher> teacherList = teacherRepository.findAll();
        teacherList.forEach(teacher -> {
            CustomTeacherResponse customTeacherResponse = new CustomTeacherResponse();
            customTeacherResponse.setNameTeacher(teacher.getNameTeacher());
            customTeacherResponse.setGender(teacher.getGender());
            customTeacherResponse.setAge(teacher.getAge());
            customTeacherResponse.setId(teacher.getId());
            List<Clazz> clazzByTeacher = clazzRepository.findClazzByTeacher(teacher.getId());
            List<CustomClazzResponse> customClazzResponseList = clazzByTeacher.stream().map(clazz -> {
                Long studentTotal = studentRepository.countStudentByClazz(clazz.getId());
                List<String> studentName = studentRepository.findStudentNameByClazz(clazz.getId());
              return   new  CustomClazzResponse(clazz , studentTotal , studentName);}
            ).collect(Collectors.toList());
            customTeacherResponse.setClazzList(customClazzResponseList);
            customTeacherResponseList.add(customTeacherResponse);
        });
        return customTeacherResponseList;
    }
}
