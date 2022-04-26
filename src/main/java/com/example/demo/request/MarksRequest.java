package com.example.demo.request;

import com.example.demo.entity.Marks;
import lombok.Data;

@Data
public class MarksRequest {
    private Long id;
    private String msv;
    private String nameSubject;
    private String codeSubject;
    private Double marks;
    private String marksLetter;


    public Marks asCreateMarks (){
        Marks marks1 = new Marks();
        marks1.setId(this.id);
        marks1.setMsv(this.msv);
        marks1.setNameSubject(this.nameSubject);
        marks1.setCodeSubject(this.codeSubject);
        marks1.setMarks(this.marks);
        marks1.setMarksLetter(this.marksLetter);

        return marks1;
    }

    public Marks asUpdateMarks ( Marks marks){
        marks.setMsv(this.msv);
        marks.setNameSubject(this.nameSubject);
        marks.setCodeSubject(this.codeSubject);
        marks.setMarks(this.marks);
        marks.setMarksLetter(this.marksLetter);

        return marks;
    }
}
