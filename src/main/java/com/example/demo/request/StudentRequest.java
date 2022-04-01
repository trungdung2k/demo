package com.example.demo.request;
import com.example.demo.entity.Student;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class StudentRequest {

    private Long id;

    @NotBlank
    @Length(max = 255)
    private String name;

    @NotBlank
    private String gender;

    @NotBlank
    private int age;

    @NotBlank
    @Length(max = 255)
    private String msv;

    @NotBlank
    @Length(max = 255)
    private String address;

    @NotBlank
    private int phone;

    private Long clazzId;


    public Student asAddStudent (){
        Student student = new Student();
        student.setName(this.getName());
        student.setAddress(this.getAddress());
        student.setAge(this.getAge());
        student.setGender(this.getGender());
        student.setMsv(this.getMsv());
        student.setPhone(this.getPhone());

        return student;
    }

    public Student asUpdateStudent(Student student){
        student.setName(this.getName());
        student.setAddress(this.getAddress());
        student.setAge(this.getAge());
        student.setGender(this.getGender());
        student.setMsv(this.getMsv());
        student.setPhone(this.getPhone());

        return student;


    }

}
