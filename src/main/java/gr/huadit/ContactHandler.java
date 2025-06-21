package gr.huadit;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import jakarta.mail.Session;
import jakarta.mail.PasswordAuthentication;

public class ContactHandler {
    Database conn;
    String sender = "it2024151@hua.gr";
    String senderPassword = "1312#"; 
    String host = "127.0.0.1";

    public void sendConfirmationEmail(String recipient) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true"); // εφόσον το έχεις ενεργοποιήσει
        props.put("mail.smtp.starttls.enable", "false"); // hMailServer δεν έχει TLS από default

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, senderPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject("Confirmation Email");
            message.setText("This is a confirmation email from your daddy.");

            Transport.send(message);
            System.out.println("Mail successfully sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
