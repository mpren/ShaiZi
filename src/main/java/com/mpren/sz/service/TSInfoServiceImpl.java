package com.mpren.sz.service;

import com.mpren.sz.dao.TsinfoDao;
import com.mpren.sz.model.TSInfo;
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
