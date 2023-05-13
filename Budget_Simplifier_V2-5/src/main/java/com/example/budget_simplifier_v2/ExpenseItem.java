package com.example.budget_simplifier_v2;

public class ExpenseItem extends BudgetItem {
    //Data members
    private double calculateExpenseTotal;
    private String color;
    //constructors
    ExpenseItem(String name, double rate, String category, Period period, double periodAmount, String destination)
    {
        super(name, rate, category, period, periodAmount);
        super.setSD(destination);
        color = "red";
    }


    //Methods

    public double getCalculateExpenseTotal()
    {
        calculateExpenseTotal = getPeriodAmount() * getRate();
        calculateExpenseTotal = Math.round(calculateExpenseTotal * 100.0) / 100.0;
        return calculateExpenseTotal;
    }

    public String getColor()
    {
        return this.color;
    }

}
