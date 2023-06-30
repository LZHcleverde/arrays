package com;

import java.util.Scanner;

public class RoomTest {

    public static void main(String[] args) {

        boolean f = true;


        Room[][] rooms = new Room[3][3];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = new Room(i+"0"+j,String.valueOf(i),false);
                System.out.print("[" + rooms[i][j].state + "]"+ "   ");
            }
            System.out.println("");
        }


        while (f){
            System.out.println("=====================================");
            Scanner scanner = new Scanner(System.in);
            System.out.print( "1.住房"+ "\n" + "2.退房"+ "\n" + "请输入操作：");
            String next1 = scanner.next();

            if(next1.equals("1")){
                System.out.print("请输入房间编号：");
                String next = scanner.next();
                //空位
                boolean sta = false;
                for (int i = 0; i < rooms.length; i++) {
                    for (int j = 0; j < rooms[i].length; j++) {
                        if(rooms[i][j].getRoomId().equals(next)){
                            if(!rooms[i][j].isState()){
                                sta = true;
                            }
                            if(sta){
                                System.out.println("有空房,预定成功！");
                                rooms[i][j].setState(true);
                                System.out.println("=============================");
                                System.out.println("");
                                break;
                            }
                            sta = false;
                        }
                    }
                }
                //展示
                for (int i = 0; i < rooms.length; i++) {
                    for (int j = 0; j < rooms[i].length; j++) {
                        System.out.print("[" + rooms[i][j].state + "]"+ "   ");
                    }
                    System.out.println("");
                }


            }else if(next1.equals("2")){
                //退房
                System.out.print("请输入房间编号：");
                String next = scanner.next();
                //空位
                boolean sta = true;
                for (int i = 0; i < rooms.length; i++) {
                    for (int j = 0; j < rooms[i].length; j++) {

                        if(rooms[i][j].getRoomId().equals(next)){
                            if(rooms[i][j].isState()){
                                sta = false;
                            }
                            if(!sta){
                                System.out.println("退房成功！");
                                rooms[i][j].setState(false);
                                System.out.println("=============================");
                                System.out.println("");

                                break;
                            }else {
                                System.out.println("没有预定此房间，不可退房！");
                            }
                            sta = false;
                        }
                    }
                }
                //展示
                for (int i = 0; i < rooms.length; i++) {
                    for (int j = 0; j < rooms[i].length; j++) {
                        System.out.print("[" + rooms[i][j].state + "]"+ "   ");
                    }
                    System.out.println("");
                }
            }else {
                System.out.println("输入有误！");
            }
        }//while












    }
}
