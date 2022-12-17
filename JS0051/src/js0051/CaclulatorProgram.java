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
public class CaclulatorProgram {

    public double normalCalculator() {
        double result = 0;
        getInput input = new getInput();
        System.out.println("----- Normal Calculator -----");
        double memory = input.getNumber("Enter number: ");
        //loop use to perform calculations
        while (true) {
            String operator = input.getOperator("Enter Operator: ");
            //perform function add two number 
            if (operator.equalsIgnoreCase("+")) {
                memory += input.getNumber("Enter number: ");
                System.out.println("Memory:" + memory);
           
            //perform function subtract two number
            } else if (operator.equalsIgnoreCase("-")) {
                memory -= input.getNumber("Enter number: ");
                System.out.println("Memory:" + memory);
           
                //perform function multiply two number
            } else if (operator.equalsIgnoreCase("*")) {
                memory *= input.getNumber("Enter number: ");
                System.out.println("Memory:" + memory);
        
                //perform function divide two number
            } else if (operator.equalsIgnoreCase("/")) {
                double number = input.getNumber1("Enter number: ");
                memory /= number;
                System.out.println("Memory:" + memory);
          
                //perform function calculate  exponents two number 
            } else if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, input.getNumber("Enter number: "));
                System.out.println("Memory:" + memory);
          
                // loop end and show last value 
            } else if (operator.equalsIgnoreCase("=")) {
                result = memory;
                System.out.println("Result:" + result);
                break;
            }
        }
        return result;
    }
    
       public double BMIcalculator() {
        getInput input = new getInput();
        System.out.println("----- BMI Calculator -----");
        double weight = input.getBMI("Enter Weight(kg): ");
        double height = input.getBMI("Enter Height(cm): ");
        double BMI = (weight) / (height * height) * 10000;
        System.out.printf("BMI number: %.2f\n", BMI);
        System.out.print("BMI Status: ");
        //compare value status of the user's body with standard value 
        if (BMI < 19) {
            System.out.println("UNDER-STANDARD");
        } else if (BMI >= 19 && BMI < 25) {
            System.out.println("STANDARD");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("OVERWEIGHT");
        } else if (BMI >= 30 && BMI < 40) {
            System.out.println("FAT - SHOULD LOSE WEIGHT");
        } else {
            System.out.println("VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY");
        }
        return BMI;
    }
}
