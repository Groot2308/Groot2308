/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0050;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
class Manager {

    public static getInput g = new getInput();

    void calculateEquation() {
        System.out.println("----- Calculate Equation -----");
        ArrayList<Double> odd = new ArrayList<>();
        ArrayList<Double> even = new ArrayList<>();
        ArrayList<Double> square = new ArrayList<>();
        double A = g.getDouble("Enter A: ");
        double B = g.getDouble("Enter B: ");
        double x;
        if (A == 0 && B == 0) {
            System.out.print("Solution: Vo so nghiem");
            System.out.println("Number is Odd:");
            System.out.println("Number is Even:" + A + ", " + B);
            System.out.println("Number is Square:" + A + ", " + B);
            return;
        } else if (A == 0 && B != 0) {
            System.out.println("Solution: Vo nghiem");
            if (checkOddNumber(A)) {odd.add(A);}
            if (checkOddNumber(B)) {odd.add(B);}
            if (checkEvenNumber(A)) {even.add(A);}
            if (checkEvenNumber(B)) {even.add(B);}
            if (checkSquareNumber(A)) {square.add(A);}
            if (checkSquareNumber(B)) {square.add(B);}
        } else {
            x = -B / A;
            System.out.printf("Solution: x = %.3f ", x);
            System.out.println();
            if (checkOddNumber(A)) {
                odd.add(A);
            }
            if (checkOddNumber(B)) {
                odd.add(B);
            }
            if (checkOddNumber(x)) {
                odd.add(x);
            }
            if (checkEvenNumber(A)) {
                even.add(A);
            }
            if (checkEvenNumber(B)) {
                even.add(B);
            }
            if (checkEvenNumber(x)) {
                even.add(x);
            }
            if (checkSquareNumber(A)) {
                square.add(A);
            }
            if (checkSquareNumber(B)) {
                square.add(B);
            }
            if (checkEvenNumber(x)) {
                even.add(x);
            }

        }
        System.out.print("Number is Odd:");
        for (int i = 0; i < odd.size(); i++) {
            if (checkOddNumber(odd.get(i))) {
                System.out.print(odd.get(i));
                if (i < odd.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.print("Number is Even:");
        for (int i = 0; i < even.size(); i++) {
            if (checkEvenNumber(even.get(i))) {
                System.out.print(even.get(i));
                if (i < even.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.print("Number is Square:");
        for (int i = 0; i < square.size(); i++) {
            if (checkSquareNumber(square.get(i))) {
                System.out.print(square.get(i));
                if (i < square.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    void calculateQuadraticEquation() {
        ArrayList<Double> odd = new ArrayList<>();
        ArrayList<Double> even = new ArrayList<>();
        ArrayList<Double> square = new ArrayList<>();
        double A = g.getDouble("Enter A: ");
        double B = g.getDouble("Enter B: ");
        double C = g.getDouble("Enter C: ");
        double delta = (B * B) - (4 * A * C);
        double x1 = 0, x2 = 0, x = 0;
        if (A == 0 && B == 0 && C == 0) {
            System.out.println("Solution: Vo so nghiem");
            System.out.println("Odd Number(s):");
            System.out.println("Number is Even:" + A + ", " + B + ", " + C);
            System.out.println("Number is Square:" + A + ", " + B + ", " + C);
            return;
        } else if (A == 0 && B != 0 && C != 0) {
            x = -C / B;
            System.out.println("Solution: x = " + x);
            if (checkOddNumber(A)) {
                odd.add(A);
            }
            if (checkOddNumber(B)) {
                odd.add(B);
            }
            if (checkOddNumber(C)) {
                odd.add(C);
            }
            if (checkOddNumber(x)) {
                odd.add(x);
            }
            if (checkEvenNumber(A)) {
                even.add(A);
            }
            if (checkEvenNumber(B)) {
                even.add(B);
            }
            if (checkEvenNumber(x)) {
                even.add(x);
            }
            if (checkEvenNumber(C)) {
                even.add(C);
            }
            if (checkSquareNumber(A)) {
                square.add(A);
            }
            if (checkSquareNumber(B)) {
                square.add(B);
            }
            if (checkSquareNumber(C)) {
                square.add(C);
            }
            if (checkSquareNumber(x)) {
                square.add(x);
            }
        } else if (A == 0 && B == 0 && C != 0) {
            System.out.println("Solution: Vo nghiem");
            if (checkOddNumber(A)) {
                odd.add(A);
            }
            if (checkOddNumber(B)) {
                odd.add(B);
            }
            if (checkOddNumber(C)) {
                odd.add(C);
            }
            if (checkEvenNumber(A)) {
                even.add(A);
            }
            if (checkEvenNumber(B)) {
                even.add(B);
            }
            if (checkEvenNumber(C)) {
                even.add(C);
            }
            if (checkSquareNumber(A)) {
                square.add(A);
            }
            if (checkSquareNumber(B)) {
                square.add(B);
            }
            if (checkSquareNumber(C)) {
                square.add(C);
            }
        } else {
            if (delta < 0) {
                System.out.println("the equation has no solution");
            }
            if (delta >= 0) {
                x1 = (-B + Math.sqrt(delta)) / (2 * A);
                x2 = (-B - Math.sqrt(delta)) / (2 * A);
                System.out.printf("Solution: x1 = %.3f and x2 = %.3f", x1, x2);
                System.out.println();
            }
            if (checkOddNumber(A)) {
                odd.add(A);
            }
            if (checkOddNumber(B)) {
                odd.add(B);
            }
            if (checkOddNumber(C)) {
                odd.add(C);
            }
            if (checkOddNumber(x1)) {
                odd.add(x1);
            }
            if (checkOddNumber(x2)) {
                odd.add(x2);
            }
            if (checkEvenNumber(A)) {
                even.add(A);
            }
            if (checkEvenNumber(B)) {
                even.add(B);
            }
            if (checkEvenNumber(C)) {
                even.add(C);
            }
            if (checkEvenNumber(x1)) {
                even.add(x1);
            }
            if (checkEvenNumber(x2)) {
                even.add(x2);
            }
            if (checkSquareNumber(A)) {
                square.add(A);
            }
            if (checkSquareNumber(B)) {
                square.add(B);
            }
            if (checkSquareNumber(C)) {
                square.add(C);
            }
            if (checkSquareNumber(x1)) {
                square.add(x1);
            }
            if (checkSquareNumber(x2)) {
                square.add(x2);
            }
        }
        System.out.print("Number is Odd:");
        for (int i = 0; i < odd.size(); i++) {
            if (checkOddNumber(odd.get(i))) {
                System.out.print(odd.get(i));
                if (i < odd.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.print("Number is Even:");
        for (int i = 0; i < even.size(); i++) {
            if (checkEvenNumber(even.get(i))) {
                System.out.print(even.get(i));
                if (i < even.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.print("Number is Square:");
        for (int i = 0; i < square.size(); i++) {
            if (checkSquareNumber(square.get(i))) {
                System.out.print(square.get(i));
                if (i < square.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    public boolean checkOddNumber(double n) {
        if (n % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkEvenNumber(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }

}
