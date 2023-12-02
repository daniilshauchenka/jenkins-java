package by.andersen.ex.simple_jdbc_jenkins.service;

import by.andersen.ex.simple_jdbc_jenkins.entity.User;
import by.andersen.ex.simple_jdbc_jenkins.service.exception.ServiceException;

import java.util.List;

public interface IUserService {
    List<User> getList(int limit, int offset) throws ServiceException;

    void add(User user) throws ServiceException;

    void delete(User user) throws ServiceException;

    void update(User user) throws ServiceException;

    User getById(int id) throws ServiceException;
}
