package by.andersen.firstproject.service.impl;

import by.andersen.firstproject.dao.DaoProvider;
import by.andersen.firstproject.dao.IUserDao;
import by.andersen.firstproject.dao.exception.DaoException;
import by.andersen.firstproject.entity.User;
import by.andersen.firstproject.service.IUserService;
import by.andersen.firstproject.service.exception.ServiceException;

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
