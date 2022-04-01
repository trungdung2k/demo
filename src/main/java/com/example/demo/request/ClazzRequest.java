package com.example.demo.request;
import com.example.demo.entity.Clazz;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class ClazzRequest {
        private  Long id;

        @NotBlank
        @Length(max = 255)
        private String clazzCode;

        @NotBlank
        @Length(max = 255)
        private String clazzName;

        @NotBlank
        @Length(max = 255)
        private String facultyName;

        private Long teacherId;

        private Long facultyId;


        public Clazz asCreatedClazz(){
                Clazz clazz = new Clazz();
                clazz.setClazzCode(this.getClazzCode());
                clazz.setClazzName(this.getClazzName());

                return clazz;
        }

        public Clazz asUpdatedClazz(Clazz clazz){
                clazz.setClazzName(this.getClazzName());
                clazz.setClazzCode(this.getClazzCode());

                return clazz;
        }

}

