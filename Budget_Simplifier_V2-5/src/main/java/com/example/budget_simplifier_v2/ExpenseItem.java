package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItem;

public class ExpenseItem extends BudgetItem {
    //Data members
    private double calculateExpenseTotal;
    //constructors
    ExpenseItem(String name, double rate, String category, Period period, double periodAmount, String destination)
    {
        super(name, rate, category, period, periodAmount);
        super.setSD(destination);
    }


    //Methods
    public String getDestination() //Get destination
    {
        return super.getSD();
    }

    public void setDestination(String destinationName) //set destination
    {
        super.setSD(destinationName);
    }


    public double getCalculateExpenseTotal()
    {
        calculateExpenseTotal = getPeriodAmount() * getRate();
        calculateExpenseTotal = Math.round(calculateExpenseTotal * 100.0) / 100.0;
        return calculateExpenseTotal;
    }

}
