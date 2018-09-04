package com.peregrine.getfit.services;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ServiceCalculateCalories {

    private static final Logger logger = LogManager.getLogger(ServiceConsumption.class);

    /** Свойство basalMetabolicRate - базовый уровень метаболизма по формуле Харрис-Бенедикта */
    private static Double basalMetabolicRate;
    /** Свойство caloriesSum - сума калорий потребленных пользователем*/
    private static Double consumedCaloriesSum;

    /**
     * Подсчет употребленных калорий для пользователя
     * @param user пользователь
     * @param consumptionsList список потреблений
     * @return строку, которая узкажет превышена ли норма калорий, равна норме или ниже.
     */
    public static String caloriesNorm(User user, ArrayList<Consumption> consumptionsList) {
        ArrayList<Double> caloriesList = new ArrayList<>();

        consumptionsList.forEach(item->caloriesList.add(item.getFood().getCalories() * item.getAmount()));
        consumedCaloriesSum = caloriesList.stream().mapToDouble(Double::doubleValue).sum();
        logger.debug("calories = " + consumedCaloriesSum);

        basalMetabolicRate = calculateBasalMetabolicRate(user) * lifestyleAdjustment(user.getLifestyle());
        logger.debug("user's norm = " + basalMetabolicRate);

        if (isInLimit()) {
            return "norm";
        } else if (basalMetabolicRate - consumedCaloriesSum > 200) {
            return "lower";
        } else {
            return "over";
        }
    }

    /**
     * Подсчет нормы калорий для пользователя
     * @param user пользователь
     * @return норму калорий
     */
    private static Double calculateBasalMetabolicRate(User user) {
        Double value;
        if (user.getGender().equals("female")) {
            value = 88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight()) - (5.7 * user.getAge());
        } else {
            value = 446.7 + (9.2 * user.getWeight()) + (3.1 * user.getHeight()) - (4.3 * user.getAge());
        }
        return value;
    }

    /***
     * В приделах ли нормы употребленные калории по отношению к пользователью
     * @return true если в пределах нормы
     */
    private static boolean isInLimit() {
        boolean diference = (basalMetabolicRate - consumedCaloriesSum) <= 200 && (basalMetabolicRate - consumedCaloriesSum)  > 0;
        boolean reverseDifferece = (consumedCaloriesSum - basalMetabolicRate) <= 200 && (consumedCaloriesSum - basalMetabolicRate) > 0;
        return basalMetabolicRate.equals(consumedCaloriesSum) || diference || reverseDifferece;
    }

    /**
     * Коэфициеент зависящий от уровня активности жизни
     * @return коэфициент уровня активности жизни
     */
    private static Double lifestyleAdjustment(String lifestyle) {
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
}
