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
class EmployeesManager {

    public static GetInput input = new GetInput();
    public static Menu menu = new Menu();

    public boolean checkDuplicateID(ArrayList<Employees> list, String employeesID) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < list.size(); i++) {
            //compare each employeesID entered with new employeesID
            if (list.get(i).getID().equalsIgnoreCase(employeesID)) {
                return false;
            }
        }
        return true;
    }

    void addEmployees(ArrayList<Employees> list) {
        System.out.println("--------- Add Employees ---------");
        String employeesID;
        do {
            try {
                employeesID = input.inputID("Enter ID: ", list);
                //check duplicate employeesID
                if (!checkDuplicateID(list, employeesID)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("New Employees ID is not duplicate entered employees ID!");
            }
        } while (true);
        String firstName = input.inputString("Enter first name: ");
        String lastName = input.inputString("Enter last name: ");
        String phone = input.inputPhone("Enter phone number: ");
        String email = input.inputEmail("Email: ");
        String address = input.inputString("Enter address: ");
        String DOB = input.inputDate("Enter DOB: ");
        String sex = input.inputSex("Enter sex: ");
        double salary = input.inputDouble("Enter salary: ");
        String agency = input.inputString("Enter agency: ");
        list.add(new Employees(employeesID, firstName, lastName, phone, email, address, DOB, sex, salary, agency));
        System.out.println("--Add Successful--");
    }

    void updateEmployees(ArrayList<Employees> list) {
        System.out.println("--------- Update Employees ---------");
        int count = 0;
        //check empty list employees 
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String updateEmployees;
        do {
            try {
                updateEmployees = input.inputID("Enter ID update: ", list);
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID().equalsIgnoreCase(updateEmployees) == true) {
                        count++;
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Employees ID does not exist");
            }
        } while (true);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equalsIgnoreCase(updateEmployees) == true) {
                menu.CreatMenuUpdate();
            int choice = input.getChocie(1, 10);
            switch (choice) {
                //update ID
                case 1:
                    String xID;
                    do {
                        try {
                            xID = input.inputID("Enter new ID: ", list);
                            //check duplicate employeesID
                            if (!checkDuplicateID(list, xID) && xID.equals(updateEmployees) == false) {
                                throw new Exception();
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("New Employees ID is not duplicate entered employees ID");
                        }
                    } while (true);
                    list.get(i).setID(xID);
                    break;
                //update first name 
                case 2:
                    String xFirstName = input.inputString("Enter new first Name: ");
                    list.get(i).setFirstName(xFirstName);
                    break;
                //update last name
                case 3:
                    String xLastName = input.inputString("Enter new last Name: ");
                    list.get(i).setLastName(xLastName);
                    break;
                //update phone
                case 4:
                    String xPhone = input.inputPhone("Enter new phone number: ");
                    list.get(i).setPhone(xPhone);
                    break;
                //update email
                case 5:
                    String xEmail = input.inputEmail("Enter new email: ");
                    list.get(i).setEmail(xEmail);
                    break;
                //update address
                case 6:
                    String xAddress = input.inputString("Enter new address: ");
                    list.get(i).setAddress(xAddress);
                    break; 
                //update DOB
                case 7:
                    String xDOB = input.inputDate("Enter new DOB: ");
                    list.get(i).setDOB(xDOB);
                    break;    
                //update Sex
                case 8:
                    String xSex = input.inputSex("Enter new sex: ");
                    list.get(i).setSex(xSex);
                    break;
                //update salary
                case 9:
                    double xSalary = input.inputDouble("Enter new salary: ");
                    list.get(i).setSalary(xSalary);
                    break;
                //update agency
                case 10:
                    String xAgency = input.inputString("Enter new agency: ");
                    list.get(i).setAgency(xAgency);
                    break;
            }
            }
        }
        System.out.println("--Update Successful--");
    }

    void removeEmployees(ArrayList<Employees> list) {
        System.out.println("--------- Remove Employees -------");
        //check empty list employees  
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                int count = 0;
                String removeID = input.inputID("Enter ID: ", list);
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < list.size(); i++) {
                    //compare employeesID entered in array list with remove employeesID
                    if (list.get(i).getID().equalsIgnoreCase(removeID) == true) {
                        count++;
                        list.remove(i);
                        System.out.println("--Remove successful--");
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("ID does not exist Employees");
            }
        } while (true);
    }

    void searchEmployees(ArrayList<Employees> list) {
        System.out.println("---------- Search Employees --------");
        //check empty list employees 
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String SearchName = input.inputString("Enter search name: ");
                int count = 0;
                System.out.println("--------- Result --------------");
                System.out.printf("%-6s%-15s%-15s%-15s%-23s%-20s%-15s%-10s%-5s\n", "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < list.size(); i++) {
                    String fullName = list.get(i).getFirstName()+" "+list.get(i).getLastName(); 
                    //compare employees name entered in array list with search employees name
                    if (list.get(i).getFirstName().equalsIgnoreCase(SearchName) == true || list.get(i).getLastName().equalsIgnoreCase(SearchName)
                            || fullName.contains(SearchName)) {
                        count++;
                        list.get(i).display();
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found search name employees!!");
            }
        } while (true);
    }

    void sortEmployeesBySalary(ArrayList<Employees> list) {
        System.out.println("---------- Sort Employees --------");
        /*Loop use access from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < list.size(); i++) {
            /*Loop use access first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < list.size() - i - 1; j++) {
                //compare each pair adjacent elements
                if (list.get(j).getSalary() > list.get(j + 1).getSalary()) {
                    Employees temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        System.out.printf("%-6s%-15s%-15s%-15s%-23s%-20s%-15s%-10s%-5s\n", "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        /*loop use access each element from the first element
         to the last element in arraylist*/
        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
        }
    }
}
