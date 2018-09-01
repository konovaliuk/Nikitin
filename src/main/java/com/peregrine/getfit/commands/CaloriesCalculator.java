package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.services.ServiceConsumption;
import com.peregrine.getfit.services.ServiceFood;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Команда для подсчета колорий исходя из параметров пользователя
 */
public class CaloriesCalculator implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(ServiceConsumption.class);

    /** Свойство basalMetabolicRate - базовый уровень метаболизма по формуле Харрис-Бенедикта */
    Double basalMetabolicRate;
    /** Свойство caloriesSum - сума калорий потребленных пользователем*/
    Double consumedCaloriesSum;

    /** Коэфициеент зависящий от образа жизни*/
    Double lifestyleAdjustment(String lifestyle) {
        Double value;
        switch (lifestyle) {
            case "minimum":
                value = 1.2;
                break;
            case "low":
                value = 1.375;
                break;
            case "medium":
                value = 1.55;
                break;
            case "high":
                value = 1.725;
                break;
            case "very high":
                value = 1.9;
                break;
            default:
                value = 1.0;
                break;
        }
        return value;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        User user = (User)request.getSession().getAttribute("user");
        ArrayList<Consumption> consumptions = (ArrayList<Consumption>)request.getSession().getAttribute("consumptions");
        ArrayList<Double> caloriesList = new ArrayList<>();

        consumptions.forEach(item->caloriesList.add(item.getFood().getCalories() * item.getAmount()));

        consumedCaloriesSum = caloriesList.stream().mapToDouble(Double::doubleValue).sum();

        logger.debug("calories = " + consumedCaloriesSum);
        if (user.getGender().equals("Female")) {
           basalMetabolicRate = 88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight()) - (5.7 * user.getAge());
        } else {
            basalMetabolicRate = 446.7 + (9.2 * user.getWeight()) + (3.1 * user.getHeight()) - (4.3 * user.getAge());
        }

        basalMetabolicRate *= lifestyleAdjustment(user.getLifestyle());

        String verdict;
        if (basalMetabolicRate.equals(consumedCaloriesSum)) {
            verdict = "norm";
        }
        else if (basalMetabolicRate > consumedCaloriesSum) {
            verdict = "lower";
        }
        else {
            verdict = "over";
        }
        request.setAttribute("verdict", verdict);
        logger.debug("verdict = " + verdict);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }
}
