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
class Rectangle extends Shape {
     private double length, Width; 
     
     public Rectangle(){
         
     }

    public Rectangle(double length, double Width) {
        this.length = length;
        this.Width = Width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return Width;
    }
     
     @Override
    public double getArea(){
         double area; 
         area = this.length * this.Width; 
         return area; 
    }
    
     @Override
    public double getPerimeter(){
        double perimeter; 
        perimeter = 2*(this.Width + this.length); 
        return  perimeter; 
    }
    
     @Override
    public void printResult(){
        System.out.println("-----Rectangle-----");
        System.out.println("Width: "+this.Width);
        System.out.println("Length: "+this.length);
        System.out.println("Area: "+this.getArea());
        System.out.println("Perimeter: "+this.getPerimeter());
    }
     
}

