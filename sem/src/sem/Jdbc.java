package sem;

import java.sql.*;

public class Jdbc {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect();

            Hospital pdt = new Hospital(50, "prakash", "959598874", "14D ram nagar,vadavalli,coimbatore-641022", 252);
            inserIntoDBData(pdt);

            selectFromDB();

            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void connect() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectFromDB() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Ad_no, Name, phone, Address, Room FROM details");

            while (resultSet.next()) {
                int Ad_no = resultSet.getInt("Ad_no");
                String name = resultSet.getString("Name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("Address");
                int room = resultSet.getInt("Room");

                System.out.println("Ad_no: " + Ad_no);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("Room: " + room);
                System.out.println("----------------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inserIntoDBData(Hospital newProduct) {
        try {
            String query = "INSERT INTO details (Ad_no, Name, phone, Address, Room) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, newProduct.getId());
                preparedStatement.setString(2, newProduct.getName());
                preparedStatement.setString(3, newProduct.getPhone());
                preparedStatement.setString(4, newProduct.getAddress());
                preparedStatement.setInt(5, newProduct.getRoom());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Product inserted successfully!");
                } else {
                    System.out.println("Failed to insert product.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
