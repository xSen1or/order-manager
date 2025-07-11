package gr.huadit.Class;

import java.util.ArrayList;
import java.util.List;

public class EmailRequest {
    private String to;
    private String subject;
    private String body;

    public List<EmailRequest> emails = new ArrayList<EmailRequest>();

    public EmailRequest(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    };
    public EmailRequest(){};

    public void addEmail() {
        emails.add(this);
    }

    public List<EmailRequest> getEmails() {
        return emails;
    }

    public void popEmails() {
        emails.add(new EmailRequest("alice@example.com", "Welcome!", "Thanks for joining us."));
        emails.add(new EmailRequest("bob@example.com", "Reminder", "Don't forget our meeting tomorrow."));

    }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
}
