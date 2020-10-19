import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

/**
 * @author Kir
 * Created on 19.10.2020
 */

public class DataBaseController {
    private String dbUrl = "jdbc:oracle:thin:@localhost:4000:orbis";
    private String username = "s285600";
    private String password = "ooq660";

    public void connect(){
        try (Connection connection = getConnection(dbUrl, username, password)) {
            System.out.println("Connected");
            String query = "INSERT INTO TEST VALUES (5, 'Kirill')";
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
