package com.peregrine.getfit.services;

import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.Consumption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ServiceConsumption {
    private static final Logger logger = LogManager.getLogger(ServiceConsumption.class);

    public static boolean createConsumption(Consumption consumption) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        int success = factory.getConsumptionDAO().createConsumption(consumption);
        logger.info("createConsumption() = " + success);
        return success > 0;
    }

    public static ArrayList<Consumption> getConsumptionList() {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        ArrayList<Consumption> consumptionList = factory.getConsumptionDAO().findAll();
        logger.info("getConsumptionList()");
        return consumptionList;
    }

}
