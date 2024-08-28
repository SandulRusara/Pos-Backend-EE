package lk.ijse.posbackendee.bo.custom;

import lk.ijse.posbackendee.bo.SuperBO;
import lk.ijse.posbackendee.dto.OrderDetailsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsBO extends SuperBO {
    List<OrderDetailsDTO> getOrderDetails(Connection connection) throws SQLException;

    boolean saveOrderDetails(List<OrderDetailsDTO> details, Connection connection) throws SQLException;
}

