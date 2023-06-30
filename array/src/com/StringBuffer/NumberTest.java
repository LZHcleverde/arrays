package com.StringBuffer;

public class NumberTest {


    public static void main(String[] args) {

        //Stirng  int
        String str = "123";
        int i = Integer.parseInt(str);


        //int  String
        int a = 333;
        String s = String.valueOf(a);


        //int  Integer
        Integer integer = Integer.valueOf(a);


        //String  Integer
        Integer integer1 = Integer.valueOf(str);


        //Integer String
        Integer iger = new Integer(123);
        String s1 = String.valueOf(iger);


    }
}
