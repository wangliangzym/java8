package com.zym.lambdaAndStreamDemo;

/**
 * @author wangliang
 * @date 2019/3/6 0006
 */
public class Person {

    private String firstName;

    private String lastName;

    private String job;

    private String gender;

    private Integer salary;

    private Integer age;

    public Person() {
    }

    public Person(String firstName, String lastName, String job, String gender, Integer age, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
