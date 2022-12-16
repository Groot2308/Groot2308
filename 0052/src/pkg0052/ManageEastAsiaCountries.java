/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0052;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author asus
 */
public class ManageEastAsiaCountries {

    public static Scanner sc = new Scanner(System.in);

    public static void addCountryInformation(ArrayList<EastAsiaCountries> ct) {
        //Check just input 11 Southeast Asia Countries
        if (!checkInputAmountCountry(ct, 1)) {
            System.out.println("Just be have 11 Southeast Asia Countries!! Not add new Countries");
            return;
        }
        String countryCode;
        do {
            try {
                countryCode = getInput.InputIsString("Enter code of country:");
                //check enter new country code with entered country code
                if (!checkInputCodeCountry(ct, countryCode)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("New country code is not duplicate entered country code!");
            }
        } while (true);

        String countryName;
        do {
            try {
                countryName = getInput.InputIsString("Enter name of country:");
                //check enter new country name with entered country name
                if (!checkInputNameCountry(ct, countryName)) {
                    throw new Error();
                }
                break;
            } catch (Error exError) {
                System.out.println("New country name is not duplicate entered country name!");
            }
        } while (true);
        float totalArea = (float) getInput.InputIsDouble("Enter total area:");
        String countryTerrain = getInput.InputIsString("Enter terrain of country:");
        ct.add(new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain));

    }

    public static void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> ct) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        if (ct.isEmpty()) {
            System.out.println("List is Empty!");
        }
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < ct.size(); i++) {
            ct.get(i).display();
        }
    }

    public static void searchInformationByName(ArrayList<EastAsiaCountries> ct) {
       do{
           try{
        String SearchName = getInput.InputIsString("Enter the name you want to search for: ");
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        if (ct.isEmpty()) {
            System.out.println("List is Empty!");
        }
        int count = 0; 
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < ct.size(); i++) {
            //compare each countryName entered with search country name
            if (ct.get(i).countryName.equalsIgnoreCase(SearchName) == true) {
                count++; 
                ct.get(i).display();
            }
        }
        if(count == 0){
            throw new Exception(); 
        }else{
            break; 
        }
           }catch(Exception exception){
               System.out.println("Not found");
           }
       }while(true); 
    }

    public static void sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> ct) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        if (ct.isEmpty()) {
            System.out.println("List is Empty!");
        }
//        Comparator obj = (Comparator) new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                EastAsiaCountries e1 = (EastAsiaCountries) o1;
//                EastAsiaCountries e2 = (EastAsiaCountries) o2;
//                return e1.getCountryName().compareToIgnoreCase(e2.getCountryName());
//            }
//        };
//        Collections.sort(ct, obj);
//        /*loop use access each element from the first element
//          to the last element in arraylist*/
//        for (int i = 0; i < ct.size(); i++) {
//            ct.get(i).display();
//        }
    }

    public static boolean checkInputCodeCountry(ArrayList<EastAsiaCountries> ct, String countryCode) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < ct.size(); i++) {
            //compare each countryCode entered with new countryCode
            if (ct.get(i).getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInputNameCountry(ArrayList<EastAsiaCountries> ct, String countryName) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < ct.size(); i++) {
            //compare each countryName entered with new countryName
            if (ct.get(i).getCountryName().equalsIgnoreCase(countryName)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInputAmountCountry(ArrayList<EastAsiaCountries> ct, int choice) {
        if ((ct.size() + 1) > 11) {
            if (choice == 1) {
                return false;
            }
        }
        return true;
    }

}
