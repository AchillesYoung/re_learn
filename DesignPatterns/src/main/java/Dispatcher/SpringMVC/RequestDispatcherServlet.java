package Dispatcher.SpringMVC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/10/30-3:26 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class RequestDispatcherServlet extends HttpServlet {
    /**
     * @param request
     * @param response
     */
    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Controller controller = new Controller();
        String requestURI = request.getRequestURI();
        String param = request.getParameter("param");
        if ("getMemberById".equals(requestURI)) {
            controller.getMemberById(param);
        } else if ("getOrderById".equals(requestURI)) {
            controller.getOrderById(param);
        } else if ("logout".equals(requestURI)) {
            controller.logout();
        } else {
            response.getWriter().write("404 Not Found!!");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
