package gr.huadit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("") // Allows frontend to access backend
public class RestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from your Java backend!";
    }

    @PostMapping("/email")
    public String sendEmail(@RequestParam String to) {
        // Example email sending logic
        return "Email sent to: " + to;
    }
}
