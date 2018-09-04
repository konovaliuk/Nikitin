package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.services.ServiceCalculateCalories;
import com.peregrine.getfit.services.ServiceConsumption;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Команда для подсчета колорий исходя из параметров пользователя
 */
public class CaloriesCalculator implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(ServiceConsumption.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User)request.getSession().getAttribute("user");
        ArrayList<Consumption> consumptionsList = (ArrayList<Consumption>)request.getSession().getAttribute("consumptions");

        String verdict = ServiceCalculateCalories.caloriesNorm(user,consumptionsList);

        request.setAttribute("verdict", verdict);
        logger.debug("verdict = " + verdict);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }


}
