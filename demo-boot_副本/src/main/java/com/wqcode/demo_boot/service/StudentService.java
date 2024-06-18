package com.wqcode.demo_boot.service;

import com.wqcode.demo_boot.converter.StudentConverter;
import com.wqcode.demo_boot.dao.Student;
import com.wqcode.demo_boot.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author create
 * @Date 2024/6/18 14:36
 * @description
 * @Title StudentService
 * @Package com.wqcode.demo_boot.service
 */

public interface StudentService {

    StudentDto getStudentById(long id);

    Long addNewStudent(StudentDto studentDto) throws IllegalAccessException;

    void deleteStudentById(long id);

    StudentDto updataStudentById(long id,String name,String email);


}
