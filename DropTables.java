import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DropTables {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0;");
            stmt.execute("DROP TABLE IF EXISTS payroll;");
            stmt.execute("DROP TABLE IF EXISTS employee_job_titles;");
            stmt.execute("DROP TABLE IF EXISTS job_titles;");
            stmt.execute("DROP TABLE IF EXISTS employees;");
            stmt.execute("DROP TABLE IF EXISTS addresses;");
            stmt.execute("DROP TABLE IF EXISTS cities;");
            stmt.execute("DROP TABLE IF EXISTS states;");
            stmt.execute("DROP TABLE IF EXISTS division;");
            stmt.execute("DROP TABLE IF EXISTS employee_division;");
            stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
            System.out.println("TABLES_DROPPED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
