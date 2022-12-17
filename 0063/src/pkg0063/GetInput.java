/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0063;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class GetInput {
    
    public static Scanner sc = new Scanner(System.in); 
   
    public String inputIsString(String s){
        String input; 
        do{
            try{
                System.out.print(s);
                input = sc.nextLine(); 
                if(input.isEmpty()){
                    System.out.println("Not empty! Input again");
                    continue;
                }
                if(input.matches("\\W+")){
                    throw new Exception(); 
                }else{
                    break; 
                }
            }catch(Exception exception){ 
                System.out.println("Error!! Input again");
            }
        }while(true); 
        return input; 
    }
    
    public double inputIsDouble(String s){
        String input; 
        double number; 
        do{
            System.out.print(s);
            input = sc.nextLine().trim(); 
            if(input.isEmpty()){
                System.out.println("Not empty! Input again");
                continue;
            }
            try{
                number = Double.parseDouble(input); 
                if(number < 0){
                    throw new Exception(); 
                }else{
                    break; 
                }
            }catch(NumberFormatException exception){
                System.out.println("You must input digidt.");
            } catch(Exception e){
                System.out.println("Salary is greater than zero");
            }          
        }while(true);
        return number; 
    }
}
