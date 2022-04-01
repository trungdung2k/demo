package com.example.demo.service;
import com.example.demo.constant.MessageConst;
import com.example.demo.entity.Clazz;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.BasicException;
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
import java.util.Objects;
import java.util.Optional;
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

    public TeacherService(ClazzRepository clazzRepository,
                          TeacherRepository teacherRepository,
                          StudentRepository studentRepository) {
        this.clazzRepository = clazzRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;

    }

    @Override
    public void  addTeacher(TeacherRequest request) {
        Optional<Clazz> clazzOptional = clazzRepository.findById(request.getClazzId());
        if (!clazzOptional.isPresent()) {
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CLAZZ_NOT_FOUND)
                    .addErrors(MessageConst.CLAZZ_E0001);
        }

        Teacher teacher = request.asCreatedTeacher();
        teacherRepository.save(teacher);

    }

    @Override
    public void updateTeacher( TeacherRequest request){
        Optional<Clazz> clazzOptional = clazzRepository.findById(request.getClazzId());
        if (!clazzOptional.isPresent()) {
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CLAZZ_NOT_FOUND)
                    .addErrors(MessageConst.CLAZZ_E0001);
        }

        Teacher teacher = getTeacher(request.getId());
        teacher = request.asUpdatedTeacher(teacher);
        teacherRepository.save(teacher);
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
        List<CustomTeacherResponse> customTeacherResponseList =  new ArrayList<>();
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
                    return new CustomClazzResponse(clazz, studentTotal, studentName);
            }).collect(Collectors.toList());
            customTeacherResponse.setClazzList(customClazzResponseList);
            customTeacherResponseList.add(customTeacherResponse);
        });
        return customTeacherResponseList;
    }

    public Teacher getTeacher (Long id){
        if (Objects.isNull(id)){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.ID_TEACHER_EMPTY)
                    .addErrors(MessageConst.TEACHER_E0002);
        }

        Optional<Teacher> teacherOptional = teacherRepository.findByIdAndDeleteFalse(id);
        if (!teacherOptional.isPresent()){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CLAZZ_NOT_FOUND)
                    .addErrors(MessageConst.CLAZZ_E0001);
        }
        return teacherOptional.get();
    }
}
