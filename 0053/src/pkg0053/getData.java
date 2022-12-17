/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0053;

import java.util.Scanner;

/**
 *
 * @author asus
 */
class getData {

    public static Scanner sc = new Scanner(System.in);

    public int getChoice(int min, int max) {
        String input;
        double choice;
        do {
            System.out.println("Please choice one option:");
            input = sc.nextLine().trim();
            //Check input not empty
            if (input.isEmpty()) {
                System.out.println("Not empty! Please choice from " + min + " to " + max);
                continue;
            }
            try {
                choice = Double.parseDouble(input);
                //check input not real number
                if ((int) choice != choice) {
                    throw new Exception();
                }
                //check input from min to max
                if (choice < min || choice > max) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Please choice from " + min + " to " + max);
            } catch (Error number) {
                System.out.println("Please choice from " + min + " to " + max);
            } catch (Exception realnumber) {
                System.out.println("Not real number! Please choice from " + min + " to " + max);
            }
        } while (true);
        return (int) choice;
    }

    public static int InputSizeArray() {
        Scanner sc = new Scanner(System.in);
        String input;
        double sizeArray;
        System.out.println("----- Input Element -----");
        System.out.println("Input Length of Array");
        do {
            System.out.print("Enter Number: ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Not Empty!Please input numberand number is greater than zero");
                continue;
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
                System.out.println("Please input numberand number is greater than zero");
            } catch (Error intNumber) {
                System.out.println("Please input numberand number is greater than zero");
            } catch (Exception realNumber) {
                System.out.println("Not real number! Input Positive integer Number");
            }
        } while (true);
        return (int) sizeArray;
    }

    int checkInput() {
        String input; 
        int number, i  = 0;
        do {
            input = sc.nextLine().trim(); 
            if(input.isEmpty()){
                System.out.println("Not empty! input again");
                System.out.print("Enter again: ");
                continue;
            }
            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input again");
                System.out.println("Enter again: ");
            } catch (Exception e){
                System.out.println("Error! Input again");
                System.out.println("Enter again: ");
            }
        } while (true);
        return number;
    }

    int[] inputElement() {
        int size = InputSizeArray();
        int[] arr = new int[size];
        for(int i= 0; i<size; i++){
            System.out.print("Enter number "+ (i+1) +": ");
            arr[i] = checkInput(); 
        }
        return arr; 
    }
}
