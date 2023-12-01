package by.andersen.firstproject.dao.exception;

import java.sql.SQLException;

public class DaoException extends Exception{
    private static final long serialVersionUID = 1L;

    public DaoException(SQLException ex) {super(ex);}
    public DaoException(String ex) {super(ex);}
}
