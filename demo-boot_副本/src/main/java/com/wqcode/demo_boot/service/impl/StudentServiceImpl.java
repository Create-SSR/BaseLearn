package com.wqcode.demo_boot.service.impl;

import com.wqcode.demo_boot.converter.StudentConverter;
import com.wqcode.demo_boot.dao.Student;
import com.wqcode.demo_boot.dao.StudentRepository;
import com.wqcode.demo_boot.dto.StudentDto;
import com.wqcode.demo_boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author create
 * @Date 2024/6/18 14:37
 * @description
 * @Title StudentServiceImpl
 * @Package com.wqcode.demo_boot.service.impl
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired(required = false)
    private StudentRepository studentRepository;

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDto studentDto) throws IllegalAccessException {
        List<Student> studentList =  studentRepository.findByEmail(studentDto.getEmail());
        if(!CollectionUtils.isEmpty(studentList)) {
            throw new IllegalAccessException("email:" + studentDto.getEmail() + "has been token");
        }
        Student student = studentRepository.save(StudentConverter.convertStudent(studentDto));

        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id + "doesn't exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDto updataStudentById(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id + "doesn't exist!"));

        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }
        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }
}
