/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch_tuanvm;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LinearSearch_tuanvm {

    public static void main(String[] args) {
        //Step 1: Input size array a positive decimal number
        int sizeArray = inputPositiveNumber("Enter number of array: ");
        //Step 2: Input search number a positive decimal number
        int searchValue = inputSearchPosValue("Enter search value: ");
        //Step 3: Creat random integer array
        int[] array = randomArray(sizeArray);
        //Step 4: Display the array
        displayArray(array, "The array: ");
        //Step 5: Search index value by linearSearch
        int indexValue = linearSearch(array, searchValue);
        //Step 6: Display index search value
        displayIndex(linearSearch(array, searchValue), searchValue); 
    }

    public static int inputPositiveNumber(String s) {
        Scanner sc = new Scanner(System.in);
        String input;
        double sizeArray;
        do {
            System.out.println(s);
            input = sc.nextLine();
            //check input not empty
            if (input.isEmpty()) {
                System.out.println("Not empty! Input a positive decimal number");
                continue;
            }
            try {
                sizeArray = Double.parseDouble(input);
                //check input not less than 0 
                if (sizeArray <= 0) {
                    throw new Error();
                }
                //check input not real number
                if ((int) sizeArray != sizeArray) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input a positive decimal number");
            } catch (Error intNumber) {
                System.out.println("Not less than 0! Input a positive decimal number");
            } catch (Exception realNumber) {
                System.out.println("Not real number! Input a positive decimal number");
            }
        } while (true);
        return (int) sizeArray;
    }

    public static int inputSearchPosValue(String s) {
        Scanner sc = new Scanner(System.in);
        String input;
        double searchValue;
        do {
            System.out.println(s);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Not empty! Input a positive decimal number");
                continue;
            }
            try {
                searchValue = Double.parseDouble(input);
                if (searchValue < 0) {
                    throw new Error();
                }
                if ((int) searchValue != searchValue) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Not String! Input a positive decimal number");
            } catch (Error intNumber) {
                System.out.println("Not less than 0! Input a positive decimal number");
            } catch (Exception realNumber) {
                System.out.println("Not real number! Input a positive decimal number");
            }
        } while (true);
        return (int) searchValue;
    }

    private static int[] randomArray(int sizeArray) {
        int[] array = new int[sizeArray];
        Random random = new Random();
        //Loop use to random each element of array
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(sizeArray);
        }
        return array;
    }

    private static void displayArray(int[] array, String s) {
        System.out.print(s);
        System.out.print("[");
        //Loop use to accessed each element of array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //show commas between elements in array
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
        public static int linearSearch(int[] array, int searchValue) {
        /*Use loop to access from the first element of to the last element 
        of array for search value to find*/
        for (int i = 0; i < array.length; i++) {
            // compares each element in array with search value
            if (array[i] == searchValue) {
                return i; 
            }
        }
        return -1;
    }    

    public static void displayIndex(int linearSearch, int searchValue) {
        //show index search value
        if(linearSearch != -1){
        System.out.println("\nFound " + searchValue + " at index: " + linearSearch);
        //Found search value
        }else if(linearSearch == -1){
            System.out.println("\nCan't found search value");
        }
    }
}
