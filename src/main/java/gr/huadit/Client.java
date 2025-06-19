package gr.huadit;

public class Client {
    private String username; 
    private String password;
    private String email;
    private int userId; 

    public Client(String username, String password, String email, int userId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userId = userId;
    }

    public Client(int clientId) {
        this.userId = clientId;
    }

    public void searchForClient(Database db) {
        
    }

    public void clientLogin() {

    }

    public void clientSignUp() {
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
