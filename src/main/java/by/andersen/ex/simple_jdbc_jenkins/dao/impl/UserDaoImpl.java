package by.andersen.ex.simple_jdbc_jenkins.dao.impl;

import by.andersen.ex.simple_jdbc_jenkins.dao.IUserDao;
import by.andersen.ex.simple_jdbc_jenkins.dao.db.DatabaseConfig;
import by.andersen.ex.simple_jdbc_jenkins.dao.exception.DaoException;
import by.andersen.ex.simple_jdbc_jenkins.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {



    //   private static final String SQL_GET_USERS = "SELECT * from users order by id LIMIT ? OFFSET ?";
    private static final String SQL = "SELECT * from users order by id LIMIT ? OFFSET ?";

    @Override
    public List<User> getUsersList(int limit, int offset) throws DaoException {
        List<User> usersList = new ArrayList<>();
        System.out.println(DatabaseConfig.getUrl() + " " + DatabaseConfig.getUsername());
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
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
}
