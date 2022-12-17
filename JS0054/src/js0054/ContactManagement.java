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
class ContactManagement {

    public void addContact(ArrayList<Contact> list) {
        GetData gd = new GetData();
        System.out.println("-------- Add a Contact --------");
        
        int ID = list.size() + 1;
        String fullName = gd.getName("Enter Name: ");
        String group = gd.inputIsString("Enter Group: ");
        String address = gd.inputIsString("Enter Address: ");
        String phone = gd.inputPhone("Enter Phone: ");
        String[] s = fullName.split(" ");
        String firstName = s[0].trim();
        String lastName = s[1].trim();
        list.add(new Contact(ID, fullName, firstName, lastName, group, address, phone));
        System.out.println("Successful");
    }

    public void displayContact(ArrayList<Contact> list) {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        //check empty arraylist
        if (list.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            System.out.printf("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n", "ID", "Name", "First name", "Last name", "Group", "Address", "Phone");
            /*loop use access from the first element to last element in array list*/
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%-5d%-15s%-15s%-15s%-10s%-10s%-10s\n",
                        list.get(i).getID(), list.get(i).getFullName(),
                        list.get(i).getFirstName(), list.get(i).getLastName(),
                        list.get(i).getGroup(), list.get(i).getAddress(), list.get(i).getPhone());
            }
        }
    }

    public void deleteContact(ArrayList<Contact> list) {
        GetData gd = new GetData();
        System.out.println("------- Delete a Contact -------");
        //check empty list
        if (list.isEmpty()) {
            System.out.println("List is empty!!!");
        }
        do {
            try {
                int count = 0;
                int ID = gd.inputID("Enter ID: ", list);
                /*loop use access from the first element to last element in array list*/
                for (int i = 0; i < list.size(); i++) {
                    //compare delete ID with ID entered in array list
                    if (list.get(i).getID() == ID) {
                        count++; 
                        list.remove(list.get(i));
                        System.out.println("Successful");
                    }
                }
                if(count == 0){
                    throw new Exception();
                }else{
                    break;  
                } 
            } catch (Exception e) {
                System.out.println("Not found delete ID");
            }
            }while (true);
        }

    }
