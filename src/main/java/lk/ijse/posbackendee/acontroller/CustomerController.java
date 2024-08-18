package lk.ijse.posbackendee.acontroller;

import jakarta.json.JsonException;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackendee.bo.BOFactoty;
import lk.ijse.posbackendee.bo.custom.CustomerBO;
import lk.ijse.posbackendee.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer",loadOnStartup = 2)
public class CustomerController extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    CustomerBO customerBO = (CustomerBO) BOFactoty.getBoFactoty().getBO(BOFactoty.BOTypes.CUSTOMER);
    Jsonb jsonb=JsonbBuilder.create();
    private Connection connection;

//        @Override
//    public void init() {
//        logger.info("Init the customer servlet");
//        try {
//            InitialContext context = new InitialContext();
//            DataSource pool = (DataSource) context.lookup("java:comp/env/jdbc/pos_system");
//            this.connection=pool.getConnection();
//            logger.info("Obtained new connection (" + context + ") to customer servlet");
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")){
            CustomerDto customerDTO = jsonb.fromJson(req.getReader(), CustomerDto.class);
            System.out.println(customerDTO);
            if(customerBO.createCustomer(customerDTO, connection)){
                logger.info("Customer is saved");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                logger.error("Failed to Save");
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }else {
            logger.error("Did not contain json ContentType");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
