package lk.ijse.posbackendee.bo.custom;
import lk.ijse.posbackendee.bo.SuperBO;
import lk.ijse.posbackendee.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {

    boolean createItem(ItemDTO itemDTO, Connection connection) throws SQLException;

    boolean updateItem(String itemId,ItemDTO itemDTO, Connection connection) throws SQLException;

    boolean deleteItem(String itemId, Connection connection) throws SQLException;

    List<ItemDTO> getAllItems(Connection connection) throws SQLException;
}

