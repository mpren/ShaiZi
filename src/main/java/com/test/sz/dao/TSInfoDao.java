package com.test.sz.dao;

import com.test.sz.model.TSInfo;

import java.util.List;

/**
 * @author z673936
 */
public interface TSInfoDao {
    /**
     * 查询详细
     *
     * @param info
     * @return
     */
    TSInfo queryInfoDetail(TSInfo info);

    /**
     * 批量插入
     *
     * @param info
     */
    void insertByList(List<TSInfo> info);

}
