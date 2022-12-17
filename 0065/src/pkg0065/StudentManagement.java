/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author asus
 */
class StudentManagement {

    public static Scanner sc = new Scanner(System.in); 
    public static getInput input = new getInput();

    void creatStudent(ArrayList<Student> list) {
        System.out.println("====== Management Student Program ======");
        while (true) {
            String studentName = getInput.InputName("Name:");
            String className = getInput.InputClasses("Classes:");
            double math = getInput.InputIsDouble("Maths:");
            double chemistry = getInput.InputIsDouble("Chemistry:");
            double physics = getInput.InputIsDouble("Physics:");
            double avg = averageStudent(math, chemistry, physics);
            char type;
            if (avg > 7.5) {
                type = 'A';
            } else if (avg >= 6 && avg <= 7.5) {
                type = 'B';
            } else if (avg >= 4 && avg < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            list.add(new Student(studentName, className, math, chemistry, physics, avg, type));
            if (!input.checkYN("Do you want to enter more student information?(Y/N):")) {
                return;
            }
        }
    }

    double averageStudent(double x, double y, double z) {
        double avg = (x + y + z) / 3;
        return avg;
    }

    public HashMap<String, Double> getPercentTypeStudent(ArrayList<Student> list) {
        HashMap<String, Double> map = new HashMap<>();
        int countTypeA = 0;
        int countTypeB = 0;
        int countTypeC = 0;
        int countTypeD = 0;
        //loop use access from the first element to the last element in array list
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i).getType()) {
                case 'A':
                    countTypeA++;
                    break;
                case 'B':
                    countTypeB++;
                    break;
                case 'C':
                    countTypeC++;
                    break;
                case 'D':
                    countTypeD++;
                    break;
            }
        }
        map.put("A", (100.0 * countTypeA) / list.size());
        map.put("B", (100.0 * countTypeB) / list.size());
        map.put("C", (100.0 * countTypeC) / list.size());
        map.put("D", (100.0 * countTypeD) / list.size());
        return map;
    }

    void displayStudent(ArrayList<Student> list) {
        int count = 0, i;
        //loop use access from the first element to the last element in array list
        for (i = 0; i<list.size(); i++) {
            System.out.println("------ Student " + ++count + " Info ------");
            System.out.println("Name:" + list.get(i).getStudentName());
            System.out.println("Classes:" + list.get(i).getClassName());
            System.out.printf("AVG: %.1f\n", list.get(i).getAvg());
            System.out.println("Type:" + list.get(i).getType());
        }
    }

    public void displayClass(ArrayList<Student> list) {
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(list);
        System.out.println("--------Classification Info -----"); 
        //loop use access each element in hashmap 
        for (Map.Entry<String, Double> student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + ": " + student.getValue() + "%");
        }
    }
}
