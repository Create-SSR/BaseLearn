package com.wqcode.demo_boot.controller;

import com.wqcode.demo_boot.common.Response;
import com.wqcode.demo_boot.dao.Student;
import com.wqcode.demo_boot.dto.StudentDto;
import com.wqcode.demo_boot.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author create
 * @Date 2024/6/18 14:41
 * @description
 * @Title StudentController
 * @Package com.wqcode.demo_boot.controller
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDto> getStudentById(@PathVariable long id) {
        return Response.newSuccess(studentService.getStudentById(id));

    }

    @PostMapping("/student")
    @ResponseBody
    public Response<Long> addNewStudent(@RequestBody StudentDto studentDto) throws IllegalAccessException {
        return Response.newSuccess(studentService.addNewStudent(studentDto));
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDto> updateStudentById(@PathVariable long id,@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String email) throws Exception{
        return Response.newSuccess(studentService.updataStudentById(id,name,email));

    }
}
