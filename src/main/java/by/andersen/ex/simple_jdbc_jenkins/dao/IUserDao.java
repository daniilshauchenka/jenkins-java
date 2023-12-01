package by.andersen.firstproject.dao;

import by.andersen.firstproject.dao.exception.DaoException;
import by.andersen.firstproject.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> getUsersList(int limit, int offset) throws DaoException;
}
