package com.example.demo.service.Impl;

import com.example.demo.constant.MessageConst;
import com.example.demo.entity.Clazz;
import com.example.demo.entity.Marks;
import com.example.demo.entity.Student;
import com.example.demo.exception.BasicException;
import com.example.demo.repository.MarksRepository;
import com.example.demo.request.MarksRequest;
import com.example.demo.service.IMarkService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarksService implements IMarkService {

    @Autowired
    private final MarksRepository marksRepository;

    @Override
    public void createMarks(MarksRequest request) {
        Marks marks = request.asCreateMarks();
        marksRepository.save(marks);
    }

    @Override
    public void updateMarks(MarksRequest request){
        Marks marks = getMarks(request.getId());
        marks = request.asUpdateMarks(marks);

        marksRepository.save(marks);
    }

    @Override
    public boolean deleteMarks(Long id) {
        if (Objects.isNull(id)) {
            Marks marks = marksRepository.getById(id);
            marksRepository.delete(marks);
            return true;
        }return false;
    }




    public Marks getMarks(Long id) {
        if (Objects.isNull(id)){
            System.out.println("id không tồn tại");
        }
        Optional<Marks> marksOptional = marksRepository.findById(id);
        if (marksOptional.isPresent()){
            System.out.println("marks không tồn tại");
        }

        return marksOptional.get();
    }
}
