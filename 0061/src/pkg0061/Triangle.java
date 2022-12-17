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
class Triangle extends Shape{
    private double sideA, sideB, sideC; 
    
    public Triangle(){
        
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    @Override
    public double getArea(){
        double p = (this.sideA + this.sideB + this.sideC) / 2.0; 
        double area; 
        area = Math.sqrt(p * (p -  this.sideA) * (p - this.sideB) * (p - this.sideC)); 
        return area; 
    }
    
    @Override
    public double getPerimeter(){
        double perimeter; 
        perimeter = this.sideA + this.sideB + this.sideC; 
        return perimeter; 
    }
    
    @Override
    public void printResult(){
        System.out.println("-----Triangle-----");
        System.out.println("Side A: "+this.sideA);
        System.out.println("Side B: "+this.sideB);
        System.out.println("Side C: "+this.sideC);
        System.out.println("Area:"+this.getArea());
        System.out.println("Perimeter:"+this.getPerimeter());
    }
}
