/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg105;

import java.util.Date;

/**
 *
 * @author asus
 */
class Products {

    private String ID;
    private String Name;
    private String Location;
    private double Price;
    private String ExpiryDate;
    private String DateOfManufacture;
    private String Category;
    private String Storekeeper;
    private String ReceiptDate;

    public Products() {

    }

    public Products(String ID, String Name, String Location, double Price, String ExpiryDate, String DateOfManufacture, String Category, String Storekeeper, String ReceiptDate) {
        this.ID = ID;
        this.Name = Name;
        this.Location = Location;
        this.Price = Price;
        this.ExpiryDate = ExpiryDate;
        this.DateOfManufacture = DateOfManufacture;
        this.Category = Category;
        this.Storekeeper = Storekeeper;
        this.ReceiptDate = ReceiptDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public String getDateOfManufacture() {
        return DateOfManufacture;
    }

    public void setDateOfManufacture(String DateOfManufacture) {
        this.DateOfManufacture = DateOfManufacture;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getStorekeeper() {
        return Storekeeper;
    }

    public void setStorekeeper(String Storekeeper) {
        this.Storekeeper = Storekeeper;
    }

    public String getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(String ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    public void display() {
        System.out.printf("%-3s%-15s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                "ID", "Name", "Location", "Price", "ExpiryDate", "DateOfManufacture", "Category", "Storekeeper", "ReceiptDate");
        System.out.printf("%-3s%-15s%-10s%-10.1f%-20s%-20s%-15s%-20s%-15s\n",
                ID, Name, Location, Price, ExpiryDate, DateOfManufacture, Category, Storekeeper, ReceiptDate);
    }

}
