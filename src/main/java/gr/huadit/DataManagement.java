package gr.huadit;

public interface DataManagement {
    public void searchForProduct(int targetId); 
    public void searchForClient(int userId);
    public void fetchAllProducts();
    public void fetchAllClients(); 
}   
