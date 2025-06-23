package gr.huadit.interfaces;

import gr.huadit.Class.Client;

public interface DataManagement {
    public void searchForProduct(int targetId); 
    public Client searchForClient(int userId);
    public boolean findEmail(String target); 
    public void fetchAllProducts();
    public void fetchAllClients(); 
}   
