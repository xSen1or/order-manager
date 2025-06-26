package gr.huadit.interfaces;

import gr.huadit.Class.Client;

public interface DataManagement {
    void searchForProduct(int targetId);
    Client searchForClient(int userId);
    boolean findEmail(String target);
    void fetchAllProducts();
    void fetchAllClients();
}   
