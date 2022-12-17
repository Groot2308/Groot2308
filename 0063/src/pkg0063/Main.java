/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0063;

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
        ArrayList<Person> list = new ArrayList<>(); 
        GetInput input = new GetInput(); 
        PersonManager p = new PersonManager(); 
       //Step 1: input information person
       p.inputPersonInfo(list);
       //Step 2: sort person by salary ascending
       p.sortASCBySalary(list); 
       //Step 3; display all information person
       p.displayPersonInfo(list); 
       
    }
    
}
