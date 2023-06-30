package com;

public class StringTest {

    public static void main(String[] args) {

        byte[] bt = {97, 98, 99, 127};
        String str = new String(bt);

        System.out.println(str);


        char[] c = {'我', '是', '人'};
        String str2 = new String(c);
        System.out.println(str2);

        String s3 = new String(c, 1, 2);
        System.out.println(s3);

        char c1 = "你好吗！".charAt(3);
        System.out.println(c1);

        System.out.println("abc".compareTo("ab"));


        System.out.println("HelloWorld.java".contains(".java"));
        boolean java1 = "HelloWorld.java".endsWith("java");
        boolean java2 = "HelloWorld.java".startsWith("He");

        System.out.println("结尾：" + java1);
        System.out.println("开始：" + java2);

        boolean abc = "ABc".equalsIgnoreCase("abc");
        System.out.println(abc);


        byte[] bytes = "abcdefg".getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
        System.out.println();

        int av = "java.javac".indexOf("va");
        System.out.println(av);

        String s = "";
        boolean empty = "".isEmpty();
        System.out.println(empty);

        int length = "今天天气不错".length();
        System.out.println(length);


        String t = "abctt".replace("t", "5");
        System.out.println(t);

        String[] split = "2000-11-22".split("-");
        for (String s1 : split) {
            System.out.println(s1);
        }

        String substring = "http://www.baidu.com".substring(7, 10);
        System.out.println(substring);


        char[] chars = "我是中国人".toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
        System.out.println("BACdtt".toLowerCase());
        System.out.println("BACdtt".toUpperCase());

        //trim去除前后空白
        System.out.println("   hello    iui   yiufjd  ".trim());

        //将非字符串转换成字符串

        String s1 = String.valueOf(123);
        System.out.println(s1);

        String s2 = String.valueOf(new Room("1002","2",true));
        System.out.println(s2);

    }
}
