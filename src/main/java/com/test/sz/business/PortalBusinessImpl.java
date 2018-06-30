package com.test.sz.business;


import com.test.sz.model.TSTop5;
import com.test.sz.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PortalBusinessImpl implements PortalBusiness {

    @Autowired
    private PortalService portalService;

    @Override
    public Map<String, BigDecimal> queryDieFuTop5() {
        Map<String, BigDecimal> mapV = new HashMap<>();
        List<TSTop5> top5List = portalService.queryDieFuTop5();
        Map<String, List<TSTop5>> top5ListMap = top5List.stream().collect(Collectors.groupingBy(TSTop5::getStatisticDate));
        top5ListMap.forEach((k, v) ->
                mapV.put(k, v.stream().map(TSTop5::getDieFu).reduce(BigDecimal.ZERO, BigDecimal::add))
        );
        return mapV;
    }
}
