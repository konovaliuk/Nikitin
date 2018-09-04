package com.peregrine.getfit.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Consumption implements Serializable {
    private Integer consumptionId;
    private LocalDateTime date;
    private Integer amount;
    private User user;
    private Food food;

    public Consumption() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(Integer consumptionId) {
        this.consumptionId = consumptionId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
                Objects.equals(date, consumption.date) &&
                Objects.equals(amount, consumption.amount) &&
                Objects.equals(user, consumption.user) &&
                Objects.equals(food, consumption.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumptionId, date, amount, user, food);
    }

    @Override
    public String toString() {
        return "Consumption(" +
                "consumptionId=" + consumptionId +
                ", time=" + date +
                ", amount=" + amount +
                ", user=" + user +
                ", food=" + food +
                ')';
    }
}
