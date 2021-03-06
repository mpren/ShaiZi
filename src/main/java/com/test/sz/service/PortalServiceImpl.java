package com.test.sz.service;

import com.test.sz.dao.TSTop5Dao;
import com.test.sz.model.TSTop5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author paxos
 */
@Service
public class PortalServiceImpl implements PortalService {

    @Resource
    private TSTop5Dao tsTop5Dao;

    @Override
    public List<TSTop5> queryDieFuTop5() {
        return tsTop5Dao.queryDieFuTop5();
    }

    @Override
    public List<TSTop5> queryTop5List() {
        return tsTop5Dao.queryDieFuTop5();
    }
}
