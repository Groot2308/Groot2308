/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0050;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Menu menu = new Menu(); 
       getInput input = new getInput(); 
       Manager m = new Manager(); 
       do{
           menu.creatMenu(); 
           int choice = input.getChoice(1, 3); 
           switch(choice){
               case 1:
                   m.calculateEquation(); 
                   break; 
               case 2:
                   m.calculateQuadraticEquation(); 
                   break; 
               case 3:
                   System.exit(0);
                   break; 
           }       
       }while(true); 
       
    }
    
}
