package by.andersen.ex.simple_jdbc_jenkins.service.impl;

import by.andersen.ex.simple_jdbc_jenkins.dao.DaoProvider;
import by.andersen.ex.simple_jdbc_jenkins.dao.IUserDao;
import by.andersen.ex.simple_jdbc_jenkins.dao.exception.DaoException;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;
import by.andersen.ex.simple_jdbc_jenkins.service.IUserService;
import by.andersen.ex.simple_jdbc_jenkins.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = DaoProvider.getInstance().getUserDao();

    @Override
    public List<User> getUsers(int limit, int offset) throws ServiceException {
        try {
            return userDao.getUsersList(limit, offset);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            System.out.println("service add");
            userDao.addUser(user);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        try {
            userDao.deleteUser(user);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userDao.updateUser(user);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }
}
