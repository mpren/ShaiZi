package com.paxos.sz.controller;

import com.paxos.sz.business.StreamProcessBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paxos
 */
@RestController
@RequestMapping("/info")
public class StreamProcessController {

    @Autowired
    private StreamProcessBusiness streamProcessBusiness;

    @GetMapping("/beginStreamProcess")
    public String beginStreamProcess() {
        streamProcessBusiness.beginStreamProcess();
        return "执行成功！";
    }
}