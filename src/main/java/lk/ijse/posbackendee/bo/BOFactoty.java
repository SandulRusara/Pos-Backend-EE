package lk.ijse.posbackendee.bo;

import lk.ijse.posbackendee.bo.custom.impl.CustomerBOImpl;
import lk.ijse.posbackendee.bo.custom.impl.ItemBOImpl;
import lk.ijse.posbackendee.bo.custom.impl.OrderBOImpl;

public class BOFactoty {
    private static BOFactoty boFactoty;

    private BOFactoty() {
    }
    public static BOFactoty getBoFactoty(){return (boFactoty==null)?boFactoty=new BOFactoty():boFactoty;}

    public enum BOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            default:
                return null;
        }
    }
}
