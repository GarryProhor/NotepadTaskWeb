package by.prohor.model.dao.impl;

import by.prohor.model.dao.interfaces.UserDAO;
import by.prohor.model.db.InMemoryDB;
import by.prohor.model.entities.User;
import by.prohor.model.exception.DAOException;

public class InMemoryUserDAOImpl implements UserDAO {



    @Override
    public User get(String login, String password) throws DAOException {
        return InMemoryDB.selectUserByLoginAndPassword(login, password);
    }
}
