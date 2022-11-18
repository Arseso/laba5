package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Student extends Human
{
    private ArrayList<Integer> marks;
    private ArrayList<Integer> courseworks = new ArrayList<Integer>();

    public Student(String name, String sex, Integer age, ArrayList<Integer> marks)
    {
        super(name,sex,age);
        this.marks = marks;
    }

    public ArrayList<Integer> getMarks() { return marks; }
    public void setMarks(ArrayList<Integer> marks) { this.marks = marks; }
    public ArrayList<Integer> getCourseworks() { return courseworks; }
    public void setCourseworks(ArrayList<Integer> courseworks) { this.courseworks = courseworks; }

    public void proverka(String n,ArrayList<Integer> m)
    {
        try
        {
            int num = Integer.parseInt(n);
            if(num != 0) {m.add(num);}
        }
        catch (NumberFormatException e) {System.out.println("Необходимо вводить только числа");}
    }

    public void courseWorks()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Студент " + getName());
        System.out.println("Вводите оценки, которые " + getName() + " получил(а) за курсовые работы, или 0,когда захотите закончить");
        while(true)
        {
            String number = scan.next();
            proverka(number,courseworks);
            if (number.equals("0")){break;}
        }
        System.out.println();
    }

    public void studentMarks()
    {
        System.out.println("Студент " + getName());
        Scanner scan = new Scanner(System.in);
        System.out.println("Вводите оценки, которые " + getName() + " получил(а) на сессии, или 0,когда захотите закончить");
        while(true)
        {
            String number = scan.next();
            proverka(number,marks);
            if (number.equals("0")){break;}
        }
    }

    public void infoCW()
    {
        if (courseworks.size() > 0) {System.out.println("Оценка за курсовые: "); System.out.println(courseworks);}
        else {System.out.println("За курсовые работы оценки не выставлены");}
    }

    public float average()
    {
        int average = 0;
        int sum = 0;
        for (int i : marks) sum+=i;
        average = sum/marks.size();
        return average;
    }

    public boolean proverkaCourse()
    {
        return Collections.max(courseworks) == 5;
    }

    @Override
    public boolean highGrant()
    {
        return ( average()>=4.75 && proverkaCourse());
    }
}
