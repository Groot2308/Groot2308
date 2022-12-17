/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0073;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Expense> list = new ArrayList<>();
        Menu menu = new Menu();
        getInput g = new getInput();
        expenseManage m = new expenseManage();
        m.writeToFile(list);
        m.ReadFromFile(list);
        int choice;
        do {
            menu.creatMenu();
            choice = g.getChocie(1, 4);
            switch (choice) {
                case 1:
                    m.addExpense(list);
                    m.writeToFile(list);
                    break;
                case 2:
                    m.displayAll(list);
                    break;
                case 3:
                    m.deleteExpense(list);
                    m.writeToFile(list);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (true);

    }

}
