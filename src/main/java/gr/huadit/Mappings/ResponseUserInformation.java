package gr.huadit.Mappings;

import gr.huadit.Class.Database;
import gr.huadit.Class.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResponseUserInformation {
    @PostMapping("/getUser")
    public ResponseEntity<Client> getUser(@RequestBody Map<String, String> payload) {
        String userId = payload.get("username");
        Database conn = new Database();
        Client target = conn.searchForClient(Integer.parseInt(userId));
        if (target != null && target.getPassword().equals(payload.get("password"))) {
            return ResponseEntity.ok(target);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}