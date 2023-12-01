package by.andersen.firstproject.service;

import by.andersen.firstproject.entity.User;
import by.andersen.firstproject.service.exception.ServiceException;

import java.util.List;

public interface IUserService {
    List<User> getUsers(int limit,int offset) throws ServiceException;
}
