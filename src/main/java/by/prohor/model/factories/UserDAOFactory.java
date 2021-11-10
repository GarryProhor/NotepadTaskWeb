package by.prohor.model.factories;

import by.prohor.model.dao.impl.H2UserDAOImpl;
import by.prohor.model.dao.impl.InMemoryUserDAOImpl;
import by.prohor.model.dao.interfaces.UserDAO;

public class UserDAOFactory {
    public static UserDAO getInstance(String dao){
        UserDAO userDAO = null;
        switch (dao.toLowerCase()){
            case "memory" :
                userDAO = new InMemoryUserDAOImpl();
                break;
            case "h2" :
                userDAO = new H2UserDAOImpl();
                break;
        }
        return userDAO;
    }
}
