package com.example.demo.controller;

import com.example.demo.request.StudentRequest;
import com.example.demo.request.SubjectRequest;
import com.example.demo.response.CustomSubjectResponse;
import com.example.demo.service.ISubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class SubjectController {

    private ISubjectService iSubjectService;

    @PostMapping("/subject")
    public void addSubject(@RequestBody SubjectRequest request){
     iSubjectService.AddSubject(request) ;
    }

    @PutMapping("/subject")
    public void updateSubject(@Valid @RequestBody SubjectRequest request){
        iSubjectService.UpdateSubject(request);
    }

    @DeleteMapping("/subject/{id}")
    public boolean deleteSubject (@PathVariable Long id){
       return iSubjectService.deleteSubject(id);
    }

    @GetMapping("/subject/list")
    public List<CustomSubjectResponse> getList (){
        return iSubjectService.listSubject();
    }
}
