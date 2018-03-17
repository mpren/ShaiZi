package com.mpren.sz.auto;

import com.alibaba.fastjson.JSON;
import com.mpren.sz.model.TSInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean初始化完成开始计算
 */
@Component
public class InitDataLifecycle implements SmartLifecycle {

    private final static Logger logger = LoggerFactory.getLogger(InitDataLifecycle.class);

    private static final String STOCK_PATH = "http://qt.gtimg.cn/q=";

    private final RedisTemplate redisTemplate;

    @Autowired
    public InitDataLifecycle(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private void init() {
        List<TSInfo> tsInfoList = dealFile();
        final BufferedReader[] reader = new BufferedReader[1];
        final URL[] ur = new URL[1];

        tsInfoList.forEach(s -> {
            try {
                ur[0] = new URL(STOCK_PATH + s.getStockCode());
                reader[0] = new BufferedReader(new InputStreamReader(
                        ur[0].openStream(), "GBK"));
                String line;

                while ((line = reader[0].readLine()) != null) {

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

                        if (!"0.00".equals(str[3])) {
                            s.setDealedDate(str[29].substring(0, 8));
                            s.setDetailTime(str[29]);
                            s.setStockName(str[0]);
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

                            //系统设计规划使用kafka streams流式计算，但鉴于kafka比较重，当前使用Redis替代订阅发布。
                            redisTemplate.convertAndSend("tsInfo", JSON.toJSONString(s));
                        }
                    }
                }
            } catch (MalformedURLException e) {
                logger.error("MalformedURLException :", e);
            } catch (IOException e) {
                logger.error("IOException :", e);
            } catch (Exception e) {
                logger.error("Exception :", e);
            }
        });

        logger.trace("init complete !!!");
    }

    private List<TSInfo> dealFile() {
        List<TSInfo> codeList = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:codes");
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                TSInfo stock = new TSInfo();
                if ("6".endsWith(line.substring(0, 1))) {
                    stock.setStockCode("sh" + line);
                    codeList.add(stock);
                } else {
                    stock.setStockCode("sz" + line);
                    codeList.add(stock);
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException :", e);
        } catch (Exception e) {
            logger.error("Exception :", e);
        } finally {
            TSInfo stock = new TSInfo();
            stock.setStockCode("sh000001");
            codeList.add(stock);
        }
        return codeList;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {

    }

    @Override
    public void start() {
        init();
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
