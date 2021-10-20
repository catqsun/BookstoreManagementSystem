/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suncathyprogrammmingckpt2;

/**
 *
 * @author Cathy Sun
 */
public class Product {

    private int price; //price of product
    private int inventory; //amount of product in inventory
    private int total; // total price of purchase
/**
 * 
 * @param price accepts value for price of product
 * @param inventory accepts a value for amount in inventory
 */
    public Product(int price, int inventory) {
        this.price = price;
        this.inventory = inventory;
    }

    public Product() {

    }
/**
 * 
 * @return gets the price of item
 */
    public int getPrice() {
        return price;
    }
/**
 * 
 * @return gets the inventory
 */
    public int getInventory() {
        return inventory;
    }
/**
 * Calculates the total price of all products bought
 * @param numBooks number of books
 * @param numCds number of cds
 * @param numDvds number of dvds
 * @return 
 */
    public int getTotal(int numBooks, int numCds, int numDvds) {
        this.total = (12 * numBooks) + (9 * numCds) + (18 * numDvds);
        return total;
    }
/**
 * 
 * @param price sets parameter price as price
 */
    public void setPrice(int price) {
        this.price = price;
    }
/**
 * 
 * @param inventory sets parameter inventory as the inventory
 */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
/**
 * Subtracts the amount sold from the current inventory
 * @param sold amount of product that was sold
 */
    public void subtractInventory(int sold) {
        this.inventory = this.inventory - sold;
    }
/**
 * Adds more products to the inventory
 * @param add amount of product added
 */
    public void addInventory(int add) {
        this.inventory = this.inventory + add;
    }
/**
 * sets the total
 * @param numBooks number of books bought
 * @param numCds number of cds bought
 * @param numDvds number of dvds bought
 */
    public void setTotal(int numBooks, int numCds, int numDvds) {
        this.total = (12 * numBooks) + (9 * numCds) + (18 * numDvds);
    }

}
