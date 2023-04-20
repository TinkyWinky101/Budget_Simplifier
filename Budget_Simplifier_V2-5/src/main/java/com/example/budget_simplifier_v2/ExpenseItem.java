package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItem;

public class ExpenseItem extends BudgetItem {
    //Data members
    private String destination;
    private double calculateExpenseTotal;
    //constructors
    ExpenseItem(String name, double rate, String category, Period period, double periodAmount, String destination)
    {
        super(name, rate, category, period, periodAmount);
        this.destination = destination;
    }


    //Methods
    public String getDestination() //Get destination
    {
        return destination;
    }

    public void setDestination(String destinationName) //set destination
    {
        destination = destinationName;
    }


    public double getCalculateExpenseTotal()
    {
        calculateExpenseTotal = getPeriodAmount() * getRate();
        calculateExpenseTotal = Math.round(calculateExpenseTotal * 100.0) / 100.0;
        return calculateExpenseTotal;
    }

}
