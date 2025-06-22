package gr.huadit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Database database = new Database();
        database.connect();
//        database.fetchAllClients();
//        database.fetchAllProducts();
//        database.disconnect();
    }
}