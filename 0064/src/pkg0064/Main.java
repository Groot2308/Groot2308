/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0064;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: Input phone number
     //   String phoneNumber = getPhone("Phone number: ");
        //Step 2: Input email
      //  String email = getEmail("Email: ");
        //Step 3; Input date
        String date = getDate("Date: ");
    }

    public static Scanner sc = new Scanner(System.in);

    private static String getPhone(String phoneNumber) {

        String input;
        String phone1 = "[0-9]{10}";
        double phone;
        do {
            System.out.print(phoneNumber);
            input = sc.nextLine();
            //check input not empty
            if (input.isEmpty()) {
                System.out.println("Not empty! Phone number must is number");
                continue;
            }
            try {
                phone = Double.parseDouble(input);
                //check input phone number not less than 0
                if (phone < 0) {
                    throw new Exception();
                }
                //check input phone number not real number
                if ((int) phone != phone) {
                    throw new Error();
                }
                //check format phone number
                if (!input.matches(phone1)) {
                    System.out.println("Phone number must be 10 digits");
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Phone number must is number");
            } catch (Exception e) {
                System.out.println("Not less than 0! Phone number must be 10 digits");
            } catch (Error error) {
                System.out.println("Not real number! Phone number must be 10 digits");
            }
        } while (true);
        return input;
    }

    private static String getEmail(String email) {
        String input;
        String formatEmail = "[A-Za-z0-9]+[@]+[a-z]+[.]+[a-z]{2,4}";
        do {
            try {
                System.out.print(email);
                input = sc.nextLine();
                //check input not empty
                if (input.isEmpty()) {
                    System.out.println("Email not empty!!");
                    continue;
                    //check format email
                }
                if (!input.matches(formatEmail)) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Email must is correct format");
            }
        } while (true);
        return input;
    }

    private static String getDate(String date) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String input;
        do {
            System.out.print(date);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Date not empty");
                continue;
            }
            try {
                if (!input.matches("[0-3]{1}+[0-9]{1}+[/]+[0-3]{1}+[0-9]{1}+/+[0-9]{4}")) {
                    System.out.println("Date to correct format(dd/mm/yyyy)");
                    continue;
                }
                //setLenient to check date not exist or exist
                sd.setLenient(false);
                sd.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println("Date does not exist!!");
            }
        } while (true);
        System.out.println(input);
        return input;
    }
}