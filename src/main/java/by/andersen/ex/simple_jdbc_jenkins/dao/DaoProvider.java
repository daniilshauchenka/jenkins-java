package by.andersen.ex.simple_jdbc_jenkins.dao;

import by.andersen.ex.simple_jdbc_jenkins.dao.impl.UserDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    private final IUserDao userDao = new UserDaoImpl();



    private DaoProvider() {
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public static DaoProvider getInstance() {
        return instance;
    }
}
