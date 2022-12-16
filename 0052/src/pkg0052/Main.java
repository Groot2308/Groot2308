/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0052;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<EastAsiaCountries> ct = new ArrayList<>();
        Menu menu = new Menu();
        getInput g = new getInput();
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        do {
            //Step 1: Display a menu
            menu.creatMenu();
            //Step 2: input select an option
            int choice = g.getChoice(1, 5);
            //Step 3: Execute selected option
            switch (choice) {
                // add information for countries ins Southeast Asia
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(ct);
                    break;
                // display already information
                case 2:
                    ManageEastAsiaCountries.getRecentlyEnteredInformation(ct);
                    break;
                // search the country according to the entered country's name
                case 3:
                    ManageEastAsiaCountries.searchInformationByName(ct);
                    break;
                // sort the information increasing with the country name
                case 4:
                    ManageEastAsiaCountries.sortInformationByAscendingOrder(ct);
                    break;
                case 5:
                    // exit program
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
