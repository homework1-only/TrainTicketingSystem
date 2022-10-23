package com.lemon.train;

import com.lemon.train.common.ResponseResult;
import com.lemon.train.entity.Traininfo;
import com.lemon.train.mapper.HolidayMapper;
import com.lemon.train.mapper.TraininfoMapper;
import com.lemon.train.service.TrainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class traintest {
    @Autowired
    TrainService trainService;
    @Autowired
    HolidayMapper holidayMapper;
    @Autowired
    TraininfoMapper traininfoMapper;
    @Test
    public void trainTest1(){
        trainService.queryTrains();
    }

    @Test
    public void traintest2() throws ParseException {
        Map map = new HashMap();
        map.put("status",3);
        //map.put("discount",2);
        double k = holidayMapper.getSpecialDiscount(map);
        System.out.println(k);
        String traindate = "2020-06-05";
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date =  formatter.parse(traindate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void testSql() {
//        Traininfo traininfo = traininfoMapper.selectSingleTrainInfo(1);
//        System.out.println(traininfo);

        Traininfo traininfo1 = traininfoMapper.selectByPrimaryKey(1);
        System.out.println(traininfo1);
    }


}
