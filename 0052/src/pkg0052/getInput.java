/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0052;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class getInput {

    public static Scanner sc = new Scanner(System.in);

    public int getChoice(int min, int max) {
        String input;
        double choice;
        do {
            System.out.println("Your choice:");
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Not empty! Please choice from " + min + " to " + max);
                continue;
            }
            try {
                choice = Double.parseDouble(input);          
                if ((int) choice != choice) {
                    throw new Exception();
                }
                if (choice < min || choice > max) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! " + "Please choice from " + min + " to " + max);
            } catch (Error number) {
                System.out.println("Please choice from " + min + " to " + max);
            } catch (Exception realnumber) {
                System.out.println("Not real number! " + "Please choice from " + min + " to " + max);
            }
        } while (true);
        return (int) choice;
    }
     
    public static String InputIsString(String s) {
        String input; 
        do {
            System.out.println(s);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new NullPointerException();
                }
                if (input.matches("\\W+") || !input.matches("\\D+")) {
                    throw new Error();                 
                } else {
                    break;
                }
            } catch (NullPointerException exception) {
                System.out.println("Not empty! Input again");
            } catch (Error e) {
                System.out.println("ERROR! Input again");
            } 
        } while (true);
        return input;
    }

    public static double InputIsDouble(String s) {
        String input;
        double result;
        do {
            System.out.println(s);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Not empty! Input again");
                continue;
            }
            try {
                result = Double.parseDouble(input.trim());
                if (result <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input again");
            } catch (Exception e) {
                System.out.println("Not less than 0! Input again");
            }
        } while (true);
        return result;
    }
}
