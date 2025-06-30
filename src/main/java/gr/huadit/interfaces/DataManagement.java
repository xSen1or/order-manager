package gr.huadit.interfaces;

import gr.huadit.Class.Client;

public interface DataManagement {
    void searchForProduct(int targetId);
    Client searchForClient(int userId);
    void fetchAllProducts();
    void fetchAllClients();
    void appendClient(Client client);
    boolean searchForEmail(String target);
}
