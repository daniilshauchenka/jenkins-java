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
        try{
            return userDao.getUsersList(limit, offset);
        } catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }
}
