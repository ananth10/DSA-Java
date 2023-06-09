package com.example.myapplication.codingminutes.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class VectorSort {


    public static void main(String[] args) {
        ArrayList<Students> students_marks = new ArrayList<>(Arrays.asList(new Students("ananth", new int[]{10, 20, 11}), new Students("Prateek", new int[]{10, 21, 3}),
                new Students("Vivek", new int[]{4, 5, 6}),
                new Students("Rijul", new int[]{10, 13, 20})));

        Collections.sort(students_marks);

        for(Students s:students_marks){
            System.out.println(s.first+" "+ calculateMarks(s.second));
        }
    }

    static class Students implements Comparable<Students> {
        String first;
        int[] second;

        Students(String name, int[] marks) {
            first = name;
            second = marks;
        }

        @Override
        public int compareTo(Students o) {

            return calculateMarks(o.second) - calculateMarks(this.second);
        }
    }

    static int calculateMarks(int[] marks) {
        return marks[0] + marks[1] + marks[2];
    }
}
