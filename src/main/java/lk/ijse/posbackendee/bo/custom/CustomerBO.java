package lk.ijse.posbackendee.bo.custom;

import lk.ijse.posbackendee.bo.SuperBO;
import lk.ijse.posbackendee.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean createCustomer(CustomerDto customerDto, Connection connection)throws SQLException;
    boolean updateCustomer(CustomerDto customerDto,Connection connection) throws SQLException;
    boolean deleteCustomer(String C_id,Connection connection);
    List<CustomerDto> getAllCustomer(Connection connection)throws SQLException;
}
