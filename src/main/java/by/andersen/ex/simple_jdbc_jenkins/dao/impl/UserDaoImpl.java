package by.andersen.firstproject.dao.impl;

import by.andersen.firstproject.dao.IUserDao;
import by.andersen.firstproject.dao.exception.DaoException;
import by.andersen.firstproject.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    private static final String JDBC_URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    private static final String SQL_GET_USERS = "SELECT * from users order by id LIMIT ? OFFSET ?";

    @Override
    public List<User> getUsersList(int limit, int offset) throws DaoException {
        List<User> usersList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USERS)) {
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usersList.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone"))
                );
            }
            return usersList;
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
}
