package com.paxos.sz.model;

import java.math.BigDecimal;

public class TSTop5 {

    private String stockCode;
    private String continueDays;
    private BigDecimal dieFu;
    private BigDecimal nextDayDieFu;
    private String statisticDate;
    private BigDecimal kaiPan;
    private String stockName;
    private BigDecimal zuoShou;
    private String theWay;
    private String gaoKai;
    private String kdj;
    private String tdRate;
    private String gaoKaiTo;
    private String gaoKaiFrom;
    private String sdFrom;
    private String sdTo;
    private BigDecimal sellPrice;
    private BigDecimal buyPrice;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getContinueDays() {
        return continueDays;
    }

    public void setContinueDays(String continueDays) {
        this.continueDays = continueDays;
    }

    public BigDecimal getDieFu() {
        return dieFu;
    }

    public void setDieFu(BigDecimal dieFu) {
        this.dieFu = dieFu;
    }

    public BigDecimal getNextDayDieFu() {
        return nextDayDieFu;
    }

    public void setNextDayDieFu(BigDecimal nextDayDieFu) {
        this.nextDayDieFu = nextDayDieFu;
    }

    public String getStatisticDate() {
        return statisticDate;
    }

    public void setStatisticDate(String statisticDate) {
        this.statisticDate = statisticDate;
    }

    public BigDecimal getKaiPan() {
        return kaiPan;
    }

    public void setKaiPan(BigDecimal kaiPan) {
        this.kaiPan = kaiPan;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getZuoShou() {
        return zuoShou;
    }

    public void setZuoShou(BigDecimal zuoShou) {
        this.zuoShou = zuoShou;
    }

    public String getTheWay() {
        return theWay;
    }

    public void setTheWay(String theWay) {
        this.theWay = theWay;
    }

    public String getGaoKai() {
        return gaoKai;
    }

    public void setGaoKai(String gaoKai) {
        this.gaoKai = gaoKai;
    }

    public String getKdj() {
        return kdj;
    }

    public void setKdj(String kdj) {
        this.kdj = kdj;
    }

    public String getTdRate() {
        return tdRate;
    }

    public void setTdRate(String tdRate) {
        this.tdRate = tdRate;
    }

    public String getGaoKaiTo() {
        return gaoKaiTo;
    }

    public void setGaoKaiTo(String gaoKaiTo) {
        this.gaoKaiTo = gaoKaiTo;
    }

    public String getGaoKaiFrom() {
        return gaoKaiFrom;
    }

    public void setGaoKaiFrom(String gaoKaiFrom) {
        this.gaoKaiFrom = gaoKaiFrom;
    }

    public String getSdFrom() {
        return sdFrom;
    }

    public void setSdFrom(String sdFrom) {
        this.sdFrom = sdFrom;
    }

    public String getSdTo() {
        return sdTo;
    }

    public void setSdTo(String sdTo) {
        this.sdTo = sdTo;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}