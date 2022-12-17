/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0053;

import java.util.Scanner;

/**
 *
 * @author asus
 */
class bubbleSort {

    getData g = new getData(); 
    public Scanner sc = new Scanner(System.in); 
    void bubbleSort(int choice, int[] arr) {
        if(choice == 2){
            System.out.println("----- Ascending ------");
            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr.length - i - 1; j++){
                    if(arr[j] > arr[j + 1]){
                        int temp = arr[j]; 
                        arr[j] = arr[j + 1]; 
                        arr[j+1] = temp; 
                    }
                }
            }
            for(int i = 0; i<arr.length; i++){
                System.out.print("["+arr[i]+"]");
                if(i<arr.length - 1){
                    System.out.print("->");
                }
            }
            System.out.println();
        }else if(choice == 3){
            System.out.println("----- Descending -----");
            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr.length - i - 1; j++){
                    if(arr[j] < arr[j + 1]){
                        int temp = arr[j]; 
                        arr[j] = arr[j + 1]; 
                        arr[j+1] = temp; 
                    }
                }
            }
            for(int i = 0; i<arr.length; i++){
                System.out.print("["+arr[i]+"]");
                if(i<arr.length - 1){
                    System.out.print("<-");
                }
            }
            System.out.println("");
        }
    }
}
