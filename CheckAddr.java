import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CheckAddr {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("DESCRIBE addresses;")) {
            System.out.println("ADDRESSES_TABLE_STRUCTURE:");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + (rs.getString(3).equals("NO") ? "NOT NULL" : "NULL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
