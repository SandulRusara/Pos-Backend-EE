package lk.ijse.posbackendee.dao.custom.impl;
import lk.ijse.posbackendee.dao.SQLUtil;
import lk.ijse.posbackendee.dao.custom.ItemDAO;
import lk.ijse.posbackendee.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private static final String GET_QUERY = "SELECT * FROM item";
    private static final String SAVE_QUERY = "INSERT INTO item(itemId, description, unitPrice, qty) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE item SET description = ?, unitPrice = ?, qty = ? WHERE itemId = ?";
    private static final String DELETE_QUERY = "DELETE FROM item WHERE itemId = ?";
    private static final String SELECT_QUERY = "SELECT * FROM item WHERE item_id = ?";

    @Override
    public List<Item> getAll(Connection connection) throws SQLException {
        ResultSet rs = SQLUtil.execute(connection, GET_QUERY);
        List<Item> items = new ArrayList<>();

        while (rs.next()){
            items.add(new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getInt(4)
            ));
        }
        return items;
    }

    @Override
    public Item get(Connection connection, String itemId) throws SQLException {
        return null;
    }

    @Override
    public boolean update(String itemId, Connection connection, Item item) throws SQLException {
        try {
            var ps = connection.prepareStatement(UPDATE_QUERY);
            ps.setString(1, item.getDescription());
            ps.setString(2, String.valueOf(item.getUnitPrice()));
            ps.setInt(3, Integer.parseInt(String.valueOf(item.getQty())));
            ps.setString(4,  itemId);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating customer with ID: " + itemId, e);
        }
    }

    @Override
    public boolean save(Connection connection, Item item) {
        try {
            var ps = connection.prepareStatement(SAVE_QUERY);
            ps.setString(1, item.getItemId());
            ps.setString(2, item.getDescription());
            ps.setString(3, String.valueOf(item.getUnitPrice()));
            ps.setInt(4, item.getQty());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    /*@Override
    public boolean update(String itemId, Connection connection, Item dto) throws SQLException {
        return SQLUtil.execute(connection,
                UPDATE_QUERY,
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQty(),
                dto.getItemId()
        );
    }

    @Override
    public boolean delete(Connection connection, String s) throws SQLException {
        return SQLUtil.execute(connection, DELETE_QUERY, s);
    }

    @Override
    public Item get(Connection connection, String itemId) throws SQLException {
        ResultSet rs = SQLUtil.execute(connection, SELECT_QUERY, itemId);

        if (rs.next()){
            return new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getInt(4)
            );
        }
        return null;
    }
    }*/
    }

    @Override
    public boolean update(Connection connection, Item dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String itemId) throws SQLException {
        try {
            var ps = connection.prepareStatement(DELETE_QUERY);
            ps.setString(1, itemId);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

