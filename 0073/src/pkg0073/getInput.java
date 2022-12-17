/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
class getInput {

    public static Scanner sc = new Scanner(System.in);

    public int getChocie(int min, int max) {
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

    public String getDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String input;
        do {
            System.out.print(date);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Date not empty");
                continue;
            }
            try {
                if (!input.matches("[0-3]{1}+[0-9]{1}+[-]+[A-Za-z]{3}+[-]+[0-9]{4}")) {
                    System.out.println("Date to correct format(dd-MMM-yyyy)");
                    continue;
                }
                //setLenient to check date not exist or exist
                dateFormat.setLenient(false);
                dateFormat.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println("Date does not exist!!");
            }
        } while (true);
        return input;
    }

    public String getString(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim();
                //check input not empty
                if (input.isEmpty()) {
                    System.out.println("Not empty! Input again!");
                    continue;
                }
                //check regex not number and characters
                if (!input.matches("\\D+") || input.matches("\\W+")) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input again!");
            }
        } while (true);
        return input;
    }

    public double getDouble(String s) {
        String input;
        double number;
        do {
            System.out.print(s);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Not empty! Input again");
                continue;
            }
            try {
                number = Double.parseDouble(input.trim());
                if (number < 0) {
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
        return number;
    }
    
        int inputID(String s) {
        String input;
        double id;
        do {
            System.out.print(s);
            input = sc.nextLine().trim();
            //check input not empty
            if (input.isEmpty()) {
                System.out.println("Not empty! ID is digt");
                continue;
            }
            try {
                id = Double.parseDouble(input);
                //check input not less than 0
                if (id <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception realnumber) {
                System.out.println("ID is digit");
            }
        } while (true);
        return (int) id;
    }
}
