package com.peregrine.getfit.services;

import com.peregrine.getfit.commands.Registration;
import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * Сервис для регистрации пользователя
 * */
public class ServiceRegistration {
    private static final Logger logger = LogManager.getLogger(Registration.class);

    public static void registerUser(User user) {

        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        int success = factory.getUserDAO().createUser(user);
        logger.debug("success = " + success);
    }
}
