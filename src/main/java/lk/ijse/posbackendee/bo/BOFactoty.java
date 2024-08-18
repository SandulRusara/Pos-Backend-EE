package lk.ijse.posbackendee.bo;

import lk.ijse.posbackendee.bo.custom.impl.CustomerBOImpl;

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
            default:
                return null;
        }
    }
}
