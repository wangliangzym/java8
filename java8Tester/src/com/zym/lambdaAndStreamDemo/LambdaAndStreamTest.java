package com.zym.lambdaAndStreamDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author wangliang
 * @date 2019/3/6 0006
 */
public class LambdaAndStreamTest {

    List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
            add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
            add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
            add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
            add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
            add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
            add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        }
    };

    List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };

    /**
     * 使用forEach迭代出上述列表
     */
    @Test
    public void forEachTest(){
        javaProgrammers.forEach(p -> System.out.printf("%s %s;",p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach(p->System.out.printf("%s %s;",p.getFirstName(), p.getLastName()));
    }

    /**
     * 我们同样使用forEach方法,增加程序员的工资5%:
     */
    @Test
    public void forEachTest2(){
        Consumer<Person> giveRise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRise);
        phpProgrammers.forEach(giveRise);
    }

    /**
     * 过滤器的使用
     * 显示月薪超过1400美元的PHP程序员
     */
    @Test
    public void filterTest(){
        System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
        phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));
    }

    /**
     * 自定义过滤器
     */
    @Test
    public void  filterTest1(){
        // 定义 filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        //重用filter
        System.out.println("下面是年龄大于24岁的女JAVA程序员:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p)->System.out.printf("%s %s; ",p.getFirstName(),p.getLastName()));
    }

    /**
     * 使用limit限制结果集个数
     */
    @Test
    public void limitTest(){
        System.out.println("最前面的三个java程序员");
        javaProgrammers.stream()
                .limit(3)
                .forEach((p)->System.out.printf("%s %s ; %n",p.getFirstName(),p.getLastName()));
        System.out.println("最前面的3个女性 Java programmers:");
        javaProgrammers.stream()
                .filter(p->("female".equals(p.getGender())))
                .limit(3)
                .forEach(p->System.out.printf("%s %s; %n",p.getFirstName(),p.getLastName()));
    }

    /**
     * 排序的使用
     */
    @Test
    public void sortTest(){
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammers = javaProgrammers.stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(Collectors.toList());
        sortedJavaProgrammers.forEach(p->System.out.printf("%s %s;%n",p.getFirstName(),p.getLastName()));
        System.out.println("根据 salary 排序 Java programmers:");
        javaProgrammers.stream()
                .sorted((p,p2)->(p.getSalary()-p2.getSalary()))
                .forEach(p->System.out.printf("%s %s:%s;%n",p.getFirstName(),p.getLastName(),p.getSalary()));
    }

    /**
     * MIN及MAX方法的使用
     */
    @Test
    public void minAndMaxTest(){
        System.out.println("工资最低的 Java programmer:");
        Person person = javaProgrammers.stream()
                .min((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d. %n", person.getFirstName(), person.getLastName(), person.getSalary());
        System.out.println("工资最高的 Java programmer:");
        Person person1 = javaProgrammers.stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d. %n", person1.getFirstName(), person1.getLastName(), person1.getSalary());
    }

    @Test
    public void mapTest(){
        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        String phpDevelopers  = javaProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(" ; "));
        System.out.println(phpDevelopers);

        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> collect = javaProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println("将 Java programmers 的 first name 存放到 Map:");
        Map<String, Integer> collect1 = javaProgrammers.stream()
                .collect(Collectors.toMap(Person::getFirstName, Person::getSalary));
        System.out.println(collect1);

    }

    @Test
    public void streamTest(){
        Map<String, Integer> collect = javaProgrammers.stream()
                .filter(p -> p.getSalary() > 1400)
                .collect(Collectors.toMap(Person::getFirstName, Person::getSalary));
        System.out.println(collect);
    }

}
