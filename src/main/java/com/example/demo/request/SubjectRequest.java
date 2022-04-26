package com.example.demo.request;

import com.example.demo.entity.Subject;
import lombok.Data;

@Data
public class SubjectRequest {
    private Long id;
    private String nameSubject;
    private String codeSubject;


    public Subject asAddSubject(){
        Subject subject = new Subject();
        subject.setId(this.id);
        subject.setNameSubject(this.nameSubject);
        subject.setCodeSubject(this.codeSubject);

        return subject;
    }

    public Subject asUpdateSubject(Subject subject){
        subject.setId(this.id);
        subject.setNameSubject(this.nameSubject);
        subject.setCodeSubject(this.codeSubject);
    }
}
