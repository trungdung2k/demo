package com.example.demo.controller;
import com.example.demo.entity.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.CustomStudent1Response;
import com.example.demo.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class StudentController {

    private IStudentService istudentService;
    @Autowired
    public StudentController( IStudentService istudentService) {
        this.istudentService =  istudentService;
    }

    @ApiOperation(value =  "create student " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PostMapping("/student/add")
    public void addStudent(@RequestBody StudentRequest studentRequest){
         istudentService.addStudent(studentRequest);
    }

    @ApiOperation(value =  " update student" )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PutMapping("/student/update")
    public ResponseEntity<Void> updateStudent (@Valid  @RequestBody StudentRequest request){
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value =  "delete student " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @DeleteMapping("/student/delete/{id}")
    public boolean deleteStudent(@PathVariable Long id ){
        return  istudentService.deleteStudent(id);
    }

    @ApiOperation(value =  " get list student" )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @GetMapping("/student/list")
    public List<CustomStudent1Response> findAllStudent(){
        return istudentService.findAllStudent();
    }
}
