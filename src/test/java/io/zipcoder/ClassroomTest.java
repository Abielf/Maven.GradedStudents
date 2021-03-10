package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void getStudentsTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] expected = {s1,s2};
        Classroom classroom = new Classroom(expected);
        Student[] actual= classroom.getStudents();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void totalAverageTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;
        double actual = classroom.getAverageExamScore(students);
        Assert.assertEquals(expected,actual, .0001);
    }

    @Test
    public void newKidInClassTest(){
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student newKid = new Student("Leon", "Hunter", examScores);


        classroom.addStudent(newKid);
        Student[] actual = classroom.getStudents();
        Student[]expected={newKid};
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void loseAKidTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double[] s3Scores = { 100.0, 150.0 };
        Double[] s4Scores = { 225.0, 25.0 };
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("Rocky","Balboa",s3Scores);
        Student s4 = new Student("Cloud","Strife",s4Scores);
        Student[] rollCall = {s1,s2,s3,s4};
        Classroom classroom = new Classroom(rollCall);
        Student[] expected = {s1,s2,s4,null};
        classroom.removeStudent("Rocky","Balboa");
        Student[] actual= classroom.getStudents();
        Assert.assertEquals(expected,actual);
    }

    @Test

    public void getStudentsByScoreTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 100.0 };
        Double[] s3Scores = { 220.0, 150.0 };
        Double[] s4Scores = { 50.0, 25.0 };
        Double[] s5Scores = {225.0, 150.0};
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("Rocky","Balboa",s3Scores);
        Student s4 = new Student("Cloud","Strife",s4Scores);
        Student s5 = new Student("Dexter","BoyGenius",s5Scores);
        Student[] rollCall = {s1,s2,s3,s4,s5};
        Classroom classroom = new Classroom(rollCall);
        Student[] expected = {s5,s3,s2,s1,s4};
        classroom.getStudentsByScore();
        Student[] actual= classroom.getStudents();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getGradeBookTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 100.0 };
        Double[] s3Scores = { 220.0, 150.0 };
        Double[] s4Scores = { 50.0, 25.0 };
        Double[] s5Scores = {225.0, 150.0};
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("Rocky","Balboa",s3Scores);
        Student s4 = new Student("Cloud","Strife",s4Scores);
        Student s5 = new Student("Dexter","BoyGenius",s5Scores);
        Student[] rollCall = {s1,s2,s3,s4,s5};
        Classroom classroom = new Classroom(rollCall);
        System.out.print(classroom.getGradeBook());

    }
}


