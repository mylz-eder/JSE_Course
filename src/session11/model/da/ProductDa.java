package session11.model.da;

import session11.model.entity.Product;
import session11.model.utils.JdbcProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDa implements AutoCloseable {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    JdbcProvider jdbcProvider = new JdbcProvider();


    public ProductDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Product product) throws SQLException {
        product.setId(jdbcProvider.getNextId("PRODUCT_SQL"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUCT VALUES(?,?,?,?,?)"
        );
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setString(3, String.valueOf(product.getBrand()));
        preparedStatement.setInt(4,  product.getCount());
        preparedStatement.setInt(5, product.getPrice());
        preparedStatement.execute();
    }

    public void edit(Product product) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE Product SET NAME=?, BRAND =?, COUNT=?, PRICE=?  WHERE ID=?"
        );
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getBrand().name());
        preparedStatement.setInt(3, product.getCount());
        preparedStatement.setInt(4, product.getPrice());
        preparedStatement.setInt(5, product.getId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PRODUCT WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Product> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> personList = new ArrayList<>();

        while (resultSet.next()) {
            Product product =
                    Product
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .build();
            personList.add(product);
        }
        return personList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}

