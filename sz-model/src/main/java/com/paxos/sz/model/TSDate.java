package com.paxos.sz.model;

import java.math.BigDecimal;

public class TSDate {

    private BigDecimal dateId;

    private String dealDate;

    private String market;

    public BigDecimal getDateId() {
        return dateId;
    }

    public void setDateId(BigDecimal dateId) {
        this.dateId = dateId;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
