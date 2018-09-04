package com.peregrine.getfit.services;

import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Класс-Сервис для работы с потреблениями
 */
public class ServiceConsumption {
    private static final Logger logger = LogManager.getLogger(ServiceConsumption.class);
    /**
     * Создать потребление
     * @param consumption потребление
     * @return true если success больше 0
     */
    public static boolean createConsumption(Consumption consumption) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        factory.getConsumptionDAO().createConsumption(consumption);
        logger.info("createConsumption() = ");
        return true;
    }

    /**
     * Получить список потреблений для конкретного пользователя
     * @return список потреблений
     */
    public static ArrayList<Consumption> getConsumptionsForCurrentUser (User user) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        ArrayList<Consumption> consumptionList = factory.getConsumptionDAO().findAll();
        ArrayList<Consumption> wrongCunsumptions = new ArrayList<>();
        for (Consumption consumption : consumptionList) {
            if(consumption.getDate().isBefore(LocalDate.now().atStartOfDay()) || !consumption.getUser().getId().equals(user.getId())) {
                wrongCunsumptions.add(consumption);
            }
        }
        logger.debug("wrong = " + wrongCunsumptions);
        for (Consumption wrongConsumption: wrongCunsumptions) {
            consumptionList.remove(wrongConsumption);
        }
        logger.debug("correct = " + consumptionList);
        return consumptionList;
    }
}
