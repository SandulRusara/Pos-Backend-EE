package lk.ijse.posbackendee.acontroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackendee.bo.BOFactoty;
import lk.ijse.posbackendee.bo.custom.OrderDetailsBO;
import lk.ijse.posbackendee.dto.OrderDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "orderDetails", urlPatterns = "/orderDetails", loadOnStartup = 5)
public class OrderDetails extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(OrderDetails.class);
    OrderDetailsBO orderDetailsBO = (OrderDetailsBO) BOFactoty.getBoFactoty().getBO(BOFactoty.BOTypes.ORDER_DETAILS);
    private Connection connection;
    Jsonb jsonb = JsonbBuilder.create();

//    @Override
//    public void init() throws ServletException {
//        logger.info("Init the OrderDetails servlet");
//
//        try {
//
//            InitialContext context = new InitialContext();
//            DataSource pool = (DataSource) context.lookup("java:comp/env/jdbc/pos_system");
//            this.connection = pool.getConnection();
//            logger.info("Obtained new connection (" + connection + ") to orderDetails servlet");
//
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<OrderDetailsDTO> orderDetails = orderDetailsBO.getOrderDetails(connection);

            if (!orderDetails.isEmpty()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");

                PrintWriter writer = resp.getWriter();
                String json = jsonb.toJson(orderDetails);
                writer.write(json);

                logger.info("Order details data send");
                resp.setStatus(HttpServletResponse.SC_OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")) {
            List<OrderDetailsDTO> details = jsonb.fromJson(
                    req.getReader(),
                    new ArrayList<OrderDetailsDTO>(){}.getClass().getGenericSuperclass()
            );

            try {
                if (orderDetailsBO.saveOrderDetails(details, connection)){
                    logger.info("Order details are Saved");
                    resp.setStatus(HttpServletResponse.SC_OK);
                }else {
                    logger.info("Failed to save");
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }else{
            logger.error("Did not contain json ContentType");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}