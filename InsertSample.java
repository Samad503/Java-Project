import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class InsertSample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Samadkhan123@";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // Insert sample address
            String addrSql = "INSERT INTO addresses (street, cityID, stateID, zip, DOB, phone, emergency_contact, emergency_contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement addrStmt = conn.prepareStatement(addrSql, Statement.RETURN_GENERATED_KEYS);
            addrStmt.setString(1, "123 Main St");
            addrStmt.setInt(2, 1); // New York
            addrStmt.setInt(3, 11); // NY
            addrStmt.setString(4, "10001");
            addrStmt.setString(5, "1990-01-01");
            addrStmt.setString(6, "555-1234");
            addrStmt.setString(7, "Jane Doe");
            addrStmt.setString(8, "555-5678");
            addrStmt.executeUpdate();
            var keys = addrStmt.getGeneratedKeys();
            int addrId = 0;
            if (keys.next()) addrId = keys.getInt(1);
            
            // Insert sample employee
            String empSql = "INSERT INTO employees (Fname, Lname, email, HireDate, Salary, SSN, addressID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement empStmt = conn.prepareStatement(empSql);
            empStmt.setString(1, "John");
            empStmt.setString(2, "Doe");
            empStmt.setString(3, "john.doe@example.com");
            empStmt.setString(4, "2023-01-15");
            empStmt.setDouble(5, 50000.0);
            empStmt.setString(6, "123-45-6789");
            empStmt.setInt(7, addrId);
            empStmt.executeUpdate();
            
            System.out.println("SAMPLE_DATA_INSERTED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
