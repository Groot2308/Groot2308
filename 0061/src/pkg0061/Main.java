/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0061;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator m = new Calculator(); 
        //Step 1: Shape rectangle
        Rectangle rectangle = m.creatRectangle(); 
        //Step 2: Shape circle
        Circle circle = m.creatCircle(); 
        //Step 3: Shape triangle
        Triangle triangle = m.creatTriangle(); 
        //Step 4: display all shape
        m.display(rectangle, circle, triangle);
    }
}
