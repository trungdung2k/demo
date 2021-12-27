package com.example.demo.service;
import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

import com.example.demo.request.StudentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


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
    public void addStudent(StudentRequest studentRequest){
        Student student1 = new Student();
        student1.setName(studentRequest.getName());
        student1.setAge(studentRequest.getAge());
        student1.setAddress(studentRequest.getAddress());
        student1.setGender(studentRequest.getGender());
        student1.setPhone(studentRequest.getPhone());
        student1.setMsv(studentRequest.getMsv());
        Clazz clazz = clazzRepository.findOne(studentRequest.getClazzId());
        student1.setClazz(clazz);
        studentRepository.save(student1);

    }

    @Override
    public void updateStudent(long id, Student student){
        if (student != null){
            Student student1 = studentRepository.getById(id);
            student1.setName(student.getName());
            student1.setAge(student.getAge());
            student1.setAddress(student.getAddress());
            student1.setGender(student.getGender());
            student1.setPhone(student.getPhone());
            student1.setMsv(student.getMsv());
            student1.setClazz(student.getClazz());
            studentRepository.save(student1);
       }
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
    public List<Student> findAllStudent(){
        return studentRepository.findAllStudent();
    }
}
