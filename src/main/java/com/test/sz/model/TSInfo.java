package com.test.sz.model;

import java.math.BigDecimal;

public class TSInfo {

	private String stockCode;

    private String stockName;

    private BigDecimal todayPrice;

    private BigDecimal yesterdayPrice;

    private String dealedDate;

    private BigDecimal jinKai;

    private BigDecimal dealedCje;

    private BigDecimal dealedCjl;

    private BigDecimal totalShiZhi;

    private BigDecimal liuTongShiZhi;

    private BigDecimal waiPan;

    private BigDecimal neiPan;

    private BigDecimal buy1;

    private BigDecimal buy2;

    private BigDecimal buy3;

    private BigDecimal buy4;

    private BigDecimal buy5;

    private BigDecimal buy1Amount;

    private BigDecimal buy2Amount;

    private BigDecimal buy3Amount;

    private BigDecimal buy4Amount;

    private BigDecimal buy5Amount;

    private BigDecimal sell1;

    private BigDecimal sell2;

    private BigDecimal sell3;

    private BigDecimal sell4;

    private BigDecimal sell5;

    private BigDecimal sell1Amount;

    private BigDecimal sell2Amount;

    private BigDecimal sell3Amount;

    private BigDecimal sell4Amount;

    private BigDecimal sell5Amount;

    private BigDecimal zhangDie;

    private BigDecimal zhangFuLv;

    private BigDecimal huanShouLv;

    private BigDecimal shiYinLv;

    private BigDecimal zuiGao;

    private BigDecimal zuiDi;

    private BigDecimal zhenFu;

    private BigDecimal shiJinLv;

    private BigDecimal zhangTingJia;

    private BigDecimal dieTingJia;
    
    private String detailTime;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public BigDecimal getTodayPrice() {
        return todayPrice;
    }

    public void setTodayPrice(BigDecimal todayPrice) {
        this.todayPrice = todayPrice;
    }

    public BigDecimal getYesterdayPrice() {
        return yesterdayPrice;
    }

    public void setYesterdayPrice(BigDecimal yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
    }

    public String getDealedDate() {
        return dealedDate;
    }

    public void setDealedDate(String dealedDate) {
        this.dealedDate = dealedDate == null ? null : dealedDate.trim();
    }

    public BigDecimal getJinKai() {
        return jinKai;
    }

    public void setJinKai(BigDecimal jinKai) {
        this.jinKai = jinKai;
    }

    public BigDecimal getDealedCje() {
        return dealedCje;
    }

    public void setDealedCje(BigDecimal dealedCje) {
        this.dealedCje = dealedCje;
    }

    public BigDecimal getDealedCjl() {
        return dealedCjl;
    }

    public void setDealedCjl(BigDecimal dealedCjl) {
        this.dealedCjl = dealedCjl;
    }

    public BigDecimal getTotalShiZhi() {
        return totalShiZhi;
    }

    public void setTotalShiZhi(BigDecimal totalShiZhi) {
        this.totalShiZhi = totalShiZhi;
    }

    public BigDecimal getLiuTongShiZhi() {
        return liuTongShiZhi;
    }

    public void setLiuTongShiZhi(BigDecimal liuTongShiZhi) {
        this.liuTongShiZhi = liuTongShiZhi;
    }

    public BigDecimal getWaiPan() {
        return waiPan;
    }

    public void setWaiPan(BigDecimal waiPan) {
        this.waiPan = waiPan;
    }

    public BigDecimal getNeiPan() {
        return neiPan;
    }

    public void setNeiPan(BigDecimal neiPan) {
        this.neiPan = neiPan;
    }

    public BigDecimal getBuy1() {
        return buy1;
    }

    public void setBuy1(BigDecimal buy1) {
        this.buy1 = buy1;
    }

    public BigDecimal getBuy2() {
        return buy2;
    }

    public void setBuy2(BigDecimal buy2) {
        this.buy2 = buy2;
    }

    public BigDecimal getBuy3() {
        return buy3;
    }

    public void setBuy3(BigDecimal buy3) {
        this.buy3 = buy3;
    }

    public BigDecimal getBuy4() {
        return buy4;
    }

    public void setBuy4(BigDecimal buy4) {
        this.buy4 = buy4;
    }

    public BigDecimal getBuy5() {
        return buy5;
    }

    public void setBuy5(BigDecimal buy5) {
        this.buy5 = buy5;
    }

    public BigDecimal getBuy1Amount() {
        return buy1Amount;
    }

    public void setBuy1Amount(BigDecimal buy1Amount) {
        this.buy1Amount = buy1Amount;
    }

