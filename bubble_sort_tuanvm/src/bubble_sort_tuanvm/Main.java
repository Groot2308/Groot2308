/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble_sort_tuanvm;

import java.util.Random;
import java.util.Scanner;
import jdk.nashorn.internal.ir.ContinueNode;

public class Main {

    public static void main(String[] args) {
        //Step 1: Input Positive Number
        int sizeArray = InputNumberArray("Input Number of Array: ");
        //Step 2: Creat Array
//        int[] array = {5, 1, 12, -5, 16};
//        boolean check = true;
        int[] array = creatArray(sizeArray);
        boolean check = false;
        //Step 3: Display unsorted array
        DisplayArray(array, "Unsorted Array: ");
        
        //Step 4: sort by BubbleSort
        BubbleSort(array, check);
        //Step 5; Display sorted array
        DisplayArray(array, "\nSorted Array: ");
    }

    public static int InputNumberArray(String a) {
        Scanner sc = new Scanner(System.in);
        String input;
        double sizeArray;
        do {
            System.out.println(a);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Not Empty! Input Positive Number");
            }
            try {
                sizeArray = Double.parseDouble(input);
                // check input not less than 0
                if (sizeArray <= 0) {
                    throw new Error();
                }
                // check input not real number
                if ((int) sizeArray != sizeArray) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input Positive integer Number");
            } catch (Error intNumber) {
                System.out.println("Not less than 0! Input Positive integer Number");
            } catch (Exception realNumber) {
                System.out.println("Not real number! Input Positive integer Number");
            }
        } while (true);
        return (int) sizeArray;
    }

    public static int[] creatArray(int sizeArray) {
        int[] array = new int[sizeArray];
        Random ra = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = ra.nextInt(sizeArray);
        }
        return array;
    }

    public static void DisplayArray(int[] array, String a) {
        System.out.print(a);
        System.out.print("[");
        //Use loop to display, from the first section of the end of array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //show commas between elements in array
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void BubbleSort(int[] array, boolean check) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    //show sorting steps
                    if (check == true) {
                        System.out.println("");
                        DisplayArray(array, "");
                        System.out.println(" " + array[j] + " > " + array[j + 1] + ", swap");
                    }
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (check == true) {
                    DisplayArray(array, "");
                    System.out.println(" " + array[j] + " < " + array[j + 1] + ", ok");
                }
            }
        }
    }

}
