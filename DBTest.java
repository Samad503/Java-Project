import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM employees;")) {
            if (rs.next()) {
                System.out.println("EMPLOYEES_COUNT: " + rs.getInt(1));
            }
        } catch (Exception e) {
            System.err.println("QUERY_FAILED");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
