package lk.ijse.posbackendee.bo.custom.impl;

import lk.ijse.posbackendee.bo.custom.CustomerBO;
import lk.ijse.posbackendee.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public boolean createCustomer(CustomerDto customerDto, Connection connection) {
        return false;
    }
}
