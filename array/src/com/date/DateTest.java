package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss SSS");
        String format = simp.format(date);
        System.out.println(format);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss");
        Date parse = sdf1.parse("2000-11-11,11:11:11");
        System.out.println(parse);



    }
}
