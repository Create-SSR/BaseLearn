package com.wqcode.demo_boot.converter;

import com.wqcode.demo_boot.dao.Student;
import com.wqcode.demo_boot.dto.StudentDto;

/**
 * @Author create
 * @Date 2024/6/18 15:12
 * @description
 * @Title StudentConverter
 * @Package com.wqcode.demo_boot.converter
 */
public class StudentConverter {

    public static StudentDto convertStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }

    public static Student convertStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        return student;
    }


}
