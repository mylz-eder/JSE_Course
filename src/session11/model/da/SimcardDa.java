package session11.model.da;

import session11.model.entity.simcard.Simcard;
import session11.model.utils.JdbcProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SimcardDa implements AutoCloseable {
    private final Connection connection;

    private PreparedStatement preparedStatement;

    JdbcProvider jdbcProvider = new JdbcProvider();

    public SimcardDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Simcard simcard) throws SQLException {
        simcard.setId(jdbcProvider.getNextId("SIMCARD_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO SIMCARD VALUES (?,?,?,?,?,?)"
        );
        Date sqlDate = Date.valueOf(simcard.getPurchaseDate());

        preparedStatement.setInt(1,simcard.getId());
        preparedStatement.setString(2,simcard.getName());
        preparedStatement.setLong(3,simcard.getPhoneNumber());
        preparedStatement.setString(4, String.valueOf(simcard.getPlan()));
        preparedStatement.setString(5, String.valueOf(simcard.getCompany()));
        preparedStatement.setDate(6, sqlDate);
        preparedStatement.execute();
    }

    public void edit(Simcard simcard) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE SIMCARD SET NAME=?, PHONE_NUMBER=?, PLAN=?, COMPANY=? WHERE ID=?"
        );

        preparedStatement.setString(1,simcard.getName());
        preparedStatement.setLong(2,simcard.getPhoneNumber());
        preparedStatement.setString(3, String.valueOf(simcard.getPlan()));
        preparedStatement.setString(4, String.valueOf(simcard.getCompany()));
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM SIMCARD WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Simcard> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM SIMCARD ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Simcard> simcardList = new ArrayList<>();

        while (resultSet.next()) {
            Simcard simcard =
                    Simcard
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .phoneNumber(resultSet.getLong("PHONE_NUMBER"))
                            .plan(resultSet.getString("PLAN"))
                            .company(resultSet.getString("COMPANY"))
                            .purchaseDate(resultSet.getDate("PURCHASE_DATE").toLocalDate())
                            .build();
            simcardList.add(simcard);
        }
        return simcardList;
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
