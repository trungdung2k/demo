package com.example.demo.controller;
import com.example.demo.entity.Clazz;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.service.IClazzService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class ClazzController {

    private IClazzService iclazzService;
    @Autowired
    public ClazzController(IClazzService iclazzService) {
        this.iclazzService =  iclazzService;
    }

    @ApiOperation(value =  "create clazz " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PostMapping("/clazz/add")
    public void addClazz(@RequestBody ClazzRequest clazzRequest){
        iclazzService.addClazz(clazzRequest);
    }

    @ApiOperation(value =  " update clazz " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @PutMapping("/clazz/update")
    public void updateClazz (@Valid @RequestBody ClazzRequest request){
        iclazzService.updateClass(request);
    }

    @ApiOperation(value =  "delete clazz " )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @DeleteMapping("/clazz/delete/{id}")
    public boolean deleteClazz(@PathVariable Long id ){
        return  iclazzService.deleteClazz(id);
    }


    @ApiOperation(value =  " get list clazz" )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Bad com.example.finalexam.request"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server Error")
    })
    @GetMapping("/clazz/list")
    public List<CustomClazz1Response> getAllClazz(){
        return iclazzService.getAllClazz();
    }

}
