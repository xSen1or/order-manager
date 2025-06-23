package gr.huadit.Class;

public class Login extends Client {
    int userId; 
    String password;
    String email;
    Database conn = new Database();
    public Login(int userId, String password) {
        super(userId, password); 
        this.userId = userId;
        this.password = password;
    }

    public Client startLogin() {
        Client loginClient = conn.searchForClient(this.userId);
        if (loginClient == null) {
            System.out.println("Client ID Not Found.");
            return loginClient;
        } else {
            System.out.println("Login Succesfull ");
        }
        return null; 
    }
}
