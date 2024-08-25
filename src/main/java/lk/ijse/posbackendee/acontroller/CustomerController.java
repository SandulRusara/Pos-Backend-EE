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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try {
        List<CustomerDto> customers = customerBO.getAllCustomer(connection);

        if (!customers.isEmpty()){
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter writer = resp.getWriter();
            String json = jsonb.toJson(customers);
            writer.write(json);

            logger.info("Customers data send");
            resp.setStatus(HttpServletResponse.SC_OK);
        }else{
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

}

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
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")){
            CustomerDto customerDTO = jsonb.fromJson(req.getReader(), CustomerDto.class);

            try {
                if (customerBO.updateCustomer(customerDTO, connection)){
                    logger.info("Customer is Updated");
                    resp.setStatus(HttpServletResponse.SC_OK);
                }else{
                    logger.error("Failed to Update");
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

        }else {
            logger.error("Did not contain json ContentType");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")){
            CustomerDto customerDTO = jsonb.fromJson(req.getReader(), CustomerDto.class);

            if (customerBO.deleteCustomer(customerDTO.getC_id(), connection)){
                logger.info("Customer is Deleted");
                resp.setStatus(HttpServletResponse.SC_OK);
            }else{
                logger.error("Failed to Delete");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

        }else{
            logger.error("Did not contain json ContentType");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
