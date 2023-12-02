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
    public List<User> getList(int limit, int offset) throws ServiceException {
        try {
            return userDao.getList(limit, offset);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void add(User user) throws ServiceException {
        try {
            System.out.println("service add");
            userDao.add(user);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void delete(User user) throws ServiceException {
        try {
            userDao.delete(user);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(User user) throws ServiceException {
        try {
            userDao.update(user);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public User getById(int id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }
}
