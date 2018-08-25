package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Message;
import com.peregrine.getfit.util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class CaloriesCalculator implements IRequestHandler {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Double normal;
        Integer caloriesSum;

        String[] caloriesArray = request.getParameterValues("calories");
        ArrayList<Integer> caloriesList = new ArrayList<>();
        User user = (User)request.getAttribute("user");

        for (int i = 0; i < caloriesArray.length; i++) {
            caloriesList.add(Integer.parseInt(caloriesArray[i]));
        }

        caloriesSum = caloriesList.stream().mapToInt(Integer::intValue).sum();

        //TODO: константы вынести наверх
        if (user.getGender().equals("female")) {
           normal = 88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight()) - (5.7 * user.getAge());
        } else {
            normal = 446.7 + (9.2 * user.getWeight()) + (3.1 * user.getHeight()) - (4.3 * user.getAge());
        }

        String verdict = (normal.equals(caloriesSum)) ? Message.getInstance().getProperty(Message.NORM) : Message.getInstance().getProperty(Message.OVER);

        request.setAttribute("verdict",verdict);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }
}
