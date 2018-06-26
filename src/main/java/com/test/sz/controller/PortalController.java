package com.test.sz.controller;

import com.alibaba.fastjson.JSON;
import com.test.sz.business.PortalBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author paxos
 */
@Controller
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private PortalBusiness portalBusiness;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("queryTop5")
    @ResponseBody
    public String queryTop5() {
        return JSON.toJSONString(portalBusiness.queryTop5());
    }


}
