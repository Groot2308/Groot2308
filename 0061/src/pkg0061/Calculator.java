/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0061;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Calculator {

    public static Scanner sc = new Scanner(System.in);

    public static double inputSide(String s) {
        String input;
        double side;
        do {
            System.out.println(s);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Not empty!! Input again :(");
                continue;
            }
            try {
                side = Double.parseDouble(input);
                if (side <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not String!! Input again");
            } catch (Exception exception) {
                System.out.println("Not less than 0!! Input again");
            }
        } while (true);
        return side;
    }

    public Rectangle creatRectangle() {
        System.out.println("=====Calculator Shape Program=====");
        double width = inputSide("Please input side width of Rectangle:");
        double length = inputSide("Please input side lenghth of Rectangle:");
        return new Rectangle(length, width); 
    }

    public Circle creatCircle() {
        double radius = inputSide("Please input radius of Circle:");
        return new Circle(radius);
    }

    public Triangle creatTriangle() {
        double a, b, c;
        do {
            try {
                a = inputSide("Please input side A of Triangle:");
                b = inputSide("Please input side B of Triangle:");
                c = inputSide("Please input side C of Triangle:");
                //check side triangle
                if (a + b < c || b + c < a || a + c < b) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not creat triangle!! Input side again");
            }
        } while (true);
        return new Triangle(a, b, c);
    }
    
    public void display(Rectangle rectangle, Circle circle, Triangle triangle){
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();     
    }
}
