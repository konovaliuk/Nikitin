package com.peregrine.getfit.services;

import com.peregrine.getfit.commands.CommandMissing;
import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.util.PasswordCypher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Сервис для входа поьзователя
 */
public class ServiceLogin {
    private static final Logger logger = LogManager.getLogger(CommandMissing.class.getName());
    /**
     * Получить зарегестрированного пользовтеля. Получить спиок пользователей и сравнить их с введенными данными.
     * @param email введенный почтовый адрес.
     * @param password введенный пароль.
     * @return пользователя, если такой есть. null - если нет.
     */
    public static User getRegisteredUser(String email, String password) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        User user = factory.getUserDAO().findUserByEmail(email);
        try {
            if (user == null || !PasswordCypher.verifyPassword(password, user.getPassword())) {
                return null;
            }
            return user;
        }
        catch (PasswordCypher.InvalidHashException | PasswordCypher.CannotPerformOperationException e) {
            logger.error("error = " + e.getMessage());
            return null;
        }
    }
}
