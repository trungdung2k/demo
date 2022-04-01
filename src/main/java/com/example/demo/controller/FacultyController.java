package com.example.demo.controller;
import com.example.demo.entity.Faculty;
import com.example.demo.response.CustomFacultyResponse;
import com.example.demo.service.IFacultyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class FacultyController {

    private IFacultyService ifacultyService;

    @Autowired
    public FacultyController(IFacultyService ifacultyService) {
        this.ifacultyService = ifacultyService;
    }

    @ApiOperation(value =  "create faculty " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PostMapping("/faculty/add")
    public void addFaculty(@RequestBody Faculty faculty){
        ifacultyService.addFaculty(faculty);
    }

    @ApiOperation(value =  "update faculty " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PutMapping("/faculty/update")
    public void updateFaculty (@RequestParam("id") Long id , @RequestBody Faculty faculty){
        ifacultyService.updateFaculty( id , faculty);
    }

    @ApiOperation(value =  "delete faculty " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @DeleteMapping("/faculty/delete/{id}")
    public boolean deleteFaculty(@PathVariable Long id ){
        return  ifacultyService.deleteFaculty(id);
    }


    @ApiOperation(value =  " get list faculty  " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @GetMapping("/faculty/list")
    public List<CustomFacultyResponse> getAllFaculty(){
        return ifacultyService.getAllFaculty();
    }
}
