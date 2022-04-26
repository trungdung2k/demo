package com.example.demo.service.Impl;

import com.example.demo.entity.Subject;
import com.example.demo.repository.CustomSubjectRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.request.SubjectRequest;
import com.example.demo.response.CustomSubjectResponse;
import com.example.demo.service.ISubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.peer.PanelPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService implements ISubjectService {

    private SubjectRepository subjectRepository;


    @Override
    public void AddSubject(SubjectRequest request){
        Subject subject = request.asAddSubject();
        if (subjectRepository.existsByNameSubject(request.nameSubject)){
            System.out.println("tên môn không thể trùng");
        }
        if (subjectRepository.existsByCodeSubject(request.codeSubject)) {
            System.out.println("mã môn không thể trùng");
        }
        subjectRepository.save(subject);
    }

    @Override
    public void UpdateSubject(SubjectRequest request){
        Subject subject = getSubject(request.getId());
        if (subjectRepository.existsByNameSubject(request.nameSubject)){
            System.out.println("tên môn không thể trùng");
        }
        if (subjectRepository.existsByCodeSubject(request.codeSubject)){
            System.out.println("mã môn không thể trùng");
        }
        subject = request.asUpdateSubject(subject);
        subjectRepository.save(subject);
    }

    @Override
    public boolean deleteSubject(Long id){
        if (id > 0){
            Subject subject = subjectRepository.getById(id);
            subjectRepository.delete(subject);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomSubjectResponse> listSubject (){
        List<CustomSubjectResponse> customSubjectResponses = new ArrayList<>();
        List<Subject> subjects = subjectRepository.findAll();
        subjects.forEach(subject -> {
            CustomSubjectResponse customSubjectResponse = new CustomSubjectResponse();
            customSubjectResponse.setId(subject.getId());
            customSubjectResponse.setNameSubject(subject.getNameSubject());
            customSubjectResponse.setCodeSubject(subject.getCodeSubject());

            customSubjectResponses.add(customSubjectResponse);
        });
        return customSubjectResponses;
    }

    public Subject getSubject(Long id){
        if (Objects.isNull(id)){

            System.out.println("Id không tồn tại");
        }
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent()){
            System.out.println("subject không tồn tại");
}

        return subjectOptional.get();
                }
}
