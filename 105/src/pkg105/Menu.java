/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg105;

/**
 *
 * @author asus
 */
class Menu {

    void creatMenu() {
        System.out.println("======== Products Management ========");
        System.out.println("1. Add Storekeeper");
        System.out.println("2. Add product");
        System.out.println("3. Update product");
        System.out.println("4. Search product by Name,Category,Storekeeper,ReceiptDate");
        System.out.println("5. Sort product by Expiry date, Date of manufacture");
        System.out.println("6. Exit");
    }

    void CreatMenuUpdate() {
        System.out.println("1. Update ID");
        System.out.println("2. Update Name");
        System.out.println("3. Update Location");
        System.out.println("4. Update Price");
        System.out.println("5. Update Expiry date");
        System.out.println("6. Update Date of manufacture");
        System.out.println("7. Update Category");
        System.out.println("8. Update Storekeeper");
        System.out.println("9. Update ReceiptDates");
    }

    void creatMenuSearch() {
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Category");
        System.out.println("3. Search by Storekeeper");
        System.out.println("4. Search by ReceiptDate");
    }
}
