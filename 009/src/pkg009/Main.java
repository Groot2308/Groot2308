/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg009;

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
        ArrayList<Integer> list = new ArrayList<>(); 
        //Step 1: Find 45 sequence Fibonacci
        Manage.Fibonacci(list,0, true); 
        //Step 2: Display 45 sequence Fibonacci 
        Manage.displayFibonacci(list); 
    }
    
}
