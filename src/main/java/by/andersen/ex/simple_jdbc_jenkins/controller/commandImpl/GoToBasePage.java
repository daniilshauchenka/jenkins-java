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
import java.util.List;

public class GoToBasePage implements Command {
    private final IUserService userService = ServiceProvider.getInstance().getUserService();
    private static final int USERS_PER_PAGE = 5;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> usersList;
        try{
            usersList = userService.getUsers(USERS_PER_PAGE, 0);
            request.setAttribute(RequestParam.JSP_USERS_LIST_PARAM_NAME, usersList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch (ServiceException ex){
            ex.printStackTrace();
        }

    }
}
