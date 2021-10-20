/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suncathyprogrammmingckpt2;
import java.util.*;
/**
 * Defines attributes and features of a premium member of the book store
 * @author Cathy Sun
 */
public class PremiumMember extends RegularMember {

    private String payMethod; // pay method of member
/**
 * 
 * @param fName accepts a first name for a premium member
 * @param lName accepts a last name for a premium member
 * @param moneySpent accepts an amount for the total money spent by the member at the store
 * @param payMethod accepts the type of method the premium member payed for their membership
 */
    public PremiumMember(String fName, String lName, double moneySpent, String payMethod) {
        super(fName, lName, moneySpent);
        this.payMethod = payMethod;
    }

    public PremiumMember() {

    }
/**
 * 
 * @return gets the payment method
 */
    public String getPayMethod() {
        return payMethod;
    }
/**
 * 
 * @param payMethod sets the parameter payMethod as payMethod
 */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
/**
 * Simulates payment of cash or card
 * @param method accepts a int that indicates the payment method
 */
    public void makePayment(int method) {
        Scanner sc = new Scanner(System.in);
        boolean status = false;
        while (status == false) {
            if (method == 1) {
                System.out.println("Please enter a 12 digit card number.");
                String card = sc.nextLine();
                if (card.length() == 12) {
                    System.out.println("Transaction successful! You are now a premium member");
                    status = true;
                } else {
                    System.out.println("Transaction failed. Please try again.");
                }
            }
            if (method == 2) {
                System.out.println("Please enter an amount");
                double cash = sc.nextDouble();
                if (cash > 3) {
                    double change = cash - 3;
                    System.out.println("Thank you, your change is $" + change + ". You are now a member");
                    status = true;
                }
                if (cash < 3) {
                    System.out.println("Error, the amount entered is not enough. Please try again");
                }
                if (cash == 3) {
                    System.out.println("Transaction successful! You are now a premium member");
                    status = true;
                }
            }
        }
    }

}
