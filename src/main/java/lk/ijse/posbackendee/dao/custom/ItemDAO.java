package lk.ijse.posbackendee.dao.custom;

import lk.ijse.posback.dao.CrudDAO;
import lk.ijse.posback.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item, String> {
    Item get(Connection connection, String itemId) throws SQLException;
}
