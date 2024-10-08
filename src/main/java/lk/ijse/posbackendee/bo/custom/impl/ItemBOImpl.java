package lk.ijse.posbackendee.bo.custom.impl;

import lk.ijse.posbackendee.bo.custom.ItemBO;
import lk.ijse.posbackendee.dao.DAOFactory;
import lk.ijse.posbackendee.dao.custom.ItemDAO;
import lk.ijse.posbackendee.dto.ItemDTO;
import lk.ijse.posbackendee.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean createItem(ItemDTO itemDTO, Connection connection) throws SQLException {
        return itemDAO.save(connection,new Item(
                itemDTO.getItemId(),
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQty()
        ));
    }

    @Override
    public boolean updateItem(String itemId,ItemDTO itemDTO, Connection connection) throws SQLException {
        return itemDAO.update(itemId,connection, new Item(

                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQty()
        ));
    }

    @Override
    public boolean deleteItem(String itemId, Connection connection) throws SQLException {
        return itemDAO.delete(connection, itemId);
    }

    @Override
    public List<ItemDTO> getAllItems(Connection connection) throws SQLException {
        List<Item> items = itemDAO.getAll(connection);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(new ItemDTO(
                    item.getItemId(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQty()
            ));
        }
        return itemDTOS;
    }
}

