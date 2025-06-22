package gr.huadit;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Java backend!";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody Map<String, String> payload) {
        ContactHandler contactHandler = new ContactHandler();
        String email = payload.get("email");
        contactHandler.sendConfirmationEmail(email);
        System.out.println("Sending email to: " + email);
        return "Confirmation email sent to: " + email;
    }
}
