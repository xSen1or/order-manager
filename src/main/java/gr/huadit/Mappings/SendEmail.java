package gr.huadit.Mappings;

import gr.huadit.Class.EmailRequest;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
@RequestMapping("/api")
public class SendEmail {
    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest email) {
        final String username = "jakartaemailsender@gmail.com";
        final String password = "xzvnkpuphpyjbjaa";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Δημιουργία session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email.getTo())
            );
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            Transport.send(message);

            System.out.println("Email Sent Successfully\n Recipient: " + email.getTo() + "\n Subject: " + email.getSubject() + "\n Body: " + email.getBody());
            return ResponseEntity.ok().body("Email sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
