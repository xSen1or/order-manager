package gr.huadit.Mappings;

import gr.huadit.Class.Client;
import gr.huadit.Class.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SignupController {
    @PostMapping("/createUser")
    public ResponseEntity<Client> createUser(@RequestBody Client ClientX) {
        Database conn = new Database();
        String username = ClientX.getUsername();
        String password = ClientX.getPassword();
        String email = ClientX.getEmail();
        int phoneNumber = ClientX.getPhone();

        if (!conn.searchForEmail(email)) {
            conn.appendClient(ClientX);
            System.out.println("Created user: " + username);
            return ResponseEntity.ok().body(ClientX);
        } else {
            System.out.println("User already exists");
            return ResponseEntity.badRequest().build();
        }
    }
}