package com.test.sz.controller;

import com.test.sz.model.Student;
import com.test.sz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/add")
    public void insert(Student student) {
        //WARN:因为我们在初始化RedisTemplate的时候使用了指定的序列化器，这里要注意。
        redisTemplate.opsForSet().add(String.valueOf(student.getId()), student);
        studentService.insert(student);
    }
}