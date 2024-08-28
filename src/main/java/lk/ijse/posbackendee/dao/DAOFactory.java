package lk.ijse.posbackendee.dao;

import lk.ijse.posbackendee.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.posbackendee.dao.custom.impl.ItemDAOImpl;
import lk.ijse.posbackendee.dao.custom.impl.OrderDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS
    }

    public SuperDAO getDAO(DAOTypes daoType){
        switch (daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            default:
                return null;
        }
    }
}

