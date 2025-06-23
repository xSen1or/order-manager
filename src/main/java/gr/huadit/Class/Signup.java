package gr.huadit.Class;

import java.util.*;


public class Signup extends Client {
    int userId;
    String password;
    String email;
    Database conn = new Database();

    public Signup(int userId, String password) {
        super(userId, password);
    }

    public void clientSignUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sign Up");
        String[] requirements = { "Username", "Password", "Email" };
        String[] values = new String[requirements.length];
        
        System.out.println("Please provide the following information: \n");
        for (int i = 0; i < requirements.length; i++) {
            System.out.println(requirements[i]);
            if (i == 2) {
                while (true) {
                    String email = sc.nextLine();
                    if (conn.findEmail(email)) {
                        System.out.println("Email Already exists.\n");
                    } else {
                        values[i] = email; 
                        break;
                    }
                }
            } else {
                values[i] = sc.nextLine();
            }
        }
        sc.close();
    }
}
