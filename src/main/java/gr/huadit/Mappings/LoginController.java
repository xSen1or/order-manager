package gr.huadit.Mappings;

import gr.huadit.Class.Client;
import gr.huadit.Class.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping("/login")
     public ResponseEntity<String> login(@RequestBody Map<String, String> payload) {
        Database conn = new Database();
        String username =  payload.get("username");
        String password = payload.get("password");
        Client curr = conn.searchForClient(Integer.parseInt(username));
        System.out.println(curr.getPassword());
        
        if(curr.getPassword().equals(password)){
            System.out.println("Correct Password");
            return ResponseEntity.ok("ok");
        } else {
            System.err.println("Incorrect Password");
            return ResponseEntity.badRequest().build();
        }
    }
}
