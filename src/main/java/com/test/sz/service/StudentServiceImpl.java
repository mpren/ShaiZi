package com.test.sz.service;

import com.test.sz.dao.StudentDao;
import com.test.sz.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    //这里的资源注入需要在MyBatisMapperScannerConfig中初始化。
    @Resource
    private StudentDao studentDao;

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }
}