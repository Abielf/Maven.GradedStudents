package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    String firstName;
    String lastName;
    List<Double> examScores=new ArrayList<Double>();

    public Student(String firstN, String lastN, Double[] scores){
        firstName=firstN;
        lastName=lastN;
        for(Double i:scores){
            examScores.add(i);
        }
    }
    //Constructor for new student since they wouldn't yet have scores.
    public Student(String firstN, String lastN){
        firstName=firstN;
        lastName=lastN;
    }

    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String newLast){
        lastName=newLast;
    }

    public void setFirstName(String newFirst){
        firstName=newFirst;
    }
    public List<Double> getScores(){
        return examScores;
    }

    public int numberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String temp="";
        for(int i=0;i<examScores.size();i++){
            temp=temp.concat("Exam "+(i+1)+" -> "+examScores.get(i)+"\n");
        }
        return temp;
    }

    public void addExam(double newExam) {
        examScores.add(newExam);
    }

    public void setExamScore(int i, double v) {
        if(examScores.size()>0) {
            examScores.set(i, v);
        }
    }

    public Double getAverageExamScore() {
        Double average=0.0;
        Double total=0.0;
        for (Double i:examScores){
            total+=i;
        }
        return total/examScores.size();
    }

    public String toString(){
        String temp="Student Name: ";
        temp=temp.concat(firstName+" "+lastName+"\nAverage Score: "+getAverageExamScore()+"\nExam Scores:\n");
        temp=temp.concat(getExamScores());
        return temp;
    }
}
