/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0053;

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
       getData input = new getData(); 
       bubbleSort sort = new bubbleSort(); 
       int choice; 
       int[] arr = new int[0]; 
       do{
           menu.creatMenu(); 
           choice = input.getChoice(1, 3); 
           switch(choice){
               case 1: 
                   arr = input.inputElement(); 
                   break; 
               case 2:
                   sort.bubbleSort(choice, arr); 
                   break; 
               case 3:
                   sort.bubbleSort(choice, arr); 
                   break; 
               case 4:
                   System.exit(0);
                   break; 
           }        
       }while(true); 
    }
}
