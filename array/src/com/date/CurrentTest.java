package com.date;

import java.util.Date;

public class CurrentTest {

    public static void main(String[] args) {

        //自1970年1月1日到当前系统时间的总毫秒数
        long l = System.currentTimeMillis();
        System.out.println(l);

        Date date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        System.out.println(date);




    }
}
