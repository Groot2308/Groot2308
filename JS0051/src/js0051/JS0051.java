/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0051;

/**
 *
 * @author asus
 */
public class JS0051 {

    public static void main(String[] args) {
        //Class creat display Menu
        Menu m = new Menu();
        //Class input data 
        getInput input = new getInput();
        //Class creat calculator program
        CaclulatorProgram calculatorProgram = new CaclulatorProgram();
        int choice;
        do {
            //Step 1: Display menu
            m.creatMenu();
            //Step 2: input select an option
            choice = input.getChoice(1, 3);
            //Step 3: Execute selected option
            switch (choice) {
                //Normal calulator
                case 1:
                    calculatorProgram.normalCalculator();
                    break;
                //BMI calculator
                case 2:
                    calculatorProgram.BMIcalculator();
                    break;
                //Exit the program
                case 3:
                    System.out.println("Exit the program");
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
