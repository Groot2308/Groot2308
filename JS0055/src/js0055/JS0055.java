/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0055;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList; 
/**
 *
 * @author asus
 */
public class JS0055 {
    public static void main(String[] args) throws IOException {
        ArrayList<Doctor> list = new ArrayList<Doctor>();  
        Menu menu = new Menu(); 
        getInput g = new getInput(); 
        DoctorHash d = new  DoctorHash(); 
        int choice; 
        do{
            //Step 1: Create display menu
            menu.creatMenu(); 
            //Step 2: input selected option
            choice = g.getChoice(1, 5);
            //Step 3: Execute selected option
            switch(choice){
                //add doctor
                case 1: 
                    d.addDoctor(list); 
 //                   d.writeToFile(list);
                    break;
                //update doctor
                case 2:
                    d.updateDoctor(list); 
                    d.loadToFile(list);
                    break; 
                //delete doctor
                case 3:
                    d.deleteDoctor(list);
  //                  d.loadToFile(list);
                    break;
                //search doctor
                case 4:
                    d.searchDoctor(list);
  //                 d.loadToFile(list);
                    break; 
                //exit the program 
                case 5:
                    System.exit(0);
                    break; 
            }         
        }while(true); 
        
    }
    
}
