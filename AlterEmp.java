import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class AlterEmp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            stmt.execute("ALTER TABLE employees MODIFY COLUMN empid INT AUTO_INCREMENT;");
            System.out.println("EMPLOYEES_TABLE_ALTERED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
