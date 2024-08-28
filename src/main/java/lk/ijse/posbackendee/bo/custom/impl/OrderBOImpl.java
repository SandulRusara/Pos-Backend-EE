package lk.ijse.posbackendee.bo.custom.impl;


import lk.ijse.posbackendee.bo.custom.OrderBO;
import lk.ijse.posbackendee.dao.DAOFactory;
import lk.ijse.posbackendee.dao.custom.OrderDAO;
import lk.ijse.posbackendee.dto.OrderDTO;
import lk.ijse.posbackendee.dto.OrderDetailsDTO;
import lk.ijse.posbackendee.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public boolean saveOrder(OrderDTO orderDTO,Connection connection) throws SQLException {
        return orderDAO.save(connection, new Order(
                orderDTO.getOrderId(),
                orderDTO.getDate(),
                orderDTO.getDiscount(),
                orderDTO.getTotal(),
                orderDTO.getC_id()
        ));
    }

    @Override
    public List<OrderDTO> getAllOrder(Connection connection) throws SQLException {
        List<lk.ijse.posbackendee.entity.Order> orders = orderDAO.getAll(connection);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (lk.ijse.posbackendee.entity.Order order : orders) {
            orderDTOS.add(new OrderDTO(
                    order.getOrderId(),
                    order.getDate(),
                    order.getDiscount(),
                    order.getTotal(),
                    order.getC_id()
            ));
        }
        return  orderDTOS;
    }
}

