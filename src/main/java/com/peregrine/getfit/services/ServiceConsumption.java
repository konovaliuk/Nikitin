package com.peregrine.getfit.services;

import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
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
        int success = factory.getConsumptionDAO().createConsumption(consumption);
        logger.info("createConsumption() = " + success);
        return success > 0;
    }

    /**
     * Получить список потреблений
     * @return список потреблений
     * */
    public static ArrayList<Consumption> getConsumptionList() {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        ArrayList<Consumption> consumptionList = factory.getConsumptionDAO().findAll();
        logger.info("getConsumptionList()");
        return consumptionList;
    }

    public static ArrayList<Consumption> getConsumptionsForCurrentUser (User user) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        ArrayList<Consumption> consumptionList = factory.getConsumptionDAO().findAll();
        ArrayList<Consumption> wrongCunsumptions = new ArrayList<>();
        for (Consumption item : consumptionList) {
            if(item.getDate().isBefore(LocalDate.now()) || !item.getUser().getId().equals(user.getId())) {
                wrongCunsumptions.add(item);
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
