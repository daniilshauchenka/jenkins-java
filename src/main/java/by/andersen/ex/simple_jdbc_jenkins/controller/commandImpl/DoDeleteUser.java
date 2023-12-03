package by.andersen.ex.simple_jdbc_jenkins.controller.commandImpl;

import by.andersen.ex.simple_jdbc_jenkins.controller.Command;
import by.andersen.ex.simple_jdbc_jenkins.controller.RequestParam;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;
import by.andersen.ex.simple_jdbc_jenkins.service.IUserService;
import by.andersen.ex.simple_jdbc_jenkins.service.ServiceProvider;
import by.andersen.ex.simple_jdbc_jenkins.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoDeleteUser implements Command {
    private final IUserService service = ServiceProvider.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =0;
        try{
            id = Integer.parseInt(request.getParameter(RequestParam.JSP_USER_ID_PARAM_NAME));
        }catch (NumberFormatException ex){
            ex.printStackTrace();
            //todo handle exception
        }

        try {
            service.delete(id);
        } catch (ServiceException e) {
            e.printStackTrace();
            //TODO exception handling
        }
        response.sendRedirect("controller?command=go_to_users_list");
    }
}
