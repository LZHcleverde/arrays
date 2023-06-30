package com.lzh.test;

import com.lzh.utils.MD5Util;
import org.junit.Test;

public class MyTest {

    @Test
    public void testMD5(){

        String str = "2,3,4,5,";

        String[] split = str.split(",");
        for (String s : split) {
            System.out.print(s);
        }
        System.out.println("a");

    }
}
