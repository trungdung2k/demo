package com.example.demo.controller;
import com.example.demo.entity.Teacher;
import com.example.demo.request.TeacherRequest;
import com.example.demo.response.CustomTeacherResponse;
import com.example.demo.service.ITeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherController {

    private ITeacherService iteacherService;
    @Autowired
    public TeacherController( ITeacherService iTeacherService) {
        this.iteacherService = iTeacherService;
    }

    @ApiOperation(value =  "create teacher " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PostMapping("/teacher/add")
    public void addTeacher(@RequestBody TeacherRequest teacherRequest){
         iteacherService.addTeacher(teacherRequest);
    }

    @ApiOperation(value =  "update teacher " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PutMapping("/teacher/update")
    public void updateTeacher (@Valid @RequestBody TeacherRequest request){
        iteacherService.updateTeacher(request);
    }

    @ApiOperation(value =  "delete teacher " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @DeleteMapping("/teacher/delete/{id}")
    public boolean deleteTeacher(@PathVariable Long id ){
        return  iteacherService.deleteTeacher(id);
    }

    @ApiOperation(value =  "Get list teacher " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @GetMapping("/teacher/list")
    public List<CustomTeacherResponse> getAllTeacher(){
        return iteacherService.getAllTeacher();
    }
}