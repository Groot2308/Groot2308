/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author asus
 */
public class Counter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Step 1: input String
        String input = getString("Enter your content:");
        //Step 2: Function count number letterts
        CounterLetter(input);
        //Step 3: Function count number characters
        CounterCharacters(input);

    }

    // Function check input String
    public static String getString(String s) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println(s);
            try {
                input = sc.nextLine().trim();
                //check input not empty
                if (input.isEmpty()) {
                    throw new Exception();
                }
                //check not letters
                if (input.matches("\\W+")) {
                    throw new Error();
                }else{
                    break;
                }
            } catch (Exception e) {
                System.out.println("Content not empty!!!");
            } catch (Error e) {
                System.out.println("Error format!!!");
            }
        } while (true);
        return input;
    }

    // Function count number 
    public static void CounterLetter(String Input) {
        HashMap<String, Integer> letters = new HashMap<>();
        StringTokenizer st = new StringTokenizer(Input);
        // Count letterrs
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            //check word the same
            if (letters.containsKey(word)) {
                letters.put(word, (letters.get(word)) + 1);
            } else {
                letters.put(word, 1); 
            }
        }
        System.out.println(letters);
    }

    public static void CounterCharacters(String Input) {
        HashMap<Character, Integer> characters = new HashMap<>();
        // Count Characters
        String s = Input.replace(" ", "");
        char[] ch = s.toCharArray();
        /*loop access from the first element to the last element in array*/
        for (char i = 0; i<ch.length; i++) {
            //check characters the same
            if (characters.containsKey(ch[i])) {
                characters.put(ch[i],(characters.get(ch[i])) + 1);
            } else {
                characters.put(ch[i], 1);
            }
        }
        System.out.println(characters);
    }
}

