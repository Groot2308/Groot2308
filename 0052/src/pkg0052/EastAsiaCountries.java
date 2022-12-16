/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0052;

/**
 *
 * @author asus
 */
public class EastAsiaCountries extends Country {

    protected String countryTerrain;

    public EastAsiaCountries() {

    }

    public EastAsiaCountries(String countryCode,String countryName,float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n", this.countryCode,
                this.countryName, this.totalArea, this.countryTerrain);
    }
}