    public BigDecimal getBuy2Amount() {
        return buy2Amount;
    }

    public void setBuy2Amount(BigDecimal buy2Amount) {
        this.buy2Amount = buy2Amount;
    }

    public BigDecimal getBuy3Amount() {
        return buy3Amount;
    }

    public void setBuy3Amount(BigDecimal buy3Amount) {
        this.buy3Amount = buy3Amount;
    }

    public BigDecimal getBuy4Amount() {
        return buy4Amount;
    }

    public void setBuy4Amount(BigDecimal buy4Amount) {
        this.buy4Amount = buy4Amount;
    }

    public BigDecimal getBuy5Amount() {
        return buy5Amount;
    }

    public void setBuy5Amount(BigDecimal buy5Amount) {
        this.buy5Amount = buy5Amount;
    }

    public BigDecimal getSell1() {
        return sell1;
    }

    public void setSell1(BigDecimal sell1) {
        this.sell1 = sell1;
    }

    public BigDecimal getSell2() {
        return sell2;
    }

    public void setSell2(BigDecimal sell2) {
        this.sell2 = sell2;
    }

    public BigDecimal getSell3() {
        return sell3;
    }

    public void setSell3(BigDecimal sell3) {
        this.sell3 = sell3;
    }

    public BigDecimal getSell4() {
        return sell4;
    }

    public void setSell4(BigDecimal sell4) {
        this.sell4 = sell4;
    }

    public BigDecimal getSell5() {
        return sell5;
    }

    public void setSell5(BigDecimal sell5) {
        this.sell5 = sell5;
    }

    public BigDecimal getSell1Amount() {
        return sell1Amount;
    }

    public void setSell1Amount(BigDecimal sell1Amount) {
        this.sell1Amount = sell1Amount;
    }

    public BigDecimal getSell2Amount() {
        return sell2Amount;
    }

    public void setSell2Amount(BigDecimal sell2Amount) {
        this.sell2Amount = sell2Amount;
    }

    public BigDecimal getSell3Amount() {
        return sell3Amount;
    }

    public void setSell3Amount(BigDecimal sell3Amount) {
        this.sell3Amount = sell3Amount;
    }

    public BigDecimal getSell4Amount() {
        return sell4Amount;
    }

    public void setSell4Amount(BigDecimal sell4Amount) {
        this.sell4Amount = sell4Amount;
    }

    public BigDecimal getSell5Amount() {
        return sell5Amount;
    }

    public void setSell5Amount(BigDecimal sell5Amount) {
        this.sell5Amount = sell5Amount;
    }

    public BigDecimal getZhangDie() {
        return zhangDie;
    }

    public void setZhangDie(BigDecimal zhangDie) {
        this.zhangDie = zhangDie;
    }

    public BigDecimal getZhangFuLv() {
        return zhangFuLv;
    }

    public void setZhangFuLv(BigDecimal zhangFuLv) {
        this.zhangFuLv = zhangFuLv;
    }

    public BigDecimal getHuanShouLv() {
        return huanShouLv;
    }

    public void setHuanShouLv(BigDecimal huanShouLv) {
        this.huanShouLv = huanShouLv;
    }

    public BigDecimal getShiYinLv() {
        return shiYinLv;
    }

    public void setShiYinLv(BigDecimal shiYinLv) {
        this.shiYinLv = shiYinLv;
    }

    public BigDecimal getZuiGao() {
        return zuiGao;
    }

    public void setZuiGao(BigDecimal zuiGao) {
        this.zuiGao = zuiGao;
    }

    public BigDecimal getZuiDi() {
        return zuiDi;
    }

    public void setZuiDi(BigDecimal zuiDi) {
        this.zuiDi = zuiDi;
    }

    public BigDecimal getZhenFu() {
        return zhenFu;
    }

    public void setZhenFu(BigDecimal zhenFu) {
        this.zhenFu = zhenFu;
    }

    public BigDecimal getShiJinLv() {
        return shiJinLv;
    }

    public void setShiJinLv(BigDecimal shiJinLv) {
        this.shiJinLv = shiJinLv;
    }

    public BigDecimal getZhangTingJia() {
        return zhangTingJia;
    }

    public void setZhangTingJia(BigDecimal zhangTingJia) {
        this.zhangTingJia = zhangTingJia;
    }

    public BigDecimal getDieTingJia() {
        return dieTingJia;
    }

    public void setDieTingJia(BigDecimal dieTingJia) {
        this.dieTingJia = dieTingJia;
    }

	public String getDetailTime() {
		return detailTime;
	}

	public void setDetailTime(String detailTime) {
		this.detailTime = detailTime;
	}

}