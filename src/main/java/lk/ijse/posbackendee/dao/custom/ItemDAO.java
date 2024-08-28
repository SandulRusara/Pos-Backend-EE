package lk.ijse.posbackendee.dao.custom;
import lk.ijse.posbackendee.dao.CrudDAO;
import lk.ijse.posbackendee.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item, String> {
    Item get(Connection connection, String itemId) throws SQLException;
    boolean update(String itemId, Connection connection, Item item) throws SQLException;
    boolean save(Connection connection,Item item);
}
