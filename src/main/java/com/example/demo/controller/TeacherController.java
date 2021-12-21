package com.example.demo.controller;
import com.example.demo.model.Teacher;
import com.example.demo.request.TeacherRequest;
import com.example.demo.response.CustomTeacherResponse;
import com.example.demo.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeacherController {

    private ITeacherService iteacherService;
    @Autowired
    public TeacherController( ITeacherService iTeacherService) {
        this.iteacherService = iTeacherService;
    }


    @PostMapping("/teacher/add")
    public void addTeacher(@RequestBody TeacherRequest teacherRequest){
         iteacherService.addTeacher(teacherRequest);
    }

    @PutMapping("/teacher/update")
    public void updateTeacher (@RequestParam("id") Long id, @RequestBody Teacher teacher){
        iteacherService.updateTeacher(id , teacher);
    }

    @DeleteMapping("/teacher/delete/{id}")
    public boolean deleteTeacher(@PathVariable Long id ){
        return  iteacherService.deleteTeacher(id);
    }


    @GetMapping("/teacher/list")
    public List<CustomTeacherResponse> getAllTeacher(){
        return iteacherService.getAllTeacher();
    }
}