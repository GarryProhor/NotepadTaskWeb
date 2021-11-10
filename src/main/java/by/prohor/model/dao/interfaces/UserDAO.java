package by.prohor.model.dao.interfaces;

import by.prohor.model.entities.User;
import by.prohor.model.exception.DAOException;

public interface UserDAO {
    User get(String login, String password) throws DAOException;
}
