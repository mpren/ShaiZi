package com.test.sz.controller;

import com.test.sz.model.TSInfo;
import com.test.sz.service.TSInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s")
public class TSinfoController {

    @Autowired
    private TSInfoService tsInfoService;


    @PostMapping("/insert")
    public void insert(TSInfo tsInfo) {
        tsInfoService.insert(tsInfo);
    }
}