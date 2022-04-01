package com.example.demo.service;
import com.example.demo.constant.MessageConst;
import com.example.demo.entity.*;
import com.example.demo.exception.BasicException;
import com.example.demo.repository.*;
import com.example.demo.request.ClazzRequest;
import com.example.demo.response.CustomClazz1Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClazzService implements IClazzService{

    StudentRepository studentRepository;

    FacultyRepository facultyRepository;

    ClazzRepository clazzRepository;

    TeacherRepository teacherRepository;

    @Autowired
    public ClazzService (ClazzRepository clazzRepository,TeacherRepository teacherRepository, FacultyRepository facultyRepository,StudentRepository studentRepository ) {
        this.clazzRepository = clazzRepository;
        this.teacherRepository = teacherRepository;
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addClazz(ClazzRequest request) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(request.getTeacherId());
        if (!teacherOptional.isPresent()) {
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.TEACHER_NOT_FOUND)
                    .addErrors(MessageConst.TEACHER_E0001);
        }
        Optional<Faculty> facultyOptional = facultyRepository.findById(request.getFacultyId());
        if (!facultyOptional.isPresent()){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.FACULTY_NOT_FOUND)
                    .addErrors(MessageConst.FACULTY_E0001);
        }

        Clazz clazz = request.asCreatedClazz();
        clazzRepository.save(clazz);
    }

    @Override
    public void updateClass(ClazzRequest request){
        Optional<Teacher> teacherOptional = teacherRepository.findById(request.getTeacherId());
        if (!teacherOptional.isPresent()) {
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.TEACHER_NOT_FOUND)
                    .addErrors(MessageConst.TEACHER_E0001);
        }
        Optional<Faculty> facultyOptional = facultyRepository.findById(request.getFacultyId());
        if (!facultyOptional.isPresent()){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.FACULTY_NOT_FOUND)
                    .addErrors(MessageConst.FACULTY_E0001);
        }

        Clazz clazz = getClazz(request.getId());

        if (clazzRepository.existsByClazzNameAndIdNot(request.getClazzName(), clazz.getId())){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.NAME_CLAZZ_EXITS)
                    .addErrors(MessageConst.CLAZZ_E0003);
        }
        if (clazzRepository.existsByClazzCodeAndIdNot(request.getClazzCode(), clazz.getId())){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CODE_CLAZZ_EXITS)
                    .addErrors(MessageConst.CLAZZ_E0002);
        }

        clazz = request.asUpdatedClazz(clazz);
        clazzRepository.save(clazz);
    }

    @Override
    public boolean deleteClazz(Long id) {
        if (id > 0) {
            Clazz clazz = clazzRepository.getById(id);
            clazzRepository.delete(clazz);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomClazz1Response> getAllClazz() {
        List<Clazz> clazzList = clazzRepository.findAllClazz();
        List<Long> ClazzIds = clazzList.stream().map(Clazz::getId).collect(Collectors.toList());
        List<CustomClazz1Response> customClazzResponseList = clazzRepository.listClazz(ClazzIds);
        Comparator<CustomClazz1Response> compareByStudentTotal =
                Comparator.comparing(CustomClazz1Response::getStudentTotal);
        customClazzResponseList.sort(compareByStudentTotal.reversed());
        return customClazzResponseList;
    }

    public Clazz getClazz (Long id){
        if (Objects.isNull(id)){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.ID_CLAZZ_EMPTY)
                    .addErrors(MessageConst.CLAZZ_E0004);
        }

        Optional<Clazz> clazzOptional = clazzRepository.findByIdAndDeleteFalse(id);
        if (!clazzOptional.isPresent()){
            throw BasicException.INVALID_ARGUMENT.withMessage(MessageConst.CLAZZ_NOT_FOUND)
                    .addErrors(MessageConst.CLAZZ_E0001);
        }
        return clazzOptional.get();
    }
}

