package com.peregrine.getfit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Consumption implements Serializable {
    private Integer consumptionId;
    private Date time;
    private Integer amount;
    private Integer userId;
    private Integer foodId;

    public Consumption() {}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(Integer consumptionId) {
        this.consumptionId = consumptionId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumption consumption = (Consumption) o;
        return Objects.equals(consumptionId, consumption.consumptionId) &&
                Objects.equals(time, consumption.time) &&
                Objects.equals(amount, consumption.amount) &&
                Objects.equals(userId, consumption.userId) &&
                Objects.equals(foodId, consumption.foodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumptionId, time, amount, userId, foodId);
    }

    @Override
    public String toString() {
        return "Consumption(" +
                "consumptionId=" + consumptionId +
                ", time=" + time +
                ", amount=" + amount +
                ", user=" + userId +
                ", food=" + foodId +
                ')';
    }
}
