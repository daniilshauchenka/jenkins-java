package by.andersen.ex.simple_jdbc_jenkins.controller.commandImpl;

import by.andersen.ex.simple_jdbc_jenkins.controller.Command;
import by.andersen.ex.simple_jdbc_jenkins.controller.RequestParam;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;
import by.andersen.ex.simple_jdbc_jenkins.service.IUserService;
import by.andersen.ex.simple_jdbc_jenkins.service.ServiceProvider;
import by.andersen.ex.simple_jdbc_jenkins.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToEditUser implements Command {

    private final IUserService userService = ServiceProvider.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user;
        int id = -1;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            //todo handle exception
            ex.printStackTrace();
            response.sendRedirect("controller?command=go_to_users_list");
        }

        try {
            user = userService.getById(id);
            request.setAttribute(RequestParam.JSP_SINGLE_USER_INFO_PARAM_NAME, user);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/pages/editUser.jsp").forward(request, response);

    }
}
