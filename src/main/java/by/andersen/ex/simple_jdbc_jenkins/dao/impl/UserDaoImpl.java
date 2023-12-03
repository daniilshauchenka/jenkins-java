package by.andersen.ex.simple_jdbc_jenkins.dao.impl;

import by.andersen.ex.simple_jdbc_jenkins.dao.IUserDao;
import by.andersen.ex.simple_jdbc_jenkins.dao.db.DatabaseConfig;
import by.andersen.ex.simple_jdbc_jenkins.dao.exception.DaoException;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {


    private static final String SQL_GET_USERS = "SELECT * from users where is_deleted != true order by id LIMIT ? OFFSET ?";


    @Override
    public List<User> getList(int limit, int offset) throws DaoException {
        List<User> usersList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USERS)) {
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usersList.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone_number"))
                );
            }
            System.out.println(usersList);
            return usersList;
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    private static final String SQL_ADD_USER = "insert into users (name, surname, phone_number) values (?, ?, ?) ";

    @Override
    public void add(User user) throws DaoException {
        System.out.println("dao add");
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }


    private static final String SQL_DELETE_USER = "update users set is_deleted=true where id=?";

    @Override
    public void delete(int id) throws DaoException {
        System.out.println("delete USER  " + id);
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.setAutoCommit(true);
            System.out.println("user deleted");
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }


    private static final String SQL_UPDATE_USER = "update users set name=?, surname=?, phone_number=? where id=?";

    @Override
    public void update(User user) throws DaoException {
        System.out.println("UPDATE USER  " + user);
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            connection.setAutoCommit(true);
            System.out.println("user updated");
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    private static final String SQL_GET_USER_BY_ID = "select * from users where id=?";

    @Override
    public User getById(int id) throws DaoException {
        User user = null;
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone_number"));
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return user;
    }
}
