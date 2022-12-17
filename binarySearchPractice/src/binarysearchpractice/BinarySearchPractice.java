/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchpractice;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class BinarySearchPractice {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Step 1: Input size array a positive decimal number
               int sizeArray = inputPositiveNumber("Enter number of array: ");
        //Step 2: Input search value
        int searchValue = inputSearchValue("Enter search value: ");
        //Step 3: Creat random integer array
        int[] array = randomArray(sizeArray);
        boolean check = false;

//        int[] array = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
//        boolean check = true;
        //Step 4: Sort array by bubble sort
        bubbleSort(array);
        //Step 5: Display Sorted array
        displaySortedArray(array, "Sorted array: ");
        //Step 6: find index search value by binary search
        int indexValue = binarySearch(array, searchValue, check);
        //Step 7: display index search value
        displayIndex(indexValue, searchValue);
        String temp = sc.nextLine();
    }

    private static int inputPositiveNumber(String s) {
        Scanner sc = new Scanner(System.in);
        String input;
        double sizeArray;
        do {
            System.out.println(s);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Not empty! input a positive decimal number");
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

    private static int inputSearchValue(String s) {
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
                if (searchValue <= 0) {
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
        // //Loop use to random each element of array
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(sizeArray);
        }
        return array;
    }

    private static void bubbleSort(int[] array) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    //swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void displaySortedArray(int[] array, String s) {
        System.out.print(s);
        System.out.print("[");
        // Loop use to accessed each element of array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //show commas between elements in array
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    private static int binarySearch(int[] array, int searchValue, boolean check) {
        int left = 0;
        int right = array.length - 1;
        int i = 0;
        /*loop until left higher right*/
        while (left <= right) {
            int mid = (left + right) / 2;
            /*compare middle element with search value*/
            if (array[mid] == searchValue) {
                //show searching step
                if (check == true) {
                    System.out.print("Step " + ++i + "(middle element is " + array[mid] + " == " + searchValue + "): ");
                    //Loop use to accessed each element of array
                    for (int j = 0; j < array.length; j++) {
                        //compare each element in array with mid element
                        if (array[j] < array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.print("[" + array[mid] + "] ");
                    //compare each element in array with mid element
                    for (int j = 0; j < array.length; j++) {
                        //display from the after mid element to the last element
                        if (array[j] > array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                }
                return mid;
            } else if (array[mid] > searchValue) {
                if (check == true) {
                    System.out.print("Step " + ++i + "(middle element is " + array[mid] + " > " + searchValue + "): ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] < array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.print("[" + array[mid] + "] ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] > array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.println();
                }
                right = mid - 1;
            } else {
                if (check == true) {
                    System.out.print("Step " + ++i + "(middle element is " + array[mid] + " < " + searchValue + "): ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] < array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.print("[" + array[mid] + "] ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] > array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.println();
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    private static void displayIndex(int indexValue, int searchValue) {
        if (indexValue != -1) {
            System.out.println("\nFound " + searchValue + " at index: " + indexValue);
        } else if (indexValue == -1) {
            System.out.println("Can't found search value!!!");
        }
    }

}
