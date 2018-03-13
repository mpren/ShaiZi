package com.test.sz.service;

import com.test.sz.dao.TsinfoDao;
import com.test.sz.model.TSInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TSInfoServiceImpl implements TSInfoService {


    @Resource
    private TsinfoDao tsinfoDao;

    @Override
    public void insert(TSInfo tSInfo) {
        tsinfoDao.insert(tSInfo);

    }

}
