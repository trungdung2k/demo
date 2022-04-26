package com.example.demo.service;
import com.example.demo.constant.MessageConst;
import com.example.demo.entity.Clazz;
import com.example.demo.entity.Student;
import com.example.demo.exception.BasicException;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

import com.example.demo.request.StudentRequest;

import com.example.demo.response.CustomStudent1Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService implements IStudentService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    public StudentService (StudentRepository studentRepository,
                          ClazzRepository clazzRepository,
                           TeacherRepository teacherRepository,
                           FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.clazzRepository = clazzRepository;
        this.teacherRepository = teacherRepository;
        this.facultyRepository = facultyRepository;
    }
    @Override
    public void addStudent(StudentRequest request){

        // validate class
        Optional<Clazz> clazzOptional = clazzRepository.findById(request.getClazzId());
        if (!clazzOptional.isPresent()){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CLAZZ_NOT_FOUND)
                    .addErrors(MessageConst.CLAZZ_E0001);
        }

        // add Student
        Student student = request.asAddStudent();
        student.setClazz(clazzRepository.getById(request.getClazzId()));
        studentRepository.save(student);

    }

    @Override
    public void updateStudent(StudentRequest request){

        // validate class
                Optional<Clazz> clazzOptional = clazzRepository.findById(request.getClazzId());
                if (!clazzOptional.isPresent()){
                    throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CLAZZ_NOT_FOUND)
                            .addErrors(MessageConst.CLAZZ_E0001);

       }
        // validate mã sinh viên vì mã sinh viên không thể trùng
        Student student = getStudent(request.getId());
        if (studentRepository.exitsByMsvAndIdNot(request.getMsv(), student.getId())){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.MSV_STUDENT_EXITS)
                    .addErrors(MessageConst.STUDENT_E0003);
        }

        //update
        student = request.asUpdateStudent(student);
        student.setClazz(clazzRepository.getById(request.getClazzId()));
        studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(long id){
        if (id > 0 ){
           Student student = studentRepository.getById(id);
            studentRepository.delete(student);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomStudent1Response> findAllStudent(){
        List<Student> studentList = studentRepository.findAllStudent();
        List<Long> StudentIds = studentList.stream().map(Student::getId).collect(Collectors.toList());
        List<CustomStudent1Response> customStudent1Responses = studentRepository.findListStudent(StudentIds);
        return customStudent1Responses ;
    }


    public Student getStudent(Long id){
        if (Objects.isNull(id)){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.ID_STUDENT_EMPTY)
                    .addErrors(MessageConst.STUDENT_EOOO2);
        }

        Optional<Student> studentOptional = studentRepository.findByIdAndDeleteFalse(id);
        if (!studentOptional.isPresent()){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.STUDENT_NOT_FOUND)
                    .addErrors(MessageConst.STUDENT_E0001);
        }
        return studentOptional.get();
    }
}
