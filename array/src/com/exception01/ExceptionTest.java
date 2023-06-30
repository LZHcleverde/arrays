package com.exception01;

import java.io.FileNotFoundException;

public class ExceptionTest {

    public static void main(String[] args) throws NullPointerException {

        NullPointerException nullPointerException = new NullPointerException("空指针异常");
        String message = nullPointerException.getMessage();
        System.out.println(message);
        nullPointerException.printStackTrace();


    }
}
