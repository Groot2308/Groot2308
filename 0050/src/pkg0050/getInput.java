/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0050;

import java.util.Scanner;

/**
 *
 * @author asus
 */
class getInput {
 
    public static Scanner sc = new Scanner(System.in); 
    int getChoice(int min, int max) {
        String input;
        double choice;
        do {
            System.out.println("Your choice:");
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
    
    public double getDouble(String s){
        String input; 
        double number; 
        do{
            System.out.print(s);
            input = sc.nextLine(); 
            if(input.isEmpty()){
                System.out.println("Not empty! Input again");
                continue;
            }
            try{
                number = Double.parseDouble(input); 
                break;
            }catch(NumberFormatException e){
                System.out.println("Please input number");
            }catch (Exception e){
                System.out.println("Error! Input again");
            }
        }while(true); 
        return number; 
    }
    
        public double getDouble1(String s){
        String input; 
        double number; 
        do{
            System.out.print(s);
            input = sc.nextLine(); 
            if(input.isEmpty()){
                System.out.println("Not empty! Input again");
                continue;
            }
            try{
                number = Double.parseDouble(input); 
                if(number == 0){
                    throw new Exception(); 
                }else {
                    break; 
                }
            }catch(NumberFormatException e){
                System.out.println("Please input number");
            }catch (Exception e){
                System.out.println("Input not equal 0! Input again");
            }
        }while(true); 
        return number; 
    }
}

