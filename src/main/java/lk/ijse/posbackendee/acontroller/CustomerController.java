package lk.ijse.posbackendee.acontroller;

import jakarta.servlet.http.HttpServlet;
import lk.ijse.posbackendee.bo.BOFactoty;
import lk.ijse.posbackendee.bo.custom.CustomerBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerController extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    CustomerBO customerBO = (CustomerBO) BOFactoty.getBoFactoty().getBO(BOFactoty.BOTypes.CUSTOMER);

}
