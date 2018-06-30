package com.test.sz.dao;

import com.test.sz.model.TSTop5;

import java.util.List;

/**
 * @author paxos
 */
public interface TSTop5Dao {

    void insert(List<TSTop5> top5);

    List<TSTop5> calcDieFuTop5();

    List<TSTop5> queryDieFuTop5();
}
