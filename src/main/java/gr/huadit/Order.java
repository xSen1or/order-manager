package gr.huadit;

public class Order implements Deliverable {
    private Client client; 
    private Product product; 
    private String address; 

    public Order(Client client, Product product) {
        this.client = client;
        this.product = product;
    }

    public String findDeliveryAddress() { 
        return "test"; 
    }
}
