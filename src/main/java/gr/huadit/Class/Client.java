package gr.huadit.Class;

public class Client {
    private String username; 
    private String password;
    private String email;
    private int userId; 
    private int phone;

    public Client(int userId, String password) {
        this.userId = userId; 
        this.password = password; 
    }

    public Client(String username, String password, String email, int userId, int phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userId = userId;
        this.phone = phone;
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

    public int getPhone() {
        return phone;
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
