package by.andersen.ex.simple_jdbc_jenkins.dao;

import by.andersen.ex.simple_jdbc_jenkins.dao.exception.DaoException;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> getUsersList(int limit, int offset) throws DaoException;

    void addUser(User user) throws DaoException;

    void deleteUser(User user) throws DaoException;

    void updateUser(User user) throws DaoException;
}
