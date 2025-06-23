package gr.huadit.Class;

import gr.huadit.Handlers.ContactHandler;
import gr.huadit.Handlers.InputHelper;

import java.util.Scanner;

public class ApplicationManager {
    Scanner sc = new Scanner(System.in);
    Database conn;
    InputHelper handler = new InputHelper();
    ContactHandler contact = new ContactHandler();

    public ApplicationManager() {};

    public void displayMenu() {
        System.out.println("====== Welcome to the Order System ======");
        System.out.println("1. Place an Order");
        System.out.println("2. Track Order");
        System.out.println("3. Cancel Order");
        System.out.println("4. View Order History");
        System.out.println("5. Exit");
        System.out.println("=========================================");
        System.out.print("Please select an option (1-5): ");
    }

    public void start() {
        System.out.println("Login Menu:\nUser ID:");
        String promt = sc.nextLine();
        int userID;
        while (true) {
            try {
                userID = Integer.parseInt(promt);
                if (handler.getValidInInput(promt)) break;
                else System.out.println("\nPlease provide a valid User ID\n");                
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println("\nPassword: ");
        String password = sc.nextLine(); 
        Login newClientLoginAttempt = new Login(userID, password);
        Client ClientX = newClientLoginAttempt.startLogin();
        if (ClientX == null) {
            
        } else {

        }
    }
}
