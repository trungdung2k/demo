package com.example.demo.service;

import com.example.demo.model.Clazz;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.response.CustomClazzResponse;

import java.util.List;
public interface IClazzService {

    void addClazz(ClazzRequest clazzRequest);

    void updateClass(Long id, Clazz clazz);

    boolean deleteClazz(Long id);

    List<CustomClazz1Response> getAllClazz();

}
