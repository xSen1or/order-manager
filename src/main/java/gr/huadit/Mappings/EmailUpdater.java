package gr.huadit.Mappings;

import gr.huadit.Class.EmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmailUpdater {
    @PostMapping("/email-update")
    public ResponseEntity<List<EmailRequest>> emailUpdate() {
        EmailRequest emailRequest = new EmailRequest();
        List<EmailRequest> emails = emailRequest.getEmails();
        if (emails == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(emails);
    }
}
