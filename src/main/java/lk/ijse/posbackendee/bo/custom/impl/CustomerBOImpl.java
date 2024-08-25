package lk.ijse.posbackendee.bo.custom.impl;

import lk.ijse.posbackendee.bo.custom.CustomerBO;
import lk.ijse.posbackendee.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public boolean createCustomer(CustomerDto customerDto, Connection connection) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String C_id, Connection connection) {
        return false;
    }

    @Override
    public List<CustomerDto> getAllCustomer(Connection connection) throws SQLException {
        return null;
    }
}
