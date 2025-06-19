package gr.huadit;

import java.sql.*;

public class Database implements DataManagement {
    Connection conn = null;
    boolean Connected;

    private boolean databaseAvailability() {
        if (this.Connected && conn != null) {
            return true;
        } else {
            System.err.println("Unable to perform any database-related action once the connection is closed.");
        }
        return false;
    }


    // Search for Specific Product/Client
    public void searchForClient(int userId) {
        if (databaseAvailability()) {
            String query = "SELECT * FROM user_information WHERE userId = " + userId;
            Client targetClient = new Client(userId);
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int userID = rs.getInt("userId");
                    if (targetClient.getUserId() == userID) {
                        
                    }
                }
            } catch (SQLException e) {
                System.err.println("Unable to fetch data for client with id: " + userId);
            }
        }
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
                    System.out.printf("User ID: %d | Username: %s | Password: %s | Email: %s%n",
                            userId, username, password, email);
                }
            } catch (SQLException e) {
                System.err.println("Unable to fetch data from user_information: ");
                e.printStackTrace();
            }
        }
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1312");
            System.out.println("Connection established successfully.");
            this.Connected = true;
            // conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
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