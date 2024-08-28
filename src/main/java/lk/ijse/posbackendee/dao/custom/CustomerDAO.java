package lk.ijse.posbackendee.dao.custom;

import lk.ijse.posbackendee.dao.CrudDAO;
import lk.ijse.posbackendee.entity.Customer;

import java.sql.Connection;

public interface CustomerDAO extends CrudDAO<Customer,String>{
    boolean update(String customerId, Connection connection, Customer customer);
}
