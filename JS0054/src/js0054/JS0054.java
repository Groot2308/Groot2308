/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0054;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class JS0054 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu m = new Menu();
        GetData g = new GetData();
        ArrayList<Contact> list = new ArrayList<>();
        ContactManagement contactManagement = new ContactManagement();
        list.add(new Contact(1, "Iker Casillas", "Iker", "Casillas", "Star", "Spain", "1234567890"));
        list.add(new Contact(2, "John Terry", "John", "Terry", "Star", "England", "1234567890"));
        list.add(new Contact(3, "Raul Gonzalez", "Raul", "Gonzalez", "Star", "Spain", "1234567890"));
        do {
            //Step 1: Display menu
            m.creatMenu();
            //Step 2: Input select an option
            int choice = g.getChoice(1, 4);
            //Execute selected option
            switch (choice) {
                //Execute add contact
                case 1:
                    contactManagement.addContact(list);
                    break;
                //Excute Display all contacts
                case 2:
                    contactManagement.displayContact(list);
                    break;
                //Excute delete a contact    
                case 3:
                    contactManagement.deleteContact(list);
                    break;
                //Exit program
                case 4:
                    System.out.println("Exit Program!!!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
