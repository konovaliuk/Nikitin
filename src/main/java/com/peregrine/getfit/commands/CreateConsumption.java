package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.services.ServiceConsumption;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateConsumption implements IRequestHandler {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        Consumption consumption = new Consumption();
        //consumption.setTime(request.getTime());
        consumption.setAmount(Integer.parseInt(request.getParameter("amount")));
        consumption.setFoodId(3);
        consumption.setUserId(10);
        ServiceConsumption.createConsumption(consumption);
        return Pages.getInstance().getProperty(Pages.AJAX);
    }
}
