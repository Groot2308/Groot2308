/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0073;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
class expenseManage {

    public static getInput g = new getInput();

    void addExpense(ArrayList<Expense> list) {
        System.out.println("-------- Add an expense --------");
        int id = list.size() + 1;
        String date = g.getDate("Enter Date: ");
        double amount = g.getDouble("Enter Amount: ");
        String content = g.getString("Enter Content: ");
        list.add(new Expense(id, date, amount, content));
        System.err.println("Successfully");
    }

    void displayAll(ArrayList<Expense> list) {
           if (list.isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        System.out.println("---------Display all expenses------------");
        System.out.printf("%-5s%-15s%-12s%-5s\n", "ID", "Date", "Amount", "Content");
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-5s%-15s%-12.0f%-5s\n", list.get(i).getID(),
                    list.get(i).getDate(), list.get(i).getNumber(), list.get(i).getContent());
            total = total + list.get(i).getNumber();
        }
        System.out.printf("             Total:       %-20.0f\n", total);
    }

    void deleteExpense(ArrayList<Expense> list) {
        System.out.println("---------Delete an expense---------");
        do {
            try {
                int count = 0;
                int deleteID = g.inputID("Enter ID: ");
                /*loop use access from the first element to the 
                last element of array list */
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID() == deleteID) {
                        count++;
                        list.remove(i);
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found delete ID");
            }
        } while (true);
    }

    public void writeToFile(ArrayList<Expense> list) throws IOException {
        try {
            File file = new File("text1.txt");
            //check file exists or not exists
            if (!file.exists() || file.isDirectory()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i).toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public void ReadFromFile(ArrayList<Expense> list) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("text1.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] s = line.split("[|]");
                int id = Integer.parseInt(s[0].trim());
                String date = s[1].trim();
                double amount = Double.parseDouble(s[2].trim());
                String content = s[3].trim();
                list.add(new Expense(id, date, amount, content));
            }
        }catch(IOException e){
            System.out.println("Error! File not exist");
        } finally {
            if (fileReader != null && bufferedReader != null) {
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        }
    }
}
