package com.peregrine.getfit.servlets;

import com.peregrine.getfit.commands.*;
import com.peregrine.getfit.util.IRequestHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * Singleton Класс для хранения комманд
 */
public class ControllerHelper {
    private static Logger logger = LogManager.getLogger(ControllerHelper.class.getName());

    private static ControllerHelper instance = null;
    HashMap<String, IRequestHandler> commands = new HashMap<>();

    private ControllerHelper() {
        commands.put("login", new Login());
        commands.put("register", new Registration());
        commands.put("goToPage",new GoToPage());
        commands.put("logout", new Logout());
        commands.put("loadFoodList", new FoodLoader());
        commands.put("addFood", new CreateFood());
        commands.put("createConsumption", new CreateConsumption());
        commands.put("loadConsumptionList", new ConsumptionLoader());
        commands.put("calculateCalories", new CaloriesCalculator());
    }

    /**
     * Получить комманду
     * @param request HttpServletRequest request
     * @return экземпляр комманды
     */
    public IRequestHandler getCommand(HttpServletRequest request) {
        IRequestHandler command = commands.get(request.getParameter("command"));
        logger.info("command = " + request.getParameter("command"));
        if (command == null) {
            command = new CommandMissing();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
