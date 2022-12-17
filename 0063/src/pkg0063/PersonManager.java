/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0063;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class PersonManager {

    public static GetInput input = new GetInput();
    void inputPersonInfo(ArrayList<Person> list) {
        System.out.println("=====Management Person programer=====");
        do {
            System.out.println("Input Information of Person");
            String name = input.inputIsString("Please input name:");
            String address = input.inputIsString("Please input address:");
            double salary = input.inputIsDouble("Please input salary:");
            list.add(new Person(name, address, salary));
        } while (list.size() < 3);
    }

    void sortASCBySalary(ArrayList<Person> list) {
        /*Loop use access from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < list.size(); i++) {
            /*Loop use access first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < list.size() - i - 1; j++) {
                //compare each pair adjacent elements
                if (list.get(j).getSalary() > list.get(j + 1).getSalary()) {
                    Person temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    void displayPersonInfo(ArrayList<Person> list) {
        System.out.println("");
        /*loop use access from the first element 
        to the last element in array list*/
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Information of Person you have entered:");
            list.get(i).display();
            System.out.println("");
        }
    }
}
