package lk.ijse.posbackendee.dao.custom.impl;

import lk.ijse.posbackendee.dao.SQLUtil;
import lk.ijse.posbackendee.dao.custom.CustomerDAO;
import lk.ijse.posbackendee.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String GET_QUERY = "SELECT * FROM customer";
    private static final String SAVE_QUERY = "INSERT INTO customer(c_id, name, address, contact) VALUES (?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE customer SET name = ?, address = ?, contact = ? WHERE customer_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM customer WHERE customer_id = ?";

    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        ResultSet rs = SQLUtil.execute(connection, GET_QUERY);
        List<Customer> customers = new ArrayList<>();
        while (rs.next()){
            customers.add(new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            ));
        }
        return customers;
    }

    @Override
    public boolean save(Connection connection, Customer customer) throws SQLException {
        try {
            var ps = connection.prepareStatement(SAVE_QUERY);
            ps.setString(1, customer.getC_id());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getContact());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
}
    }

    @Override
    public boolean update(Connection connection, Customer dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(String customerId,Connection connection, Customer customer)  {
        try {
            var ps = connection.prepareStatement(UPDATE_QUERY);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setInt(3, Integer.parseInt(String.valueOf(customer.getContact())));
            ps.setString(4,  customerId);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating customer with ID: " + customerId, e);
        }
    }


    @Override
    public boolean delete(Connection connection, String c_id) throws SQLException {
        try {
            var ps = connection.prepareStatement(DELETE_QUERY);
            ps.setString(1, c_id);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
