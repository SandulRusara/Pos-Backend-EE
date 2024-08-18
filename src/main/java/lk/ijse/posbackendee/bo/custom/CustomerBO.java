package lk.ijse.posbackendee.bo.custom;

import lk.ijse.posbackendee.bo.SuperBO;
import lk.ijse.posbackendee.dto.CustomerDto;

import java.sql.Connection;

public interface CustomerBO extends SuperBO {
    boolean createCustomer(CustomerDto customerDto, Connection connection);
}
