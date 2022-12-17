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
class Circle extends Shape{
    private double radius; 
    
    public Circle(){
        
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea(){
       double area; 
       area = Math.PI*(this.radius*this.radius); 
       return area; 
    }
    
    @Override
    public double getPerimeter(){
        double perimeter; 
        perimeter = Math.PI*(this.radius * 2); 
        return perimeter; 
    } 
    
    @Override
    public void printResult(){
        System.out.println("-----Circle-----");
        System.out.println("Radius: "+this.radius);
        System.out.println("Area:"+this.getArea());
        System.out.println("Perimeter:"+this.getPerimeter());
    }
}
