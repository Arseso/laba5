package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;

public class Pupil extends Human
{
    private HashMap<String, Integer> marks;
    private ArrayList<Integer> schoolcontest = new ArrayList<Integer>();
    private ArrayList<Integer> citycontest  = new ArrayList<Integer>();
    private ArrayList<Integer> regionalcontest = new ArrayList<Integer>();

    public Pupil(String name,String sex, Integer age, HashMap<String,Integer> marks)
    {
        super(name,sex,age);
        this.marks = marks;
    }

    public HashMap<String,Integer> getMarks() { return marks; }
    public void setMarks(HashMap<String,Integer> marks) { this.marks = marks; }
    public ArrayList<Integer> getSchoolcontest() { return schoolcontest; }
    public void setSchoolcontest(ArrayList<Integer> schoolcontest) { this.schoolcontest = schoolcontest; }
    public ArrayList<Integer> getCitycontest() { return citycontest; }
    public void setCitycontest(ArrayList<Integer> citycontest) { this.citycontest = citycontest; }
    public ArrayList<Integer> getRegionalcontest() { return regionalcontest; }
    public void setRegionalcontest(ArrayList<Integer> regionalcontest) { this.regionalcontest = regionalcontest; }

    public void isNumContest(String n, ArrayList<Integer> m)
    {
        try
        {
            int num = Integer.parseInt(n);
            if(num != 0) {m.add(num);}
        }
        catch (NumberFormatException e) {System.out.println("Необходимо вводить только числа");}
    }

    public void contests()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Школьник " + getName());
        System.out.println("Вводите места, которые " + getName() + " получил(а) на школьных олимпиадах, или 0,когда захотите закончить, или он/она не участвовал(а)");
        while(true)
        {
            String number = scan.next();
            isNumContest(number,schoolcontest);
            if (number.equals("0")){break;}
        }
        System.out.println("Вводите места, которые " + getName() + " получил(а) на городских олимпиадах, или 0,когда захотите закончить, или он/она не участвовал(а)");
        while(true)
        {
            String number = scan.next();
            isNumContest(number,citycontest);
            if (number.equals("0")){break;}
        }
        System.out.println("Вводите места, которые " + getName() + " получил(а) на областных олимпиадах, или 0,когда захотите закончить, или он/она не участвовал(а)");
        while(true)
        {
            String number = scan.next();
            isNumContest(number,regionalcontest);
            if (number.equals("0")){break;}
        }
        System.out.println();
    }

    public void pupilMarks1()
    {
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println();
            System.out.println("Добавить предмет и оценку?");
            String answer = scan.next();
            if (answer.equals("y"))
            {
                System.out.println("Введите предмет");
                String subject = scan.next();
                System.out.println("Введите оценку");
                int mark = Integer.parseInt(scan.next());
                marks.put(subject, mark);
            }
            else if (answer.equals("n")) { break; }
            else {System.out.println("Некорректный ответ");}
        }
    }

    public void pupilMarks2()
    {
        System.out.println("Школьник " + getName());
        Scanner scan = new Scanner(System.in);
        marks.put("Математика", 0);
        marks.put("Русский", 0);
        marks.put("Английский", 0);
        marks.put("История", 0);
        marks.put("Физ-ра", 0);
        marks.put("Биология", 0);
        for (Map.Entry entry : marks.entrySet())
        {
            System.out.println("Введите оценку за " + entry.getKey());
            int mark = Integer.parseInt(scan.next());
            entry.setValue(mark);
        }
    }

    public void infoContest()
    {
        if(schoolcontest.size()>0) {System.out.println("Занял(а) " + Collections.min(schoolcontest) + " место на одной из  олимпиад школьного уровня ");}
        else {System.out.println("Не участвовал(а) в школьных олимпиадах");}
        if(citycontest.size()>0) {System.out.println("Занял(а) " + Collections.min(citycontest) + " место на одной из  олимпиад городского уровня ");}
        else {System.out.println("Не участвовал(а) в городских олимпиадах");}
        if(regionalcontest.size()>0) {System.out.println("Занял(а) " + Collections.min(regionalcontest) + " место на одной из  олимпиад областного уровня ");}
        else {System.out.println("Не участвовал(а) в областных олимпиадах");}
    }

    public boolean proverkaMarksOthers()
    {
        boolean fact = true;
        for (int val : marks.values())
        {
            if (val<4) { fact = false; break; }
        }
        return fact;
    }

    public boolean proverkaMarks()
    {
        return (marks.get("Математика") == 5 && marks.get("Русский") == 5 && marks.get("Английский") == 5 && marks.get("История") == 5 && proverkaMarksOthers());
    }

    public boolean proverkaContests()
    {
        return ( Collections.min(regionalcontest) > 0 || Collections.min(schoolcontest) == 1 || ( Collections.min(citycontest) >= 1 && Collections.min(citycontest) <= 3 ) );
    }

    @Override
    public boolean highGrant()
    {
        return ( proverkaMarks() && proverkaContests() );
    }
}
