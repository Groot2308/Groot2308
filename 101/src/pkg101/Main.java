/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg101;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employees> list = new ArrayList<>();
        Menu menu = new Menu();
        GetInput input = new GetInput();
        EmployeesManager e = new EmployeesManager();
        int choice;
        do {
            //Step 1: Creat display menu
            menu.CreatMenu();
            //Step 2: Input selected choice
            choice = input.getChocie(1, 6);
            //Step 3: Execute selected choice
            switch (choice) {
                case 1:
                    //Add employees 
                    e.addEmployees(list);
                    break;
                case 2:
                    //Update employees
                    e.updateEmployees(list);
                    break;
                case 3:
                    //Remove employees
                    e.removeEmployees(list);
                    break;
                case 4:
                    //Search employees
                    e.searchEmployees(list);
                    break;
                case 5:
                    //Sort employees by salary
                    e.sortEmployeesBySalary(list);
                    break;
                case 6:
                    //Exit the program
                    System.exit(0);
                    break;
            }
        } while (true);

    }

}
