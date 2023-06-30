package com.date;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {

        Random random = new Random();

        int[] ints = new int[5];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 9;
        }


        int temp = 0;

        while(temp < ints.length){

            int i = random.nextInt(5);
            System.out.println("生成了：" + i);

            String s = Arrays.toString(ints);
            
            if(!s.contains(String.valueOf(i))){
                ints[temp] = i;
                temp++;
            }
        }

        for (int anInt : ints) {
            System.out.print(anInt + "  ");
        }




    }


}

class Test1{

    public static void main(String[] args) {

        int[] a = {1,23,3};
        String s = Arrays.toString(a);



    }
}
