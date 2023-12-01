package by.andersen.ex.simple_jdbc_jenkins.service;

import by.andersen.ex.simple_jdbc_jenkins.entity.User;
import by.andersen.ex.simple_jdbc_jenkins.service.exception.ServiceException;

import java.util.List;

public interface IUserService {
    List<User> getUsers(int limit, int offset) throws ServiceException;

    void addUser(User user) throws ServiceException;

    void deleteUser(User user) throws ServiceException;

    void updateUser(User user) throws ServiceException;
}
