package com;

import java.util.Arrays;

public class ArraysTest {


    public static void main(String[] args) {
        
        int[] arr = {122,533,233,622,4555};

        int temp = 0;

        for (int j = 0; j < arr.length-1 ; j++) {
            for (int i = 0; i < arr.length-1-j; i++) {
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }


        for (int i : arr) {
            System.out.println(i);
        }
        



    }

}
//冒泡排序的交换位置的次数比较多，选择排序次数少效率高
class Select{


    public static void main(String[] args) {

        int[] arr = {12,3,1,6,8,11};
        int temp = 0;
        int min = 0;

        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            //需要比较的数据
            for (int j = i+1; j < arr.length; j++) {

                if(arr[j] < arr[min]){
                    //最小的下标
                    min = j;
                }
            }

            //有最小值
            if(min != i){
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }


        }

        for (int i : arr) {
            System.out.println(i);
        }





    }

}

class HalfSelect{

    public static void main(String[] args) {

        int[] arr = {11,22,33,44,55,66,77,88};

        int select = select(arr, 77);
        System.out.println(select);
        System.out.println(arr[select]);

    }

    public static int select(int[] arr ,int a){

        int begin = 0;
        int end = arr.length - 1;


        while (begin <= end){
            int mid = (begin + end)/2;
            if(arr[mid] == a){
                return mid;
            }else if(arr[mid] < a){
                begin = mid + 1;
            }else if(arr[mid] > a){
                end = mid - 1;
            }

        }
        return -1;
    }


}


//Arrays类
class JavaArraysTest{




}

