/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0011;

import java.math.BigInteger;
/**
 *
 * @author asus
 */
class Convert {

    GetInput g = new GetInput();

    public static String converBinaryToDecimal(String binary) {
        BigInteger sumValue = new BigInteger("0");
        BigInteger BIN = new BigInteger("2");
        /*loop use access from the first character to 
          the last character*/
        for (int i = 0; i < binary.length(); i++) {
            BigInteger number = new BigInteger(String.valueOf(binary.charAt(i)));
            sumValue = sumValue.add(number.multiply(BIN.pow(binary.length() - 1 - i)));
        }
        String decimal = sumValue.toString();
        return decimal;
    }

    public static String convertDecimalToBinary(String decimal) {
        String Value = "";
        BigInteger BIN = new BigInteger("2");
        BigInteger zero = new BigInteger("0");
        String binary = "";
        BigInteger dec = new BigInteger(decimal);
        //loop until when dec equal zero
        while (dec.equals(zero) == false) {
            Value += (dec.remainder(BIN));
            dec = dec.divide(BIN);
        }
        /*loop use access from the last element to the first element*/
        for (int i = Value.length() - 1; i >= 0; i--) {
            binary += Value.charAt(i);
        }
        return binary;
    }

    public static String convertDecimalToHexa(String decimal) {
        String sumValue = "";
        String hexa = "";
        BigInteger hex = new BigInteger("16");
        BigInteger zero = new BigInteger("0");
        String[] HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        BigInteger dec = new BigInteger(decimal);
        //loop until when dec equal zero
        while (dec.equals(zero) == false) {
            sumValue += HEX[dec.remainder(hex).intValue()];
            dec = dec.divide(hex);
        }
        /*loop use access from the last element to the first element*/
        for (int i = sumValue.length() - 1; i >= 0; i--) {
            hexa += sumValue.charAt(i);
        }
        return hexa;
    }

    public static String convertHexaToDecimal(String hexadecimal) {
        String valueHEX = "0123456789ABCDEF";
        BigInteger sumValue = new BigInteger("0");
        BigInteger HEX = new BigInteger("16");
        /*loop use access from the first element to the last element 
         in entered hexadecimal number*/
        for (int i = 0; i < hexadecimal.length(); i++) {
            BigInteger number = new BigInteger(String.valueOf(valueHEX.indexOf(hexadecimal.charAt(i))));
            sumValue = sumValue.add(number.multiply(HEX.pow(hexadecimal.length() - 1 - i)));
        } 
        String hexa = sumValue.toString();
        return hexa;
    }

    public static String converBinaryToHexa(String binary) {
        String decimal = converBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    public static String convertHexaToBinary(String hexadecimal) {
        String decimal = convertHexaToDecimal(hexadecimal);
        String binay = convertDecimalToBinary(decimal);
        return binay;
    }

    public void convertBinarytOther(String binary) {
        System.out.println("1. Convert to 10");
        System.out.println("2. Convert to 16");
        int choice = g.getChoice(1, 2);
        switch (choice) {
            //convert from binary to decimal
            case 1:
                System.out.println("Decimal number: " + converBinaryToDecimal(binary));
                break;
            //convert from binary to hexadecimal
            case 2:
                System.out.println("Hexadecimal number: " + converBinaryToHexa(binary));
                break;
        }
    }

    public void convertDecimaltOther(String decimal) {
        System.out.println("1. Convert to 2");
        System.out.println("2. Convert to 16");
        int choice = g.getChoice(1, 2);
        switch (choice) {
            //convert from decimal to binary
            case 1:
                System.out.println("Binary number: " + convertDecimalToBinary(decimal));
                break;
            //convert from decimal to hexadecimal
            case 2:
                System.out.println("Hexadecimal number: " + convertDecimalToHexa(decimal));
                break;
        }
    }

    void converHexadecimaltOther(String hexadecimal) {
        System.out.println("1. Convert to 2");
        System.out.println("2. Convert to 10");
        int choice = g.getChoice(1, 2);
        switch (choice) {
            //convert from hexadecimal to binary
            case 1:
                System.out.println("Binary number: " + convertHexaToBinary(hexadecimal));
                break;
            //convert from hexadecimal to decimal
            case 2:
                System.out.println("Decimal number: " + convertHexaToDecimal(hexadecimal));
                break;
        }
    }
}
