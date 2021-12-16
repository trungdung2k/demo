package com.example.demo.controller;
import com.example.demo.model.Faculty;
import com.example.demo.response.CustomFacultyResponse;
import com.example.demo.service.IFacultyService;
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

    @PostMapping("/faculty/add")
    public void addFaculty(@RequestBody Faculty faculty){
        ifacultyService.addFaculty(faculty);
    }

    @PutMapping("/faculty/update")
    public void updateFaculty (@RequestParam("id") Long id , @RequestBody Faculty faculty){
        ifacultyService.updateFaculty( id , faculty);
    }

    @DeleteMapping("/faculty/delete/{id}")
    public boolean deleteFaculty(@PathVariable Long id ){
        return  ifacultyService.deleteFaculty(id);
    }


    @GetMapping("/faculty/list")
    public List<CustomFacultyResponse> getAllFaculty(){
        return ifacultyService.getAllFaculty();
    }
}
