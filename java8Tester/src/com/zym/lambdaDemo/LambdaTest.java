package com.zym.lambdaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangliang
 * @date 2019/3/6 0006
 */
public class LambdaTest {
    public static void main(String[] args) {

        /**
         * lambda表达式的基本使用
         */
        List<String> lists = new ArrayList<>();
        lists.add("fengqingyang");
        lists.add("duanyu");
        lists.add("qiaofeng");
        lists.add("xuzhu");
        lists.add("rengyingying");
        //使用lambda表达式以及函数操作
        System.out.println("-----------lambda表达式及函数操作-------------");
        lists.forEach(p-> System.out.println(p + ";"));
        //在java8中使用双冒号操作符
        System.out.println("-----------在java8中使用双冒号操作符-------------");
        lists.forEach(System.out::println);

        /**
         * 匿名类可以使用lambda表达式来代替。
         */
        //1.1 thread使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();
        //1.2 thread使用lambda表达式的方式
        new Thread(()-> System.out.println("Hello World!")).start();

        //2.1 Runnable使用匿名内部类
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world run1");
            }
        };
        //2.2 Runnable使用lambda表达式
        Runnable run2 = () -> System.out.println("hello world run2");
        run1.run();
        run2.run();

        /**
         * 使用lambda表达式来排序集合
         */
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        //1.1 使用匿名内部类根据name排序players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        //1.2 使用lambda表达式根据name排序
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players,sortByName);
        //1.3 也可以采用如下形式
        Arrays.sort(players,(String s1, String s2)->(s1.compareTo(s2)));

        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });

        // 1.2 使用 lambda expression 排序,根据 surname
        Comparator<String> sortBySurname = (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) );
        Arrays.sort(players, sortBySurname);

        // 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(players, (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) )
        );

        // 2.1 使用匿名内部类根据 name lenght 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

        // 2.2 使用 lambda expression 排序,根据 name lenght
        Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
        Arrays.sort(players, sortByNameLenght);

        // 2.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // 3.2 使用 lambda expression 排序,根据最后一个字母
        Comparator<String> sortByLastLetter =
                (String s1, String s2) ->
                        (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);

        // 3.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));

    }
}
