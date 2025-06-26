package gr.huadit.Handlers;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import gr.huadit.Class.Client;

public class InputHelper {
    
    public InputHelper() {

    }; 

    public boolean getValidInInput(String promt) {
        if (promt == null || promt.trim().isEmpty()) {
            return false;
        }
        try { 
            Double.parseDouble(promt);
            return true;
        } catch (NumberFormatException e) { 
            return false; 
        }
    } 
    public boolean getValidStringInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public Client retriveClientFromJSON() {
        Gson gson = new Gson();
        Client client = null;
        try (FileReader reader = new FileReader("F:\\Github\\order-manager\\src\\main\\java\\gr\\huadit\\Storage\\storage.json")) {
            client = gson.fromJson(reader, Client.class);
            System.out.println("UserId: " + client.getUserId());
            System.out.println("Username: " + client.getUsername());
            System.out.println("Password: " + client.getPassword());
            System.out.println("Email: " + client.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

}