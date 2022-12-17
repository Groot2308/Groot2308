/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
class ProductsManagement {

    public static GetInput input = new GetInput();
    public static Menu menu = new Menu();

    public boolean checkDuplicateProductsID(ArrayList<Products> list, String ID) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < list.size(); i++) {
            //compare each productID entered with new productID
            if (list.get(i).getID().equalsIgnoreCase(ID)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkStorekeeper(ArrayList<Storekeeper> list, String Storekeeper) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < list.size(); i++) {
            //compare each storekeeper name entered with input storekeeper name
            if (list.get(i).getName().equalsIgnoreCase(Storekeeper)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicateStorekeeperName(ArrayList<Storekeeper> list, String StorekeeperName) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < list.size(); i++) {
            //compare each storekeeper name entered with new storekeeper name
            if (list.get(i).getName().equalsIgnoreCase(StorekeeperName)) {
                return false;
            }
        }
        return true;
    }

    void addStorekeeper(ArrayList<Storekeeper> listStorekeeper) {
        System.out.println("-------- Add Storekeeper --------");
        String Name;
        do {
            try {
                Name = input.inputString("Enter Name Storekeeper: ");
                //check duplicate storekeeper name
                if (!checkDuplicateStorekeeperName(listStorekeeper, Name)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("New Storekeeper name is not duplicate entered Storekeeper name!");
            }
        } while (true);
        listStorekeeper.add(new Storekeeper(Name));
        System.out.println("--Add Successful--");
    }

    void addProduct(ArrayList<Products> listProducts, ArrayList<Storekeeper> listStorekeeper) {
        if(listStorekeeper.isEmpty()){
            System.out.println("Please input storekeeper!!!");
            return;
        }
        System.out.println("-------- Add Product --------");
        String ID;
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
        do {
            try {
                ID = input.inputID("Enter ID: ", listProducts);
                //check duplicate product ID
                if (!checkDuplicateProductsID(listProducts, ID)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("New Product ID is not duplicate entered Product ID!");
            }
        } while (true);
        String Name = input.inputString("Enter Name Product: ");
        String Location = input.inputString("Enter Loccation: ");
        double Price = input.inputDouble("Enter Price: ");
        String ExpiryDate = input.inputDate("Enter Expiry Date: ", listProducts);
        String DateOfManufacture;
        do {
            try {
                DateOfManufacture = input.inputDate("Enter Date Of Manufacture: ", listProducts);
                //compare ExpiryDate with DateOfManufacture
                if ((sd.parse(ExpiryDate).compareTo(sd.parse(DateOfManufacture))) < 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Date Of Manufacture not higher than Expiry Date!");
            }
        } while (true);
        String Category = input.inputString("Enter Category: ");
        String Storekeeper;
        do {
            try {
                Storekeeper = input.inputString("Enter Storekeeper: ");
                //check storekeeper must equal entered storekeeper
                if (!checkStorekeeper(listStorekeeper, Storekeeper)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Storekeeper does not exist!");
            }
        } while (true);
        String ReceiptDate;
        do {
            try {
                ReceiptDate = input.inputDate("Enter ReceiptDate: ", listProducts);
                //compare reciptDate with expiryDate and dateOfManufacture
                if (sd.parse(ExpiryDate).compareTo(sd.parse(ReceiptDate)) < 0 || sd.parse(DateOfManufacture).compareTo(sd.parse(ReceiptDate)) > 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Receipt Date not higher than Expiry Date! and not less than Date Of Manufacture");
            }
        } while (true);
        listProducts.add(new Products(ID, Name, Location, Price, ExpiryDate, DateOfManufacture, Category, Storekeeper, ReceiptDate));
        System.out.println("--Add Successful--");
    }

    void updateProduct(ArrayList<Products> listProducts, ArrayList<Storekeeper> listStorekeeper) {
        System.out.println("-------- Update Product --------");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
        int count = 0;
        //check empty list product 
        if (listProducts.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String updateID;
        do {
            try {
                updateID = input.inputID("Enter update ID: ", listProducts);
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < listProducts.size(); i++) {
                    //compare each entered product ID with update product ID 
                    if (listProducts.get(i).getID().equalsIgnoreCase(updateID) == true) {
                        count++;
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Products ID does not exist");
            }
        } while (true);
        /*loop use access each element from the first element
            to the last element in arraylist*/
        for (int i = 0; i < listProducts.size(); i++) {
            //compare each entered product ID with update product ID 
            if (listProducts.get(i).getID().equalsIgnoreCase(updateID) == true) {
                menu.CreatMenuUpdate();
                int choice = input.getChoice(1, 9);
                switch (choice) {
                    //update product ID
                    case 1:
                        String xID;
                        do {
                            try {
                                xID = input.inputID("Enter ID: ", listProducts);
                                //check duplicate product ID
                                if (!checkDuplicateProductsID(listProducts, xID) && xID.equals(updateID) == false) {
                                    throw new Exception();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("New Product ID is not duplicate entered product ID");
                            }
                        } while (true);
                        listProducts.get(i).setID(xID);
                        break;
                    case 2:
                        String xName = input.inputString("Enter Name Product: ");
                        listProducts.get(i).setName(xName);
                        break;
                    case 3:
                        String xLocation = input.inputString("Enter Location: ");
                        listProducts.get(i).setLocation(xLocation);
                        break;
                    case 4:
                        double xPrice = input.inputDouble("Enter Price: ");
                        listProducts.get(i).setPrice(xPrice);
                        break;
                    case 5:
                        String xExpiryDate;
                        do {
                            try {
                                xExpiryDate = input.inputDate("Enter Expiry Date: ", listProducts);
                                //compare ExpiryDate with DateOfManufacture
                                if (sd.parse(listProducts.get(i).getDateOfManufacture()).compareTo(sd.parse(xExpiryDate)) > 0) {
                                    throw new Exception();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Receipt Date not less than Date Of Manufacture!");
                            }
                        } while (true);
                        listProducts.get(i).setExpiryDate(xExpiryDate);
                        break;
                    case 6:
                        String xDateOfManufacture;
                        do {
                            try {
                                xDateOfManufacture = input.inputDate("Enter Date Of Manufacture: ", listProducts);
                                //compare DateOfManufacture with ReceiptDate
                                if (sd.parse(listProducts.get(i).getReceiptDate()).compareTo(sd.parse(xDateOfManufacture)) < 0) {
                                    throw new Exception();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Date Of Manufacture not higher than ReceiptDate!");
                            }
                        } while (true);
                        listProducts.get(i).setDateOfManufacture(xDateOfManufacture);
                    case 7:
                        String xCategory = input.inputString("Enter Category: ");
                        listProducts.get(i).setCategory(xCategory);
                        break;
                    case 8:
                        String xStorekeeper;
                        do {
                            try {
                                xStorekeeper = input.inputString("Enter Storekeeper: ");
                                //check storekeeper must equal entered storekeeper
                                if (!checkStorekeeper(listStorekeeper, xStorekeeper)) {
                                    throw new Exception();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Storekeeper does not exist!");
                            }
                        } while (true);
                        listProducts.get(i).setStorekeeper(xStorekeeper);
                        break;
                    case 9:
                        String xReceiptDate;
                        do {
                            try {
                                xReceiptDate = input.inputDate("Enter ReceiptDate: ", listProducts);
                                //compare ReceiptDate with ExpiryDate and DateOfManufacture
                                if (sd.parse(listProducts.get(i).getExpiryDate()).compareTo(sd.parse(xReceiptDate)) < 0
                                        && sd.parse(listProducts.get(i).getDateOfManufacture()).compareTo(sd.parse(xReceiptDate)) > 0) {
                                    throw new Exception();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Receipt Date not less than Expiry Date!");
                            }
                        } while (true);
                        listProducts.get(i).setReceiptDate(xReceiptDate);
                        break;
                }
            }
        }
        System.out.println("--Update Successful--");
    }

    void searchProduct(ArrayList<Products> listProducts, ArrayList<Storekeeper> listStorekeeper) {
        //check empty list product 
        if(listProducts.isEmpty()){
            System.out.println("List is Empty!!!");
            return;
        }
        System.out.println("-------- Search Product --------");
        menu.creatMenuSearch();
        int choice = input.getChoice(1, 4);
        switch (choice) {
            //search product by Name
            case 1:
                searchByName(listProducts);
                break;
            //search product by Category
            case 2:
                searchByCategory(listProducts);
                break;
            //search product by storekeeper
            case 3:
                searchByStorekeeper(listProducts);
                break;
            //search product by receiptDate
            case 4:
                searchByReceiptDate(listProducts);
                break;
        }
    }

    void searchByName(ArrayList<Products> listProducts) {
        //check empty list product 
        if (listProducts.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String SearchName = input.inputString("Enter search name: ");
                int count = 0;
                System.out.println("--------------------------- Result ------------------------------");
                System.out.printf("%-3s%-15s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                        "ID", "Name", "Location", "Price", "ExpiryDate", "DateOfManufacture", "Category", "Storekeeper", "ReceiptDate");
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < listProducts.size(); i++) {
                    //compare product name entered in array list with search product name
                    if (listProducts.get(i).getName().equalsIgnoreCase(SearchName) == true) {
                        count++;
                        listProducts.get(i).display();
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found search name products!!");
            }
        } while (true);
    }

    void searchByCategory(ArrayList<Products> listProducts) {
        //check empty list product 
        if (listProducts.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String SearchCategory = input.inputString("Enter search category: ");
                int count = 0;
                System.out.println("--------------------------- Result ------------------------------");
                System.out.printf("%-3s%-15s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                        "ID", "Name", "Location", "Price", "ExpiryDate", "DateOfManufacture", "Category", "Storekeeper", "ReceiptDate");
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < listProducts.size(); i++) {
                    //compare product category entered in array list with search product category
                    if (listProducts.get(i).getCategory().equalsIgnoreCase(SearchCategory) == true) {
                        count++;
                        listProducts.get(i).display();
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found search category products!!");
            }
        } while (true);
    }

    void searchByStorekeeper(ArrayList<Products> listProducts) {
        //check empty list product 
        if (listProducts.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String SearchStorekeeper = input.inputString("Enter search Storekeeper: ");
                int count = 0;
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < listProducts.size(); i++) {
                    //compare product storekeeper entered in array list with search product storekeeper
                    if (listProducts.get(i).getStorekeeper().equalsIgnoreCase(SearchStorekeeper) == true) {
                        count++;
                        if(count > 0){
                        listProducts.get(i).display();
                        }
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found search Storekeeper products!!");
            }
        } while (true);
    }

    void searchByReceiptDate(ArrayList<Products> listProducts) {
        //check empty list product
        if (listProducts.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String SearchReceiptDate = input.inputDate("Enter search ReceiptDate: ", listProducts);
                int count = 0;
                System.out.println("--------------------------- Result ------------------------------");
                System.out.printf("%-3s%-15s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                        "ID", "Name", "Location", "Price", "ExpiryDate", "DateOfManufacture", "Category", "Storekeeper", "ReceiptDate");
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < listProducts.size(); i++) {
                    //compare product receiptDate entered in array list with search product reciptDate
                    if (listProducts.get(i).getReceiptDate().equals(SearchReceiptDate) == true) {
                        count++;
                        listProducts.get(i).display();
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found search ReceiptDate products!!");
            }
        } while (true);
    }

    void sortProduct(ArrayList<Products> listProducts, ArrayList<Storekeeper> listStorekeeper) throws ParseException {
        System.out.println("-------- Sort Product --------");
        sortByExpiryDateAndDateOfManufacture(listProducts);
    }

    void sortByExpiryDateAndDateOfManufacture(ArrayList<Products> listProducts) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
        /*Loop use access from the first to last element, 
        after each loop, one element is sorted*/
        for (int i = 0; i < listProducts.size(); i++) {
            /*Loop use access first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < listProducts.size() - i - 1; j++) {
                //compare each pair adjacent elements
                if (sd.parse(listProducts.get(j).getExpiryDate()).compareTo(sd.parse(listProducts.get(j+1).getExpiryDate())) > 0) {
                    Products temp = listProducts.get(j);
                    listProducts.set(j, listProducts.get(j+1));
                    listProducts.set(j+1, temp);
                } else if (listProducts.get(j).getExpiryDate().compareTo(listProducts.get(j + 1).getExpiryDate()) == 0) {
                    if (sd.parse(listProducts.get(j).getDateOfManufacture()).compareTo(sd.parse(listProducts.get(j + 1).getDateOfManufacture())) > 0) {
                        Products temp = listProducts.get(j);
                        listProducts.set(j, listProducts.get(j + 1));
                        listProducts.set(j + 1, temp);
                    }
                }
            }
        }
        System.out.println("--------------------------- Result ------------------------------");
        System.out.printf("%-3s%-15s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                "ID", "Name", "Location", "Price", "ExpiryDate", "DateOfManufacture", "Category", "Storekeeper", "ReceiptDate");
        /*loop use access from the first element to
        the last element in array list*/
        for (int i = 0; i < listProducts.size(); i++) {
            listProducts.get(i).display();
        }
    }
}
