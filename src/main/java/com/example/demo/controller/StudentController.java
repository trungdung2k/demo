package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class StudentController {

    private IStudentService istudentService;
    @Autowired
    public StudentController( IStudentService istudentService) {
        this.istudentService =  istudentService;
    }

    @PostMapping("/student/add")
    public void addStudent(@RequestBody StudentRequest studentRequest){
         istudentService.addStudent(studentRequest);
    }

    @PutMapping("/student/update")
    public void updateStudent (@RequestParam("id") Long id , @RequestBody Student student){
       istudentService.updateStudent(id , student);
    }

    @DeleteMapping("/student/delete/{id}")
    public boolean deleteStudent(@PathVariable Long id ){
        return  istudentService.deleteStudent(id);
    }

    @GetMapping("/student/list")
    public List<Student> findAllStudent(){
        return istudentService.findAllStudent();
    }
}
