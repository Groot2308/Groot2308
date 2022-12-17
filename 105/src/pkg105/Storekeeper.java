/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg105;

/**
 *
 * @author asus
 */
class Storekeeper {
    private String Name; 
    
    public Storekeeper(){
        
    }

    public Storekeeper(String Name) {
        this.Name = Name;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
