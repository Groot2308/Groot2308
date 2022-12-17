/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0011;

import java.util.Scanner;

/**
 *
 * @author asus
 */
class GetInput {

    public static Scanner sc = new Scanner(System.in);

    public int getChoice(int min, int max) {
        String input;
        double choice;
        do {
            System.out.println("Enter your choice:");
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

    public String getInputBinary(String s) {
        String binaryNumber;
        do {
            try {
                System.out.println(s);
                binaryNumber = sc.nextLine().trim();
                if (binaryNumber.isEmpty()) {
                    System.out.println("Not empty! Input again");
                    continue;
                }
                //check format binary number
                if (!binaryNumber.matches("[0-1]+")) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Input is digit");
            } catch (Error e) {
                System.out.println("Input must number 0 or 1");
            }
        } while (true);
        return binaryNumber;
    }

    public String getInputDec(String s) {
        String decNumber;
        do {
            try {
                System.out.println(s);
                decNumber = sc.nextLine().trim();
                //check input not empty
                if (decNumber.isEmpty()) {
                    System.out.println("Not empty! Input again");
                    continue;
                }
                //check format input number
                if (!decNumber.matches("[0-9]+")) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (Error e) {
                System.out.println("error! Input must from 0 to 9");
            }
        } while (true);
        return decNumber;
    }

    public String getInputHexadecimal(String s) {
        String input;
        do {
            System.out.println(s);
            try {
                input = sc.nextLine().trim();
                //check input is empty
                if (input.isEmpty()) {
                    System.out.println("Not empty! Input again");
                    continue;
                }
                //check formau input number
                if (!input.matches("[0-9A-F]+")) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (Error e) {
                System.out.println("Error format! Input must from 0 to 9 and A to F");
            }
        } while (true);
        return input;
    }
}
