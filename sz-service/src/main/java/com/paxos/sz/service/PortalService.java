package com.paxos.sz.service;

import com.paxos.sz.model.TSTop5;

import java.util.List;

/**
 * @author paxos
 */
public interface PortalService {

    /**
     * 查询top5
     *
     * @param
     * @return
     */
    List<TSTop5> queryDieFuTop5();

    List<TSTop5> queryTop5List();
}
