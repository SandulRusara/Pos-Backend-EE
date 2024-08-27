package lk.ijse.posbackendee.bo.custom;

import lk.ijse.posback.bo.SuperBO;
import lk.ijse.posback.dto.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderBO extends SuperBO {
    boolean saveOrder(OrderDTO orderDTO, Connection connection) throws SQLException;

    List<OrderDTO> getAllOrder(Connection connection) throws SQLException;
}
