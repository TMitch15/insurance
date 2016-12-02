
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author river
 */
public class insuranceDBTest {

    public static void main(String[] args) {
        final String QUERY = "select * from insurance";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/policies", "river", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("id") + ", "
                        + rs.getString("name") + ", "
                        + rs.getString("type") + ", "
                        + rs.getString("renewdate") + ", "   
                        + rs.getDouble("payment"));
            }
        } catch (SQLException ex) {
            System.out.println("Reetrieve SQLException: " + ex.getMessage());

        }
    }
}
