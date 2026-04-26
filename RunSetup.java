import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;
public class RunSetup {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            String sql = new String(Files.readAllBytes(Paths.get("setup_modified.sql")));
            String[] statements = sql.split(";");
            for (String s : statements) {
                s = s.trim();
                if (!s.isEmpty()) {
                    stmt.execute(s);
                }
            }
            System.out.println("SETUP_EXECUTED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
