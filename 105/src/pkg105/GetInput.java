/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
class GetInput {

    public static Scanner sc = new Scanner(System.in);

    int getChoice(int min, int max) {
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

    public String inputID(String s, ArrayList<Products> list) {
        String inputID;
        do {
            System.out.print(s);
            try {
                inputID = sc.nextLine().trim();
                if (inputID.isEmpty()) {
                    System.out.println("Not empty! Input again");
                    continue;
                }
                if (inputID.matches("\\W+")) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (Error error) {
                System.out.println("ERROR! Input again");
            }
        } while (true);
        return inputID;
    }

    public String inputString(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim().toLowerCase();
                if (input.isEmpty()) {
                    System.out.println("Not empty! Input again");
                    continue;
                }
                if (input.matches("\\W+") || input.matches("[0-9]+")) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (Error error) {
                System.out.println("ERROR! Input again");
            }
        } while (true);
        return input;
    }
    
    public double inputDouble(String s) {
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
                number = Double.parseDouble(input);
                if (number <= 0) {
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
    
        public String inputDate(String s, ArrayList<Products> list) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String input;
        do {
            System.out.print(s);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Date not empty");
                continue;
                
            }
            try {
                if (!input.matches("[0-3]{1}+[0-9]{1}+[/]+[0-3]{1}+[0-9]{1}+[/]+[0-9]{4}")) {
                    System.out.println("Date to correct format(dd/MM/yyyy)");
                    continue;
                }
                //setLenient to check date not exist or exist
                sd.setLenient(false);
                sd.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println("Date does not exist!!");
            }
        } while (true);
        return input;
    }

}
