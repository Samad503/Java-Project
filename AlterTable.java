import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class AlterTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            stmt.execute("ALTER TABLE addresses MODIFY COLUMN street VARCHAR(255) NOT NULL;");
            stmt.execute("ALTER TABLE addresses MODIFY COLUMN cityID INT NOT NULL;");
            stmt.execute("ALTER TABLE addresses MODIFY COLUMN stateID INT NOT NULL;");
            stmt.execute("ALTER TABLE addresses MODIFY COLUMN zip VARCHAR(10) NOT NULL;");
            System.out.println("ADDRESSES_TABLE_ALTERED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
