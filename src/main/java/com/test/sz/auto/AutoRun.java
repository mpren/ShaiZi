package com.test.sz.auto;

import com.test.sz.model.TSInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class AutoRun implements SmartLifecycle {

    private static List<TSInfo> list = new ArrayList<>();

    private static final String STOCK_PATH = "http://qt.gtimg.cn/q=";

    @Autowired
    private RedisTemplate redisTemplate;

    public void autoRun() {
        dealFile();
        BufferedReader reader = null;
        URL ur = null;
        List<TSInfo> insertStock = new ArrayList<>();
        List<TSInfo> updateStock = new ArrayList<>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        StringBuffer sb = new StringBuffer();

        try {
            for (TSInfo s1 : list) {
                ur = new URL(STOCK_PATH + s1.getStockCode());
                @SuppressWarnings("unused")
                HttpURLConnection uc = (HttpURLConnection) ur.openConnection();
                reader = new BufferedReader(new InputStreamReader(
                        ur.openStream(), "GBK"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("pv_none_match")) {
                        continue;
                    }
                    String info;
                    if (line.substring(0, 20).contains("51~")) {
                        info = line.substring(15);
                    } else {
                        info = line.substring(14);
                    }
                    String[] str = info.split("~");
                    if (str.length > 5) {
                        if (!"0.00".equals(Float.valueOf(str[3]))) {
                            TSInfo s = new TSInfo();
                            s.setDealedDate(str[29].substring(0, 8));
                            s.setDetailTime(str[29]);
                            s.setStockName(str[0]);
                            s.setStockCode(s1.getStockCode());
                            sb.append(str[1].substring(3) + " " + Float.valueOf(str[31]) + "   ");
                            s.setTodayPrice(BigDecimal.valueOf(Float
                                    .valueOf(str[2])));
                            s.setYesterdayPrice(BigDecimal.valueOf(Float
                                    .valueOf(str[3])));
                            s.setJinKai(BigDecimal.valueOf(Float
                                    .valueOf(str[4])));
                            s.setDealedCje(BigDecimal.valueOf(Float
                                    .valueOf(str[36])));
                            s.setDealedCjl(BigDecimal.valueOf(Float
                                    .valueOf(str[5])));
                            s.setWaiPan(BigDecimal.valueOf(Float
                                    .valueOf(str[6])));
                            s.setNeiPan(BigDecimal.valueOf(Float
                                    .valueOf(str[7])));

                            s.setBuy1(BigDecimal.valueOf(Float.valueOf(str[8])));
                            s.setBuy1Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[9])));
                            s.setBuy2(BigDecimal.valueOf(Float.valueOf(str[10])));
                            s.setBuy2Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[11])));
                            s.setBuy3(BigDecimal.valueOf(Float.valueOf(str[12])));
                            s.setBuy3Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[13])));
                            s.setBuy4(BigDecimal.valueOf(Float.valueOf(str[14])));
                            s.setBuy4Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[15])));
                            s.setBuy5(BigDecimal.valueOf(Float.valueOf(str[16])));
                            s.setBuy5Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[17])));

                            s.setSell1(BigDecimal.valueOf(Float
                                    .valueOf(str[18])));
                            s.setSell1Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[19])));
                            s.setSell2(BigDecimal.valueOf(Float
                                    .valueOf(str[20])));
                            s.setSell2Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[21])));
                            s.setSell3(BigDecimal.valueOf(Float
                                    .valueOf(str[22])));
                            s.setSell3Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[23])));
                            s.setSell4(BigDecimal.valueOf(Float
                                    .valueOf(str[24])));
                            s.setSell4Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[25])));
                            s.setSell5(BigDecimal.valueOf(Float
                                    .valueOf(str[26])));
                            s.setSell5Amount(BigDecimal.valueOf(Float
                                    .valueOf(str[27])));

                            s.setZhangDie(BigDecimal.valueOf(Float
                                    .valueOf(str[30])));
                            s.setZhangFuLv(BigDecimal.valueOf(Float
                                    .valueOf(str[31])));

                            s.setZuiDi(BigDecimal.valueOf(Float
                                    .valueOf(str[33])));
                            s.setZuiGao(BigDecimal.valueOf(Float
                                    .valueOf(str[32])));
                            if (null != str[37] && !"".equals(str[37])) {
                                s.setHuanShouLv(BigDecimal.valueOf(Float
                                        .valueOf(str[37])));
                            }
                            s.setZhenFu(BigDecimal.valueOf(Float
                                    .valueOf(str[42])));
                            if (null != str[43] && !"".equals(str[43]))
                                s.setLiuTongShiZhi(BigDecimal.valueOf(Float.valueOf(str[43])));
                            if (null != str[44] && !"".equals(str[44]))
                                s.setTotalShiZhi(BigDecimal.valueOf(Float.valueOf(str[44])));
                            if (null != str[45] && !"".equals(str[45]))
                                s.setShiJinLv(BigDecimal.valueOf(Float.valueOf(str[45])));
                            if (null != str[46] && !"".equals(str[46]))
                                s.setZhangTingJia(BigDecimal.valueOf(Float.valueOf(str[46])));
                            if (null != str[47] && !"".equals(str[47]))
                                s.setDieTingJia(BigDecimal.valueOf(Float.valueOf(str[47])));
                            redisTemplate.opsForSet().add(s.getStockCode(), s);
                        }
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void dealFile() {
        try {
            File file = ResourceUtils.getFile("classpath:codes.txt");
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String instring;
            while ((instring = br.readLine()) != null) {
                TSInfo stock = new TSInfo();
                if ("6".endsWith(instring.substring(0, 1))) {
                    stock.setStockCode("sh" + instring);
                    list.add(stock);
                } else {
                    stock.setStockCode("sz" + instring);
                    list.add(stock);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            TSInfo stock = new TSInfo();
            stock.setStockCode("sh000001");
            list.add(stock);
        }
    }

    static String[] header = {"0名称", "1代码 ", "2当前价格 ", "3昨收  ", "4今开",
            "5成交量（手）  ", "6外盘 ", "7内盘 ", "8买一  ", "9买一量（手）", "10买二", "11卖二量",
            "12买三  ", "13买三量（手）", "14买四", "15买四量（手） ", "16买五  ", "17买五量（手）",
            "18卖一 ", "19卖一量（手）  ", "20卖二", "21卖二量", "22卖三", "23卖三量（手）", "24卖四",
            "25卖四量（手） ", "26卖五", "27卖五量（手）", "28最近逐笔成交", "29时间", "30涨跌",
            "31涨跌%", "32最高", "33最低", "34价格/成交量（手）/成交额  ", "35成交量（手）",
            "36成交额（万）", "37换手率", "38市盈率", "39", "40最高  ", "41最低", "42振幅 ",
            "43流通市值", "44总市值", "45市净率", "46涨停价", "47跌停价", "48空"};

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {

    }

    @Override
    public void start() {
        autoRun();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
