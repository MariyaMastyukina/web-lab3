import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

/**
 * @author Kir
 * Created on 17.10.2020
 */

public class DBController {
    private String dbUrl = "jdbc:oracle:thin:@localhost:4000:orbis";
    private String username = "s285600";
    private String password = "ooq660";

    public void connect(){
        try (Connection connection = getConnection(dbUrl, username, password)) {
            System.out.println("Connected");
            String query = "INSERT INTO TEST VALUES (4, 'Kirill')";
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
