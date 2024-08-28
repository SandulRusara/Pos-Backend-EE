package lk.ijse.posbackendee.bo.custom.impl;

import lk.ijse.posbackendee.bo.custom.CustomerBO;
import lk.ijse.posbackendee.dao.DAOFactory;
import lk.ijse.posbackendee.dao.custom.CustomerDAO;
import lk.ijse.posbackendee.dto.CustomerDto;
import lk.ijse.posbackendee.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean createCustomer(CustomerDto customerDto, Connection connection) throws SQLException {
        return customerDAO.save(connection, new Customer(
                customerDto.getC_id(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getContact()
        ));
    }

    @Override
    public boolean updateCustomer(String customerId,CustomerDto customerDto, Connection connection) throws SQLException {
        return customerDAO.update(customerId,connection, new Customer(
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getContact()
        ));
    }

    @Override
    public boolean deleteCustomer(String C_id, Connection connection) throws SQLException {
        return customerDAO.delete(connection,C_id);
    }


    @Override
    public List<CustomerDto> getAllCustomer(Connection connection) throws SQLException {
        return null;
    }
}
