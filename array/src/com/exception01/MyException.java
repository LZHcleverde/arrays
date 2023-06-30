package com.exception01;

/**
 * 1.继承Exception   RuntimeException
 * 2.提供两个构造方法，一个无参，一个有参
 *
 */

public class MyException extends RuntimeException{

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }




}

class MyExcTest{

    public static void main(String[] args) {

        MyException e = new MyException("太晚了要睡觉了");
        e.printStackTrace();


    }

}
