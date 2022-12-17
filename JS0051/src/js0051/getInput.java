/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0051;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class getInput {

    public static Scanner sc = new Scanner(System.in);
    Menu m = new Menu();

    public int getChoice(int min, int max) {
        String input;
        double choice;
        do {
            System.out.println("Please choice one option:");
            try {
                input = sc.nextLine();
                if (input.isEmpty()) {
                    throw new NullPointerException();
                }
                choice = Double.parseDouble(input);
                if ((int) choice != choice) {
                    throw new Error();
                }
                if (choice < min || choice > max) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("Not empty! Please choice from "+min+ " to " +max);
            } catch (NumberFormatException e) {
                System.out.println("Not String! Please choice from "+min+ " to "+ max);
            } catch (Error realnumber) {
                System.out.println("Not real number! Please choice from "+min+ " to "+ max);
            } catch (Exception exception) {
                System.out.println( "Please choice from "+min+ " to "+ max);
            }
        } while (true);
        return (int) choice;
    }

    public double getNumber(String s) {
        String input;
        double number;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine();
                if (input.isEmpty()) {
                    throw new NullPointerException();
                }
                number = Double.parseDouble(input.trim());
                break;
                
            }catch(NullPointerException e){
                System.out.println("Not empty! Input number again");
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input number again");
            }
        } while (true);
        return number;
    }

    public double getNumber1(String s) {
        String input; 
        double number = 0;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine(); 
                if(input.isEmpty()){
                    throw new NullPointerException(); 
                }
                number = Double.parseDouble(input.trim());
                if (number == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            }catch(NullPointerException exception){
                System.out.println("Not empty! Input number again");
            }catch(NumberFormatException e){
                System.out.println("Not String! Input number again");
            } catch (Exception e) {
                System.out.println("Math error, number not 0! Input number again!!!");
            }
        } while (true);
        return number;
    }

    public String getOperator(String s) {
        String input;
        do {
            System.out.print(s);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Operator is not empty");
                continue;
            }
            try {
                if (input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-")
                        || input.equalsIgnoreCase("*") || input.equalsIgnoreCase("/")
                        || input.equalsIgnoreCase("^") || input.equalsIgnoreCase("=")) {
                } else {
                    throw new Error();
                }
                break; 
            } catch (Error e) {
                System.out.println("Please input (+ , -, *, /, ^)");
            }
        } while (true);
        return input;
    }

    public double getBMI(String s) {
        String input; 
        double number;
        do {
            System.out.print(s);
            input = sc.nextLine().trim(); 
            if(input.isEmpty()){
                System.out.println("Not empty! BMI is digit");
                continue;
            }
            try {
                number = Double.parseDouble(input);
                if (number <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            } catch (Exception exception){
                System.out.println("Not less than 0! BMI is digit");
            }
        } while (true);
        return number;
    }

}
