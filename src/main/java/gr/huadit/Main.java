package gr.huadit;

import gr.huadit.Class.Database;
import gr.huadit.Class.EmailRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.popEmails();
        System.out.println("✅ Application Started Successfully");
    }
}