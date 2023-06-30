package com;

public class Mystack {


    Object[] elements = new Object[3];

    static int index;

    public void push(Object object){

        if(index == elements.length){
            System.out.println("栈空间已满！压栈失败！");
            return;
        }
        //未满，index个元素
        elements[index] = object;

        System.out.println("栈帧指向===>" + index);
        index++;
    }

    public void pop(){

        if(index == 0){
            System.out.println("栈空间为空！弹栈失败！");
            return;
        }

        elements[index-1] = null;
        index--;
        System.out.println("栈帧指向==>" + index);

    }


}

class test{

    public static void main(String[] args) {

        Mystack mystack = new Mystack();
        for (Object element : mystack.elements) {
            System.out.println(element);
        }
        System.out.println("====================");
        mystack.push(123);
        mystack.push(111);
        mystack.push(133);

        System.out.println("====================");
        for (Object element : mystack.elements) {
            System.out.println(element);
        }

        System.out.println("==========弹栈==========");
        mystack.pop();
        mystack.pop();
        mystack.pop();
        mystack.pop();
        System.out.println("==========弹栈==========");

        for (Object element : mystack.elements) {
            System.out.println(element);
        }

    }
}
