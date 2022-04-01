package com.example.demo.service;

import com.example.demo.entity.Clazz;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazz1Response;

import java.util.List;
public interface IClazzService {

    void addClazz(ClazzRequest clazzRequest);


    void updateClass(ClazzRequest request);

    boolean deleteClazz(Long id);

    List<CustomClazz1Response> getAllClazz();

}
