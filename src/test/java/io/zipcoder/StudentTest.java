package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {



    Double[] exams = {98.7, 32.4, 21.9};
    Student tester = new Student("Max", "Power", exams);
    Student moron= new Student("Wheatley", "Yao");

    @Test
    public void getLTest(){
        String expected="Power";
        String actual=tester.getLastName();
    }

    @Test
    public void getFTest(){
        String expected="Max";
        String actual =tester.getFirstName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setLtest(){
        String expected="Skywalker";
        tester.setLastName("Skywalker");
        String actual=tester.getLastName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFtest(){
        String expected="Anakin";
        tester.setFirstName("Anakin");
        String actual=tester.getFirstName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void numberOfExamsTakenTest(){
        int expected=exams.length;
        int actual=tester.numberOfExamsTaken();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getExamScoresTest(){
        String actual=tester.getExamScores();
        String expected= "Exam 1 -> 98.7\nExam 2 -> 32.4\nExam 3 -> 21.9\n";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addExamTest(){
        tester.addExam(87.4);
        String actual=tester.getExamScores();
        String expected= "Exam 1 -> 98.7\nExam 2 -> 32.4\nExam 3 -> 21.9\nExam 4 -> 87.4\n";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addExamTest2(){
            moron.addExam(41.3);
            moron.addExam(54.6);
            String actual=moron.getExamScores();
            String expected= "Exam 1 -> 41.3\nExam 2 -> 54.6\n";
            Assert.assertEquals(expected,actual);
    }

    @Test
    public void setExamTest(){
        tester.setExamScore(1, 99.9);
        String actual=tester.getExamScores();
        String expected= "Exam 1 -> 98.7\nExam 2 -> 99.9\nExam 3 -> 21.9\n";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void averageTest(){
        Double actual=tester.getAverageExamScore();
        Double expected=51.0;
        Assert.assertEquals(expected,actual,.0001);
    }

    @Test
    public void testToString(){
        String actual= tester.toString();
        System.out.print(actual);
    }


}