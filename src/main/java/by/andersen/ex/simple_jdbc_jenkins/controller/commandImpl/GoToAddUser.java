package by.andersen.ex.simple_jdbc_jenkins.controller.commandImpl;

import by.andersen.ex.simple_jdbc_jenkins.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAddUser implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
    }
}
