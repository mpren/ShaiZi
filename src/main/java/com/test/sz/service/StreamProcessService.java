package com.test.sz.service;

import com.test.sz.model.TSDate;
import com.test.sz.model.TSInfo;
import com.test.sz.model.TSTop5;

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

    /**
     * 查询日期
     *
     * @param date
     * @return
     */
    TSDate queryDate(TSDate date);

    /**
     * 插入日期
     *
     * @param date
     * @return
     */
    void insertDate(TSDate date);

    /**
     * 查询top5
     *
     * @param
     * @return
     */
    List<TSTop5> calcTop5();

    /**
     * 插入
     *
     * @param top5
     * @return
     */
    void insertTop5ByList(List<TSTop5> top5);
}
