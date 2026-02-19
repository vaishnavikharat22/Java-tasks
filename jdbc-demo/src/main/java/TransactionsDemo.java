import java.sql.*;

public class TransactionsDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD ="student";

    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD)){
            System.out.println("Connected to the Databse!");

            conn.setAutoCommit(false);

            try {
                int orderId = insertOrder(conn, 101, "Alice01", 2000.0);

                insertOrderItem(conn, orderId, "Laptop01", 1, 2000.0);

                conn.commit();
                System.out.println("Transaction commited successfully");

            } catch (Exception e){
                e.printStackTrace();
                conn.rollback();
                System.out.println("Operation rollback successful");
            }
                finally {
                conn.setAutoCommit(true);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void insertOrderItem(Connection conn, int orderId, String productName, int quantity, double price) {
        String sql = "INSERT INTO order_items (order_id, product_name, quantity, price)" + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,orderId);
            pstmt.setString(2,productName);
            pstmt.setInt(3,quantity);
            pstmt.setDouble(4,price);

           // int x = 10 / 0;

            int rows = pstmt.executeUpdate();
            System.out.println("INSERT into order_items : " + rows);

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection conn, int customerId, String customerName, double price) {
        String sql = "INSERT INTO orders (user_id, customer_name, total_amount)" + "VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1,customerId);
            pstmt.setString(2,customerName);
            pstmt.setDouble(3,price);
            int rows = pstmt.executeUpdate();
            System.out.println("INSERT into orders: " + rows);

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if(rs.next()) {
                    int orderId = rs.getInt(1);
                    System.out.println("ORDER ID : " + orderId);
                    return orderId;
                }
                else {
                    throw new SQLException("Order ID not generated");
                }
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
