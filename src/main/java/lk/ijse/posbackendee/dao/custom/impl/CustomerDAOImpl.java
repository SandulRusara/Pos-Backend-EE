package lk.ijse.posbackendee.dao.custom.impl;

import lk.ijse.posbackendee.dao.SQLUtil;
import lk.ijse.posbackendee.dao.custom.CustomerDAO;
import lk.ijse.posbackendee.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String SAVE_QUERY = "INSERT INTO customer(C_id, name, address, contact) VALUES (?,?,?,?)";
    @Override
    public boolean save(Connection connection, Customer dto) throws SQLException {
        return SQLUtil.execute(connection,
                SAVE_QUERY,
                dto.getC_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        );
    }
}
