package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Classroom {
    Student[] students;

    public Classroom(int size){
        students= new Student[size];
    }

    public Classroom(Student[] wholeClass){
        students=wholeClass;
    }

    public Classroom(){
        students= new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }


    public double getAverageExamScore(Student[] students) {
        double total=0.0;
                for(Student i:students){
                    total+=i.getAverageExamScore();
                }
                return total/students.length;
    }

    public void addStudent(Student newKid) {
        for (int i=0;i<students.length;i++){
            if (students[i]==null){
            students[i]=newKid;
        }}
    }



    public void removeStudent(String firstName, String lastName) {
        for (int i=0;i<students.length;i++){
            if(students[i]!=null && firstName.equals(students[i].getFirstName()) && lastName.equals(students[i].getLastName())){
                students[i]=null;
            }
        }
        sortNullLast();
    }
    public void sortNullLast(){
        for (int i =0;i< students.length;i++){
            if(students[i]==null){
                int j=i+1;
                while(j<students.length){
                    if(students[j]!=null){
                        students[i]=students[j];
                        students[j]=null;
                    }
                    j++;
                }
            }
        }
    }


    public void getStudentsByScore() {
        sortNullLast();
        Student temp;
        for (int i =0;i< students.length;i++){
            if(students[i]!=null){
                int j=i+1;
                while(j<students.length){
                    if(students[i].getAverageExamScore()<students[j].getAverageExamScore()){
                        temp=students[i];
                        students[i]=students[j];
                        students[j]=temp;
                    }
                    j++;
                }
            }
        }
    }
    public Integer numStudents(){
        int studentNum=students.length;
        for (int i=0;i<students.length;i++){
            if (students[i]==null){studentNum--;}
        }
        return studentNum;
    }

    public HashMap<Student, String> getGradeBook(){
        getStudentsByScore();
        int studentNum=numStudents();
        double rank=studentNum;
        double percentile;
        HashMap<Student,String> GPA = new HashMap<Student, String>();
        for (int i =0; i<studentNum; i++){
            percentile=(rank*100)/studentNum;
            if(percentile<11.0){GPA.put(students[i],"F");}
            if(percentile>=11.0&&percentile<30.0){GPA.put(students[i],"D");}
            if(percentile>=30.0&&percentile<51.0){GPA.put(students[i],"C");}
            if(percentile>=51.0&&percentile<90.0){GPA.put(students[i],"B");}
            if(percentile>=90.0){GPA.put(students[i],"A");}
            rank--;
        }
        return GPA;
    }
}
