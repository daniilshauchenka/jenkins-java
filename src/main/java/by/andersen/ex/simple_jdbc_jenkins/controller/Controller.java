package by.andersen.ex.simple_jdbc_jenkins.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;



public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();
@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       System.out.println(request.getContextPath());
        String commandName = request.getParameter("command");
        Command command = provider.getCommand(commandName);
        request.setAttribute(RequestParam.JSP_PREV_QUERY_PARAM_NAME, request.getHeader("referer"));
        command.execute(request, response);
    }
@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandName = request.getParameter("command");
        request.setAttribute(RequestParam.JSP_PREV_QUERY_PARAM_NAME,
                request.getAttribute("javax.servlet.forward.query_string"));
        Command command = provider.getCommand(commandName);
        command.execute(request, response);
    }
}