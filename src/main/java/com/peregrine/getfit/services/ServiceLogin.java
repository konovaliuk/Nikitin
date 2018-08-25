package com.peregrine.getfit.services;

import com.peregrine.getfit.commands.CommandMissing;
import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.util.PasswordCypher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ServiceLogin {
    private static final Logger logger = LogManager.getLogger(CommandMissing.class.getName());

    // Получить зарегестрированного пользовтеля
    public static User getRegisteredUser(String email, String password) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        ArrayList<User> usersList = factory.getUserDAO().findAll();
        try {
            for (User user: usersList) {
                if (email.equals(user.getEmail()) && PasswordCypher.verifyPassword(password,user.getPassword())) {
                    return user;
                }
            }
        }
        catch (PasswordCypher.InvalidHashException | PasswordCypher.CannotPerformOperationException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
    // Получить информацию пользователя, сохраненная в Session.
    public static User getLoginedUser(HttpSession session) {
        User logedInUser = (User)session.getAttribute("user");
        return logedInUser;
    }
}
