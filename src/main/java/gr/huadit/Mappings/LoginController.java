package gr.huadit.Mappings;

import gr.huadit.Class.Client;
import gr.huadit.Class.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.lang.model.element.Element;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping("/login")
     public ResponseEntity<String> login(@RequestBody Map<String, String> payload) {
        Database conn = new Database();
        String username =  payload.get("username");
        String password = payload.get("password");
        Client curr = conn.searchForClient(Integer.parseInt(username));
        System.out.println(curr.getUserId());

        if(curr.getPassword().equals(password)){
            Client meClient = new Client(curr.getUsername(), curr.getPassword(), curr.getEmail(), curr.getUserId(), curr.getPhone());
            Gson gson = new Gson();
            try (FileWriter wr = new FileWriter("F:\\Github\\order-manager\\src\\main\\java\\gr\\huadit\\Storage\\storage.json")) {
                gson.toJson(meClient, wr);
                System.out.println("✅ Client saved to JSON file.");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return ResponseEntity.ok("ok");
        } else {
            System.out.printf("Invalid Username or Password");
            return ResponseEntity.badRequest().build();
        }
    }
}