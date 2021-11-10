package by.prohor.model.dao.impl;

import by.prohor.model.dao.interfaces.UserDAO;
import by.prohor.model.entities.User;
import by.prohor.model.exception.DAOException;

public class H2UserDAOImpl implements UserDAO {
    @Override
    public User get(String login, String password) throws DAOException {
        return null;
    }
}
