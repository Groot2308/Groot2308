/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg101;

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

    int getChocie(int min, int max) {
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

    public String inputID(String s, ArrayList<Employees> list) {
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
                if (input.matches("\\W+") || !input.matches("\\D+")) {
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
    
        public String inputSex(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim().toLowerCase(); 
                if (input.isEmpty()) {
                    System.out.println("Not empty! Input again"); 
                    continue;
                }
                if (!input.equalsIgnoreCase("male") && !input.equalsIgnoreCase("female")) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("ERROR!Please input male or female");
            }
        } while (true);
        return input;
    }

    public String inputPhone(String s) {
        String phoneNumber;
        do {
            System.out.print(s);
            try {
                phoneNumber = sc.nextLine().trim();
                if (phoneNumber.isEmpty()) {
                    System.out.println("Phone not empty! Input again");
                    continue;
                }
                if (!phoneNumber.matches("[0-9]{10}")) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error Format! Phone number must be 10 digits");
            }
        } while (true);
        return phoneNumber;
    }

    public String inputEmail(String s) {
        String input;
        String formatEmail = "[A-Za-z0-9]+[@][a-z]+[.]+[a-z]{2,4}";
        do {
            try {
                System.out.print(s);
                input = sc.nextLine();
                //check input not empty
                if (input.isEmpty()) {
                    System.out.println("Email not empty!!");
                    continue;
                    //check format email
                }
                if (!input.matches(formatEmail)) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Email must is correct format");
            }
        } while (true);
        return input;
    }

    public String inputDate(String date) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String input;
        do {
            System.out.print(date);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Date not empty");
                continue;
            }
            try {
                if (!input.matches("[0-3]{1}+[0-9]{1}+[/]+[0-3]{1}+[0-9]{1}+/+[0-9]{4}")) {
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

}
