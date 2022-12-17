
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0065;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>(); 
        StudentManagement sm = new StudentManagement(); 
        //Step 1: Creat student
        sm.creatStudent(list); 
        //Step 2: get percent type student
        sm.getPercentTypeStudent(list); 
        //Step 3: show display student
        sm.displayStudent(list); 
        //Step 4: show display class
        sm.displayClass(list); 
    }
    
}
