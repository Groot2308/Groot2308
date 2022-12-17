/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg105;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        ArrayList<Products> listProducts = new ArrayList<>(); 
        ArrayList<Storekeeper> listStorekeeper = new ArrayList<>(); 
        Menu menu = new Menu(); 
        GetInput input = new GetInput(); 
        ProductsManagement p = new ProductsManagement(); 
        int choice; 
        do{
            //Step 1: create display Menu
            menu.creatMenu(); 
            //Step 2: input selected choice
            choice = input.getChoice(1,6); 
            //Step 3: Execute selected choice
            switch(choice){
                //add storekeeper
                case 1: 
                    p.addStorekeeper(listStorekeeper); 
                    break; 
                //add product
                case 2:
                    p.addProduct(listProducts, listStorekeeper); 
                    break; 
                //update product
                case 3:
                    p.updateProduct(listProducts, listStorekeeper); 
                    break; 
                //search product
                case 4: 
                    p.searchProduct(listProducts, listStorekeeper); 
                    break; 
                //sort product
                case 5:
                    p.sortProduct(listProducts, listStorekeeper); 
                    break; 
                case 6: 
                    System.exit(0);
                    break;
            }      
        }while(true); 
    }
    
}
