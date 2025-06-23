package gr.huadit.Class;

import gr.huadit.interfaces.DataManagement;

import java.sql.*;

public class Database implements DataManagement {
    Connection conn;
    boolean Connected;

//    public Database getConn() {
//
//    }

    public Database() {
        this.Connected = true; 
        this.connect();
    }
    private boolean databaseAvailability() {
        if (this.Connected) {
            return true;
        } else {
            System.err.println("Unable to perform any database-related action once the connection is closed.");
        }
        return false;
    }

    // Search for Specific Product/Client
    public Client searchForClient(int userId) {
        if (databaseAvailability()) {
            String query = "SELECT * FROM user_information WHERE userId = " + userId;
            Client targetClient = new Client(userId);
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int userID = rs.getInt("userId");
                    if (targetClient.getUserId() == userID) {
                        String username = rs.getString("username");
                        String password = rs.getString("userPassword");
                        String email = rs.getString("userEmail");
                        targetClient.setEmail(email);
                        targetClient.setPassword(password);
                        targetClient.setUserId(userID);
                        targetClient.setUsername(username);
                        return targetClient;
                    }
                }
            } catch (SQLException e) {
                System.err.println("Unable to fetch data for client with id: " + userId);
                System.err.println(e.getMessage());
                return null;
            }
        }  else {
            System.err.println("Unable to fetch data from database. Please check Database Status\n");
            System.out.println(databaseAvailability() ? "Available" : "Not Available");
        }
        return null;
    }

    public void searchForProduct(int targetId) {
        if (databaseAvailability()) {
            Product keyProduct = new Product(targetId);
            String query = "SELECT * FROM product_information WHERE productId = " + targetId;
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int productId = rs.getInt("productId");
                    if (keyProduct.getProductId() == productId) {
                        String productName = rs.getString("productName");
                        int productAmountAvailable = rs.getInt("productAmountAvailable");
                        String productCategory = rs.getString("productCategory");
                        System.out.printf(
                                "Product ID: %d | Product Name: %s | Stock Available: %d | Product Category: %s%n",
                                productId, productName, productAmountAvailable, productCategory);
                    }
                }
            } catch (SQLException e) {

            }
        }
    }

    // Fetch All Products/Clients
    public void fetchAllProducts() {
        if (databaseAvailability()) {

            String query = "SELECT * FROM product_information";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int productId = rs.getInt("productId");
                    String productName = rs.getString("productName");
                    int productAmountAvailable = rs.getInt("productAmountAvailable");
                    String productCategory = rs.getString("productCategory");
                    System.out.printf(
                            "Product ID: %d | Product Name: %s | Stock Available: %d | Product Category: %s%n",
                            productId, productName, productAmountAvailable, productCategory);

                }
            } catch (SQLException e) {
                System.err.println("Unable to fetch data from product_information");
                e.printStackTrace();
            } catch (NullPointerException e) {
            }
        }
    }

    public void fetchAllClients() {
        if (databaseAvailability()) {
            String query = "SELECT * FROM user_information";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String username = rs.getString("username");
                    int userId = rs.getInt("userId");
                    String password = rs.getString("userPassword");
                    String email = rs.getString("userEmail");
                    System.out.println("========= CLIENTS LIST =========");
                    System.out.printf("User ID: %d | Username: %s | Password: %s | Email: %s%n",
                            userId, username, password, email);
                }
            } catch (SQLException e) {
                System.err.println("Unable to fetch data from user_information: ");
                e.printStackTrace();
            }
        } else {
            System.out.println("Unable to fetch clients information. Check database status");
        }
    }

    public boolean findEmail(String target) { 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM users_information WHERE email = " + target);
            while(rs.next()) {
                if (target.equalsIgnoreCase(rs.getString("userMail"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Database Status: " + e.getSQLState() + "\nUnable to fetch information from database\n" + e.getMessage());
        }
        return false; 
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1312");
            System.out.println("Connection established successfully.");
            this.Connected = true;
        } catch (SQLException e) {
            System.out.println("Connection failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void disconnect() {
        if (conn != null) {
            try {
                this.Connected = false;
                conn.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("Failed to close connection.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No connection to close.");
        }
    }
}