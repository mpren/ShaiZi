package com.paxos.sz.business;


import com.paxos.sz.model.TSTop5;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PortalBusiness {
    Map<String,BigDecimal> queryDieFuTop5();

    List<TSTop5> queryTop5List();
}
