/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0011;
/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Convert convert = new Convert();
        GetInput input = new GetInput();
        Menu menu = new Menu();
        int choice;
        do {
            //Step 1: Creat display menu
            menu.creatMenu();
            //Step 2: input selected choice
            choice = input.getChoice(1, 4);
            //Step 3: Execute selected choice
            switch (choice) {
                case 1:
                    //input binary number
                    String binary = input.getInputBinary("Enter number of binary: "); 
                    //Convert binary number to other
                    convert.convertBinarytOther(binary);
                    break;
                case 2:
                    //input decimal number
                    String decimal = input.getInputDec("Enter number of decimal: "); 
                    //Convert decimal number to other
                    convert.convertDecimaltOther(decimal);
                    break;
                case 3:
                    //input hexadecimal number
                    String hexadecimal = input.getInputHexadecimal("Enter number of hexadecimal: "); 
                    //Convert hexadecimal number to other
                    convert.converHexadecimaltOther(hexadecimal);
                    break;
                case 4:
                    //Exit the program
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
