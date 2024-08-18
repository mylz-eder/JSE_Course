package session9.databseassign.DatabaseAdmin;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
@SuperBuilder
public class ConnectionMaker {
    private Connection connection;

    public void connection() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "internallogin",
                "internallogin1234"
        );
    }
}
