/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg009;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
class Manage {

    static void Fibonacci(ArrayList<Integer> list, int count, boolean test) {
        //check value of count
        if (count <= 1) {
            list.add(count);
            //check value of test 
            if (test == true) {
                System.out.println("The number no " + (count + 1) + " of fibonacci sequence = " + list.get(count));
            }
        } else {
            int i = (int) list.get(count - 1) + (int) list.get(count - 2);
            list.add(i);
            //check value of test
            if (test == true) {
                //check value of array's element at position count
                if ((int) list.get(count) == (int) list.get(count - 1) + (int) list.get(count - 2)) {
                    System.out.println("The number no " + (count + 1) + " of fibonacci sequence = " + list.get(count - 1) + " + " + list.get(count - 2) + " = " + list.get(count));
                }
            }
        }
        //check value of count
        if (count < 44) {
            count++;
            Fibonacci(list, count, test);
        }
    }

    static void displayFibonacci(ArrayList<Integer> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The 45 sequence fibonacci:");
        //loop use to access all element of list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            //check value of i
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
