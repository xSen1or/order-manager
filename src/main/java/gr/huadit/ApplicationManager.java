package gr.huadit;
import java.util.Scanner;

public class ApplicationManager {
    Scanner sc = new Scanner(System.in);
    Database conn; 
    InputHelper handler = new InputHelper();


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
        while(!handler.getValidInInput(sc.nextLine())) {
            System.out.println("\nPlease provide a Valid ID.\n");
            System.out.println("Login Menu:\nUser ID:");
        }
        

        
    }
}
