package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService implements ISubjectService {


    public final ISubjectService iSubjectService;

    @Autowired
    public SubjectService (ISubjectService iSubjectService){
        this.iSubjectService = iSubjectService;
    }
}
