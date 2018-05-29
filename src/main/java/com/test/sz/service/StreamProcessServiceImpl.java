package com.test.sz.service;

import com.test.sz.dao.TSInfoDao;
import com.test.sz.model.TSInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author paxos
 */
@Service
public class StreamProcessServiceImpl implements StreamProcessService {

    @Resource
    private TSInfoDao tSInfoDao;

    @Override
    public TSInfo queryDetail(TSInfo info) {
        return tSInfoDao.queryInfoDetail(info);
    }

    @Override
    public void insertByList(List<TSInfo> info) {
        tSInfoDao.insertByList(info);
    }


}