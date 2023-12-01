package by.andersen.ex.simple_jdbc_jenkins.service.exception;

public class ServiceException extends Exception {
    public ServiceException(String e) {
        super(e);
    }

    public ServiceException(Exception e) {
        super(e);
    }
}
