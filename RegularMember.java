/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suncathyprogrammmingckpt2;
import java.util.*;
/**
 * Defines the the attributes and feature of a regular member of the book store
 * @author Cathy Sun
 */
public class RegularMember {

    private String firstName; //first name of member
    private String lastName; //last name of member
    private double moneySpent; //money spent of member
/**
 * 
 * @param firstName accepts a first name for a regular member
 * @param lastName accepts a last name for a premium member
 * @param moneySpent accepts an amount for the total money spent by the member at the store
 */
    public RegularMember(String firstName, String lastName, double moneySpent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneySpent = moneySpent;
    }

    public RegularMember() {

    }
/**
 * 
 * @return gets the value of first name
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * 
 * @return gets the value of the last name
 */
    public String getLastName() {
        return lastName;
    }
/**
 * 
 * @return gets the total money spent of the member
 */
    public double getMoneySpent() {
        return moneySpent;
    }
/**
 * 
 * @param firstName sets the parameter firstName as a first name
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * 
 * @param lastName sets parameter lastName as last name
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * 
 * @param moneySpent sets parameter moneySpent as moneySpent
 */
    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }
/**
 * Calculates the total amount spent on purchase based on amount of each product bought
 * @param numBooks number of books bought
 * @param numCds number of cds bought
 * @param numDvds number of dvds bought
 */
    public void totalSpending(int numBooks, int numCds, int numDvds) {
        System.out.println("Total spending since becoming a member: $" + moneySpent);
    }
/**
 * Adds the new amount of money spent to the current existent money spent
 * @param moneySpent money spent for current purchase
 */
    public void addMoneySpent(double moneySpent) {
        this.moneySpent += moneySpent;
    }
/**
 * Prints out the amount of each item that was bought and their individual total
 * @param numBooks number of books bought
 * @param numCds number of cds bought
 * @param numDvds number of dvds bought
 */
    public void receipt(int numBooks, int numCds, int numDvds) {

        System.out.println("Number of books: $12 x " + numBooks + " = $" + (12 * numBooks));
        System.out.println("Number of cds:   $9 x " + numCds + " = $" + (9 * numCds));
        System.out.println("Number of dvds:  $18 x " + numDvds + " = $" + (18 * numDvds));
        System.out.println("---------------------------------");

    }

}
