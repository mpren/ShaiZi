package com.test.sz.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.test.sz.model.TSDate;
import com.test.sz.model.TSInfo;
import com.test.sz.service.StreamProcessService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.test.sz.constant.InfoConstant.FILE;
import static com.test.sz.constant.InfoConstant.VALUE;

/**
 * @author paxos
 */
@Component
public class StreamProcessBusinessImpl implements StreamProcessBusiness {

    private static final Log LOGGER = LogFactory.getLog(StreamProcessBusinessImpl.class);

    private static final String STOCK_PATH = "http://qt.gtimg.cn/q=";

    @Autowired
    private StreamProcessService streamProcessService;

    @Override
    public void beginStreamProcess() {
        BufferedReader reader;
        URL ur;
        List<TSInfo> insertStock = new ArrayList<>();
        List<TSInfo> updateStock = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        try {
            for (TSInfo s1 : dealFile()) {
                ur = new URL(STOCK_PATH + s1.getStockCode());
                reader = new BufferedReader(new InputStreamReader(ur.openStream(), "GBK"));
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
                        buildInfo(insertStock, updateStock, sb, s1, str);
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("", e);
        } catch (MalformedURLException e) {
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        } finally {

        }

        //批量插入
        streamProcessService.insertByList(insertStock);

        insertOrUpdateDate();

    }

    private void insertOrUpdateDate() {
        TSDate tsDate = new TSDate();
        tsDate.setMarket("ZH");
        Date date = new Date();
        tsDate.setDealDate(new SimpleDateFormat("yyyyMMdd").format(date));
        streamProcessService.insertDate(tsDate);
    }

    private void buildInfo(List<TSInfo> insertStock, List<TSInfo> updateStock, StringBuffer sb, TSInfo s1,
                           String[] str) {
        if (!VALUE.equals(Float.valueOf(str[3]))) {
            TSInfo s = new TSInfo();
            s.setDealedDate(str[29].substring(0, 8));
            s.setDetailTime(str[29]);
            s.setStockName(str[0]);
            s.setStockCode(s1.getStockCode());
            sb.append(str[1].substring(3) + " " + Float.valueOf(str[31]) + "   ");
            s.setTodayPrice(BigDecimal.valueOf(Float.valueOf(str[2])));
            s.setYesterdayPrice(BigDecimal.valueOf(Float.valueOf(str[3])));
            s.setJinKai(BigDecimal.valueOf(Float.valueOf(str[4])));
            s.setDealedCje(BigDecimal.valueOf(Float.valueOf(str[36])));
            s.setDealedCjl(BigDecimal.valueOf(Float.valueOf(str[5])));
            s.setWaiPan(BigDecimal.valueOf(Float.valueOf(str[6])));
            s.setNeiPan(BigDecimal.valueOf(Float.valueOf(str[7])));

            s.setBuy1(BigDecimal.valueOf(Float.valueOf(str[8])));
            s.setBuy1Amount(BigDecimal.valueOf(Float.valueOf(str[9])));
            s.setBuy2(BigDecimal.valueOf(Float.valueOf(str[10])));
            s.setBuy2Amount(BigDecimal.valueOf(Float.valueOf(str[11])));
            s.setBuy3(BigDecimal.valueOf(Float.valueOf(str[12])));
            s.setBuy3Amount(BigDecimal.valueOf(Float.valueOf(str[13])));
            s.setBuy4(BigDecimal.valueOf(Float.valueOf(str[14])));
            s.setBuy4Amount(BigDecimal.valueOf(Float.valueOf(str[15])));
            s.setBuy5(BigDecimal.valueOf(Float.valueOf(str[16])));
            s.setBuy5Amount(BigDecimal.valueOf(Float.valueOf(str[17])));

            s.setSell1(BigDecimal.valueOf(Float.valueOf(str[18])));
            s.setSell1Amount(BigDecimal.valueOf(Float.valueOf(str[19])));
            s.setSell2(BigDecimal.valueOf(Float.valueOf(str[20])));
            s.setSell2Amount(BigDecimal.valueOf(Float.valueOf(str[21])));
            s.setSell3(BigDecimal.valueOf(Float.valueOf(str[22])));
            s.setSell3Amount(BigDecimal.valueOf(Float.valueOf(str[23])));
            s.setSell4(BigDecimal.valueOf(Float.valueOf(str[24])));
            s.setSell4Amount(BigDecimal.valueOf(Float.valueOf(str[25])));
            s.setSell5(BigDecimal.valueOf(Float.valueOf(str[26])));
            s.setSell5Amount(BigDecimal.valueOf(Float.valueOf(str[27])));

            s.setZhangDie(BigDecimal.valueOf(Float.valueOf(str[30])));
            s.setZhangFuLv(BigDecimal.valueOf(Float.valueOf(str[31])));

            s.setZuiDi(BigDecimal.valueOf(Float.valueOf(str[33])));
            s.setZuiGao(BigDecimal.valueOf(Float.valueOf(str[32])));

            if (!StringUtils.isEmpty(str[37])) {
                s.setHuanShouLv(BigDecimal.valueOf(Float.valueOf(str[37])));
            }
            s.setZhenFu(BigDecimal.valueOf(Float.valueOf(str[42])));

            if (!StringUtils.isEmpty(str[43])) {
                s.setLiuTongShiZhi(BigDecimal.valueOf(Float.valueOf(str[43])));
            }

            if (!StringUtils.isEmpty(str[44])) {
                s.setTotalShiZhi(BigDecimal.valueOf(Float.valueOf(str[44])));
            }

            if (!StringUtils.isEmpty(str[45])) {
                s.setShiJinLv(BigDecimal.valueOf(Float.valueOf(str[45])));
            }

            if (!StringUtils.isEmpty(str[46])) {
                s.setZhangTingJia(BigDecimal.valueOf(Float.valueOf(str[46])));
            }

            if (!StringUtils.isEmpty(str[47])) {
                s.setDieTingJia(BigDecimal.valueOf(Float.valueOf(str[47])));
            }

            if (null == streamProcessService.queryDetail(s)) {
                insertStock.add(s);
            } else {
                updateStock.add(s);
            }
        }
    }

    private List<TSInfo> dealFile() {
        List<TSInfo> list = new ArrayList<>();
        ClassLoader classLoader = StreamProcessBusinessImpl.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(FILE);
        BufferedReader br = null;

        String line;
        try (InputStreamReader isr = new InputStreamReader(resourceAsStream, "UTF-8")) {
            br = new BufferedReader(isr);

            while ((line = br.readLine()) != null) {
                TSInfo stock = new TSInfo();
                if ("6".endsWith(line.substring(0, 1))) {
                    stock.setStockCode("sh" + line);
                    list.add(stock);
                } else {
                    stock.setStockCode("sz" + line);
                    list.add(stock);
                }
            }
        } catch (IOException e) {
            LOGGER.error("", e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                LOGGER.error("", e);
            }

            TSInfo info = new TSInfo();
            info.setStockCode("sh000001");
            list.add(info);
        }

        return list;
    }
}
