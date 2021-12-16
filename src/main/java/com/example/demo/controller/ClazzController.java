package com.example.demo.controller;
import com.example.demo.model.Clazz;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazzResponse;
import com.example.demo.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ClazzController {

    private IClazzService iclazzService;
    @Autowired
    public ClazzController(IClazzService iclazzService) {
        this.iclazzService =  iclazzService;
    }

    @PostMapping("/clazz/add")
    public void addClazz(@RequestBody ClazzRequest clazzRequest){
        iclazzService.addClazz(clazzRequest);
    }

    @PutMapping("/clazz/update")
    public void updateClazz (@RequestParam("id") Long id , @RequestBody Clazz clazz){
        iclazzService.updateClass(id,clazz);
    }

    @DeleteMapping("/clazz/delete/{id}")
    public boolean deleteClazz(@PathVariable Long id ){
        return  iclazzService.deleteClazz(id);
    }


    @GetMapping("/clazz/list")
    public List<CustomClazzResponse> getAllClazz(){
        return iclazzService.getAllClazz();
    }


}
