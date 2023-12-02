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

public class DoEditUser implements Command {
    private final IUserService service = ServiceProvider.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       System.out.println("UPDATE USER");
        String name = request.getParameter(RequestParam.JSP_USER_NAME_PARAM_NAME);
        String surname = request.getParameter(RequestParam.JSP_USER_SURNAME_PARAM_NAME);
        String phoneNumber = request.getParameter(RequestParam.JSP_USER_PHONE_NUMBER_PARAM_NAME);
        int id =0;
      try{
          id = Integer.parseInt(request.getParameter(RequestParam.JSP_USER_ID_PARAM_NAME));
      }catch (NumberFormatException ex){
          ex.printStackTrace();
          //todo handle exception
      }

        User newUser = new User(id,name, surname, phoneNumber);
        User oldUser = null;
        try {
             oldUser = service.getById(Integer.parseInt(request.getParameter(RequestParam.JSP_USER_ID_PARAM_NAME)));
        } catch (ServiceException e) {
            //todo exception handling
            e.printStackTrace();
        }
System.out.println(oldUser);

        if(oldUser!=null && !oldUser.equals(newUser)){
            try {
                service.update(newUser);
            } catch (ServiceException e) {
                e.printStackTrace();
                //TODO exception handling
            }
        }


        response.sendRedirect("controller?command=go_to_users_list");
    }
}
