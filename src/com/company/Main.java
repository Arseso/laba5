package com.company;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

public class Main
{
    public static void enterInfo(ArrayList<Pupil> pupils,ArrayList<Student> students)
    {
        for(Pupil pup : pupils )
        {
            pup.pupilMarks2();
            pup.contests();
        }

        for(Student stut : students )
        {
            stut.studentMarks();
            stut.courseWorks();
        }
    }
    public static void hihgGrantAll(ArrayList<Pupil> pupils,ArrayList<Student> students)
    {
        ArrayList<Human> all = new ArrayList<Human>();
        all.addAll(pupils);all.addAll(students);
        ArrayList<Human> highGrantStandPu = new ArrayList<Human>();

        for(Human chel : all)
        {
            if(chel.highGrant()) { highGrantStandPu.add(chel); }
        }

        for(Human chel : highGrantStandPu)
        {
            System.out.println(chel.getName() + " " + chel.getSex() + " " + chel.getAge());
        }
    }

    public static void StudentCourseWorks(ArrayList<Student> students)
    {
        ArrayList<Student> StudentsWithCW = new ArrayList<Student>();
        System.out.println("Студенты у которых есть оценки за курсовые работы:");
        for(Student stut : students )
        {
            if(stut.getCourseworks().size() != 0)
            {
                StudentsWithCW.add(stut);
            }
        }
        for(Student st : StudentsWithCW)
        {
            System.out.println(st.getName() + " " + st.getSex() + " " + st.getAge());
            st.infoCW();
        }
    }

    public static void girlsOnContests(ArrayList<Pupil> pupils)
    {
        ArrayList<Pupil> GirlsPrizeWinner = new ArrayList<Pupil>();
        System.out.println("Школьницы занявшие первые места на олимпиадах:");
        for(Pupil pup : pupils)
        {
            if(  (Collections.max(pup.getSchoolcontest()) == 1 || Collections.max(pup.getCitycontest()) == 1 || Collections.max(pup.getRegionalcontest()) == 1)  && pup.IsShe() )
            {
                GirlsPrizeWinner.add(pup);
            }
        }
        for(Pupil pup : GirlsPrizeWinner)
        {
            System.out.println(pup.getName() + " " + pup.getSex() + " " + pup.getAge());
            pup.infoContest();
        }
    }

    public static void main(String[] args)
    {
        HashMap <String, Integer> marksP1 = new HashMap <String, Integer>();
        HashMap <String, Integer> marksP2 = new HashMap <String, Integer>();
        HashMap <String, Integer> marksP3 = new HashMap <String, Integer>();
        Pupil pupil1 = new Pupil("Ваня", "М", 15,marksP1);
        Pupil pupil2 = new Pupil("Егор", "М", 12,marksP2);
        Pupil pupil3 = new Pupil("Лада", "Ж", 17,marksP3);
        ArrayList<Pupil> pupils = new ArrayList<Pupil>();
        pupils.add(pupil1);pupils.add(pupil2);
        pupils.add(pupil3);

        ArrayList<Integer> marksS1 = new ArrayList<Integer>();
        ArrayList<Integer> marksS2 = new ArrayList<Integer>();
        ArrayList<Integer> marksS3 = new ArrayList<Integer>();
        Student student1 = new Student("Кирилл","М",21,marksS1);
        Student student2 = new Student("Василиса","Ж",20,marksS2);
        Student student3 = new Student("Арина","Ж",21,marksS3);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1); students.add(student2);
        students.add(student3);

        enterInfo(pupils,students);
        hihgGrantAll(pupils,students);
        StudentCourseWorks(students);
        girlsOnContests(pupils);
    }
}