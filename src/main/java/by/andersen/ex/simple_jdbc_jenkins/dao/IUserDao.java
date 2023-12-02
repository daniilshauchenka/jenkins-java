package by.andersen.ex.simple_jdbc_jenkins.dao;

import by.andersen.ex.simple_jdbc_jenkins.dao.exception.DaoException;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> getList(int limit, int offset) throws DaoException;

    void add(User user) throws DaoException;

    void delete(User user) throws DaoException;

    void update(User user) throws DaoException;

    User getById(int id) throws DaoException;
}
