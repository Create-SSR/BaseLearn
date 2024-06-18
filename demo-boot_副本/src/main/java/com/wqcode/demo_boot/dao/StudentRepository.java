package com.wqcode.demo_boot.dao;

import com.wqcode.demo_boot.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author create
 * @Date 2024/6/18 14:29
 * @description
 * @Title StudentRepository
 * @Package com.wqcode.demo_boot.dao
 */
@Repository
@ResponseBody
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByEmail(String email);

}
