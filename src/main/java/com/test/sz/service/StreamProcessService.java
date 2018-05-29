package com.test.sz.service;

import com.test.sz.model.TSInfo;

import java.util.List;

/**
 * @author paxos
 */
public interface StreamProcessService {
    /**
     * 查询详细
     *
     * @param info
     * @return
     */
    TSInfo queryDetail(TSInfo info);

    /**
     * 批量插入
     *
     * @param info
     */
    void insertByList(List<TSInfo> info);
}
