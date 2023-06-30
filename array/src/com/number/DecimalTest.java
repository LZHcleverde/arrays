package com.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalTest {


    public static void main(String[] args) {

        BigDecimal v1 = new BigDecimal(100);
        BigDecimal v2 = new BigDecimal(200);
        //求和
        BigDecimal add = v1.add(v2);
        System.out.println(add);


    }
}
