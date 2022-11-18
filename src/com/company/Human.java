package com.company;

abstract class Human
{
    private String name;
    private String sex;
    private int age;

    public Human()
    {
        name = "";
        sex = "";
        age = 0;
    }

    public Human(String name, String sex, int age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Human(Human human)
    {
        this.name = human.name;
        this.sex = human.sex;
        this.age = human.age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public boolean IsShe() { return  sex.equals("Ж"); }

    public abstract boolean highGrant();

}