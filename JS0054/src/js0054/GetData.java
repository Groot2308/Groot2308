/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0054;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class GetData {

    public static Scanner sc = new Scanner(System.in);

    public int getChoice(int min, int max) {
        String input;
        double choice;
        do {
            System.out.println("Your choice:");
            input = sc.nextLine();
            //check input empty
            if (input.isEmpty()) {
                System.out.println("Not empty! Please choice from " + min + " to " + max);
                continue;
            }
            try {
                choice = Double.parseDouble(input);
                //check input not real number
                if ((int) choice != choice) {
                    throw new Exception();
                }
                //check input not less than min or higher than max
                if (choice < min || choice > max) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! " + "Please choice from " + min + " to " + max);
            } catch (Error number) {
                System.out.println("Please choice from " + min + " to " + max);
            } catch (Exception realnumber) {
                System.out.println("Not real number! " + "Please choice from " + min + " to " + max);
            }
        } while (true);
        return (int) choice;
    }

    public String getName(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim();
                //check input not empty
                if (input.isEmpty()) {
                    throw new Error();
                }
                //check regex not number and characters
                if (!input.matches("([A-Za-z]{1}[a-z]+)[ ]([A-Za-z]{1}[a-z]+)")) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("error! Input again!!!");
            } catch (Error e) {
                System.out.println("Not empty!!!");
            }
        } while (true);
        return input;
    }

    public String inputIsString(String s) {
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim();
                //check input not empty
                if (input.isEmpty()) {
                    System.out.println("Not empty! Input again!");
                    continue;
                }
                //check regex not number and characters
                if (!input.matches("\\D+") || input.matches("\\W+")) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input again!");
            }
        } while (true);
        return input;
    }

    public String inputPhone(String s) {
        //[0-9] must be number from 0 to 9
        //{10} must be 10 digits
        String PHONE_VALID_0 = "[0-9]{10}";

        //[0-9] must be number from 0 to 9
        //{3} must be 3 digits
        //{4} must be 4 digits
        //[-] must contain character - 
        String PHONE_VALID_1 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}";

        //[0-9] must be number from 0 to 9
        //{3} must be 3 digits
        //{4} must be 4 digits
        //[.] must contain character .
        String PHONE_VALID_2 = "[0-9]{3}[.][0-9]{3}[.][0-9]{4}";

        //[0-9] must be number from 0 to 9
        //{3} must be 3 digits
        //{4} must be 4 digits
        //[ ] must contain character " "
        String PHONE_VALID_3 = "[0-9]{3}[ ][0-9]{3}[ ][0-9]{4}";

        //[0-9] must be number from 0 to 9
        //{3} must be 3 digits
        //{4} must be 4 digits
        //[-] must contain character -
        //[ ] must contain character " "
        //[a-z0-9] contain number and aphabet 
        //+ characters can repeat 1 or more times
        String PHONE_VALID_4 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ ][a-z0-9]+";

        //[0-9] must be number from 0 to 9
        //{3} must be 3 digits
        //{4} must be 4 digits
        //[-] must contain character -
        //[(] must contain character (
        //[)] must contain character )
        String PHONE_VALID_5 = "[(][0-9]{3}[)][-][0-9]{3}[-][0-9]{4}";
        String input;
        do {
            System.out.print(s);
            try {
                input = sc.nextLine().trim();
                //check input not empty
                if (input.isEmpty()) {
                    System.out.println("Not empty");
                    continue;
                }
                //check input matches phone_valid
                if (!input.matches(PHONE_VALID_0) && !input.matches(PHONE_VALID_1) && !input.matches(PHONE_VALID_2)
                        && !input.matches(PHONE_VALID_3) && !input.matches(PHONE_VALID_4) && !input.matches(PHONE_VALID_5)) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please input Phone flow\n"
                        + "• 1234567890"
                        + "• 123-456-7890 s\n"
                        + "• 123-456-7890 x1234\n"
                        + "• 123-456-7890 ext1234\n"
                        + "• (123)-456-7890\n"
                        + "• 123.456.7890\n"
                        + "• 123 456 7890");

            }
        } while (true);
        return input;
    }

    int inputID(String s, ArrayList<Contact> list) {
        String input;
        double id;
        do {
            System.out.print(s);
            input = sc.nextLine().trim();
            //check input not empty
            if (input.isEmpty()) {
                System.out.println("Not empty! ID is digt");
                continue;
            }
            try {
                id = Double.parseDouble(input);
                //check input not less than 0
                if (id <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception realnumber) {
                System.out.println("ID is digit");
            }
        } while (true);
        return (int) id;
    }
}
