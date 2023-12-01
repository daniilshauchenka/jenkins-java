package by.andersen.firstproject.service;

import by.andersen.firstproject.service.impl.UserServiceImpl;

public final class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {
    }

    private final IUserService userService = new UserServiceImpl();


    public IUserService getUserService() {
        return userService;
    }


    public static ServiceProvider getInstance() {
        return instance;
    }

}

