/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0065;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class getInput {

    public static Scanner sc = new Scanner(System.in);

    public static String InputName(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new NullPointerException();
                }
                // \\W+: not letters and numbers
                if (input.matches("\\W+")) {
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
    
        public static String InputClasses(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new NullPointerException();
                }
                if (input.matches("\\W+")) {
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
            System.out.print(s);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(s.replace(":","")+" is digit");
                continue;
            }
            try {
                result = Double.parseDouble(input.trim());
                if (result < 0) {
                    throw new Exception();
                }
                if (result > 10) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input is digit");
            } catch (Exception e) {
                System.out.println(s.replace(":","") + " is greater than equal 0");
            } catch (Error error) {
                System.out.println(s.replace(":","") + " is less than equal 10");
            }
        } while (true);
        return result;
    }

    public boolean checkYN(String s) {
        while (true) {
            System.out.print(s);
            String input = sc.nextLine().trim();
            //check length input
            if (input.length() == 1) {
                if (input.equalsIgnoreCase("Y")) {
                    return true;
                } else if (input.equalsIgnoreCase("N")) {
                    return false;
                }
            }
            System.out.println("input again!!!");
        }
    }
}
