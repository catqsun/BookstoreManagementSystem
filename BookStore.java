/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suncathyprogrammmingckpt2;
import java.util.*;
/**
 * Test harness to run bookstore management system
 * @author Cathy Sun
 */
public class BookStore {

    /** runs bookstore
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Product purchase = new Product();
        ArrayList<RegularMember> regular = new ArrayList(); // arraylist of all regular members of bookstore
        ArrayList<PremiumMember> premium = new ArrayList(); // arraylist of all premium members of bookstore
        RegularMember current = null;
        PremiumMember pCurrent = null;

        PremiumMember payment = new PremiumMember();
        RegularMember receipt = new RegularMember();

        regular.add(new RegularMember("Cathy", "Sun", 0));
        regular.add(new RegularMember("Bacon", "Eggs", 10));
        premium.add(new PremiumMember("Jongdae", "Kim", 0, "cash"));
        premium.add(new PremiumMember("Krispy", "Kreme", 50, "card"));
        premium.add(new PremiumMember("Emily", "Theobald", 48, "card"));

        Product books = new Books(12, 300);
        Product cds = new Cds(9, 250);
        Product dvds = new Dvds(18, 200);

        boolean open = true;
        while (open == true) {

            // Prints the action options at the bookstore
            System.out.println("❤•❤•❤•❤•❤• Welcome to the Cathy's Bookstore! •❤•❤•❤•❤•❤");
            System.out.println(" ");
            System.out.println("Please select one of the following actions:");
            System.out.println("\t 1. Make a purchase");
            System.out.println("\t 2. Become a regular member");
            System.out.println("\t 3. Become a premium member");
            System.out.println("");
            System.out.println("Employee only actions:");
            System.out.println("\t 4. Manage Inventory");
            System.out.println("\t 5. Check member database");

            int num = sc.nextInt();

            boolean validMember = false;
            boolean pMember = false;
            String firstName = null;
            String lastName = null;
            String fName = null;
            String lName = null;
            
            // Cases for all actions possible
            switch (num) {
                case 1: // makes a purchase

                    while (validMember == false) {

                        System.out.println("Are you a member? (Y/N)");
                        char letter = sc.next().charAt(0);
                        if (letter == 'N' || letter == 'n') { // if customer isn't a member
                            System.out.println("Would you like to become a member? (Y/N)");
                            letter = sc.next().charAt(0);
                            if (letter == 'Y' || letter == 'y') { // if customer is a member
                                System.out.println("Would you like to be a regular or premium member?");
                                System.out.println("Regular members are free and premium members have a monthly membership fee of only $3 a month!");
                                System.out.println("\t 1. Regular Member");
                                System.out.println("\t 2. Premium Member");
                                num = sc.nextInt();
                                switch (num) {
                                    case 1: // creates a new premium member
                                        System.out.println("Enter your first name?");
                                        sc.nextLine();
                                        firstName = sc.nextLine();
                                        System.out.println("Enter your last name?");
                                        lastName = sc.nextLine();
                                        RegularMember newMem = new RegularMember(firstName, lastName, 0); // adds regular member
                                        regular.add(newMem);
                                        current = newMem;
                                        System.out.println("Registration Complete! There are no extra fees. You are now a member");
                                        break;
                                    case 2: // creates a premium member
                                        sc.nextLine();
                                        System.out.println("Enter your first name?");
                                        fName = sc.nextLine();
                                        System.out.println("Enter your last name?");
                                        lName = sc.nextLine();
                                        PremiumMember newPMem = new PremiumMember(fName, lName, 0, null); // adds premium member
                                        premium.add(newPMem);
                                        current = newPMem;
                                        pCurrent = newPMem;
                                        pMember = true;
                                        System.out.println("Premium Members pay a fee of $3 per month. How would you like to pay?");
                                        System.out.println("\t 1. Credit/Debit Card");
                                        System.out.println("\t 2. Cash");
                                        int method = sc.nextInt();
                                        payment.makePayment(method);
                                        if (method == 1) {
                                            String pay = "card";
                                            pCurrent.setPayMethod(pay);
                                        }
                                        if (method == 2) {
                                            String pay = "cash";
                                            pCurrent.setPayMethod(pay);
                                        }
                                        break;
                                }
                                System.out.println("Now let us proceed with your purchase!");
                                validMember = true;
                            }
                            // if customer doesnt want to become a member
                            if (letter == 'N' || letter == 'n') {
                                System.out.println("That's fine, let's get you checked out!");
                                break;

                            }
                        } else if (letter == 'Y' || letter == 'y') { // if customer is a member
                            System.out.println("Are you a regular or premium member?");
                            System.out.println("\t 1. Regular Member");
                            System.out.println("\t 2. Premium Member");
                            num = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter your first name?");
                            firstName = sc.nextLine();
                            System.out.println("Enter your last name?");
                            lastName = sc.nextLine();

                            if (num == 1) { // itterates through array and checks to make sure regular member exists
                                for (int i = 0; i < regular.size(); i++) {
                                    if (firstName.equals(regular.get(i).getFirstName()) && lastName.equals(regular.get(i).getLastName())) {
                                        current = regular.get(i);
                                        validMember = true;
                                        break;
                                    } else if (i == regular.size() - 1) {
                                        System.out.println("Error, you are not a member.");
                                    }
                                }
                            }
                            if (num == 2) { // itterates through array and checks to make sure premium member exists
                                for (int i = 0; i < premium.size(); i++) {
                                    if (firstName.equals(premium.get(i).getFirstName()) && lastName.equals(premium.get(i).getLastName())) {
                                        current = premium.get(i);
                                        validMember = true;
                                        pMember = true;
                                        break;
                                    } else if (i == premium.size() - 1) {
                                        System.out.println("Error, you are not a member.");
                                    }
                                }
                            }
                        }
                    }
                    // Prints questions to get amount of items bought
                    System.out.println("How many books do you want?");
                    int numBooks = sc.nextInt();
                    System.out.println("How many CD's do you want?");
                    int numCds = sc.nextInt();
                    System.out.println("How many DVD's do you want?");
                    int numDvds = sc.nextInt();
                    sc.nextLine();
                    double spent = purchase.getTotal(numBooks, numCds, numDvds);
                    System.out.println(" ");
                    System.out.println("❤•❤•❤•❤•❤• Cathy's Bookstore •❤•❤•❤•❤•❤"); // prints the summary of purchase
                    if (validMember == true) { // if member, add a discount to purchase
                        System.out.println(" ");
                        System.out.println("Regular members receive a 5% discount on all purchases and premium members recieve a 10% discount!");
                        System.out.println(" ");
                        spent = spent*0.95;
                        if (pMember == true){
                            spent = spent*0.9;
                        }
                        current.addMoneySpent(spent);
                        
                    }
                    receipt.receipt(numBooks, numCds, numDvds);
                    if (validMember == true) {
                        System.out.println("Total before discount: $" + purchase.getTotal(numBooks, numCds, numDvds));
                        System.out.println(" ");
                        System.out.println("After discount:");
                    }
                    System.out.println("Your total today is: $" + spent);
                    if (validMember == true) {
                        current.totalSpending(numBooks, numCds, numDvds);
                    }
                    System.out.println(" ");
                    System.out.println("Thank you for shopping at Cathy's Bookstore! Have a wonderful day and we hope to see you soon!");
                    System.out.println(" ");
                    books.subtractInventory(numBooks);
                    cds.subtractInventory(numCds);
                    dvds.subtractInventory(numDvds);

                    break;

                case 2: // creates a new regular member
                    sc.nextLine();
                    System.out.println("Enter your first name?");
                    firstName = sc.nextLine();
                    System.out.println("Enter your last name?");
                    lastName = sc.nextLine();
                    RegularMember newMem = new RegularMember(firstName, lastName, 0); 
                    regular.add(newMem); //adds new member to array list
                    current = newMem;
                    System.out.println("Registration Complete! There are no extra fees. You are now a member");
                    break;
                case 3: // creates a new premium member
                    sc.nextLine();
                    System.out.println("Enter your first name?");
                    fName = sc.nextLine();
                    System.out.println("Enter your last name?");
                    lName = sc.nextLine();
                    PremiumMember newPMem = new PremiumMember(fName, lName, 0, null);
                    premium.add(newPMem); // adds new member to array list
                    current = newPMem;
                    pCurrent = newPMem;
                    System.out.println("Premium Members pay a fee of $3 per month. How would you like to pay?"); //simulate payment
                    System.out.println("\t 1. Credit/Debit Card");
                    System.out.println("\t 2. Cash");
                    int method = sc.nextInt();
                    payment.makePayment(method);
                    if (method == 1) {
                        String pay = "card";
                        pCurrent.setPayMethod(pay);
                    }
                    if (method == 2) {
                        String pay = "cash";
                        pCurrent.setPayMethod(pay);
                    }
                    break;
                case 4: // shows inventory and also adds inventory
                    System.out.println("❤•❤•❤•❤•❤• Inventory •❤•❤•❤•❤•❤");
                    System.out.println(" ");
                    System.out.println(books.getInventory() + " books left in stock");
                    System.out.println(cds.getInventory() + " cds left in stock");
                    System.out.println(dvds.getInventory() + " dvds left in stock");
                    System.out.println(" ");
                    System.out.println("Would you like to add more products to the inventory?");
                    char letter = sc.next().charAt(0);
                    if (letter == 'Y' || letter == 'y') {
                        System.out.println("How many books would you like to add to stock?");
                        numBooks = sc.nextInt();
                        System.out.println("How many cds would you like to add to stock?");
                        numCds = sc.nextInt();
                        System.out.println("How many dvds would you like to add to stock?");
                        numDvds = sc.nextInt();
                        books.addInventory(numBooks);
                        cds.addInventory(numCds);
                        dvds.addInventory(numDvds);
                        System.out.println(" ");
                        System.out.println("❤•❤•❤•❤•❤• Updated Inventory •❤•❤•❤•❤•❤");
                        System.out.println(" ");
                        System.out.println(books.getInventory() + " books left in stock");
                        System.out.println(cds.getInventory() + " cds left in stock");
                        System.out.println(dvds.getInventory() + " dvds left in stock");
                    }
                    break;
                case 5: // prints all members in each array list
                    System.out.println(" ");
                    System.out.println("❤•❤•❤•❤•❤• Cathy's Bookstore Member Database •❤•❤•❤•❤•❤");
                    System.out.println("-------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println("***** Regular Members *****");
                    System.out.println(" ");
                    for (int i = 0; i < regular.size(); i++) {
                        System.out.println(i + 1 + ". " + regular.get(i).getFirstName() + " " + regular.get(i).getLastName());
                        System.out.println("\t Total money spent: $" + regular.get(i).getMoneySpent());
                    }
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println("***** Premium Members *****");
                    System.out.println(" ");
                    for (int i = 0; i < premium.size(); i++) {
                        System.out.println(i + 1 + ". " + premium.get(i).getFirstName() + " " + premium.get(i).getLastName());
                        System.out.println("\t Total money spent: $" + premium.get(i).getMoneySpent());
                        System.out.println("\t Membership payment method: " + premium.get(i).getPayMethod());
                    }
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, or 3");
                    break;
            }
            System.out.println(" ");
            System.out.println("\t 1. Return to main menu"); // returns to main menu
            System.out.println("\t 2. Close the store"); // ends program
            int status = sc.nextInt();
            if (status == 1) {
                open = true;
            }
            if (status == 2) {
                open = false;
                System.out.println("The bookstore is now closed!");
            }
        }

    }
}
