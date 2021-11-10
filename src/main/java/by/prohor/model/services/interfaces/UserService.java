package by.prohor.model.services.interfaces;

import by.prohor.model.dao.interfaces.UserDAO;
import by.prohor.model.entities.User;
import by.prohor.model.exception.DAOException;
import by.prohor.model.exception.ServiceException;
import by.prohor.model.factories.UserDAOFactory;

public class UserService {
    private UserDAO userDAO;

    public UserService(String dao) {
        userDAO = UserDAOFactory.getInstance(dao);
    }

    public User get(String login, String password) throws ServiceException {
        try {
            return userDAO.get(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
