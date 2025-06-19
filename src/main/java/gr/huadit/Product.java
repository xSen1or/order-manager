package gr.huadit;
import java.util.Scanner;

public class Product {
    int productId; 
    int productAmountAvailable; 
    String productName; 
    String productCategory;
    
    public Product(int productId, int productAmountAvailable, String productName, String productCategory) {
        this.productId = productId;
        this.productName = productName; 
        this.productAmountAvailable = productAmountAvailable;
        this.productCategory = productCategory;
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public String findDeliveryAddress() {
        Scanner sc = new Scanner(System.in); 
        Database conn;
        System.out.println("Product ID: ");
        sc.nextInt(); 

        return "test";
    }

    public int getProductId() {
        return productId;
    }

    public int getProductAmountAvailable() {
        return productAmountAvailable;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
