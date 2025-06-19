package gr.huadit;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.connect();
        database.fetchAllClients();
        database.fetchAllProducts();
        database.disconnect();
    }
}