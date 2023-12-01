package by.andersen.firstproject.controller.commandImpl;

import by.andersen.firstproject.controller.Command;
import by.andersen.firstproject.controller.RequestParam;
import by.andersen.firstproject.entity.User;
import by.andersen.firstproject.service.IUserService;
import by.andersen.firstproject.service.ServiceProvider;
import by.andersen.firstproject.service.exception.ServiceException;

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
