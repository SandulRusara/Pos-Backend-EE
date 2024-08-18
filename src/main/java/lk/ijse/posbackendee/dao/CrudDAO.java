package lk.ijse.posbackendee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T, ID> extends SuperDAO{

    boolean save(Connection connection, T dto) throws SQLException;


}

