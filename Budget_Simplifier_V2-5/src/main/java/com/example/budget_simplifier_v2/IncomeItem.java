package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItem;

public class IncomeItem extends BudgetItem
{
    //Data members

    private double calculateIncomeTotal;
    private String color;

    //Constructors

    IncomeItem(String name, double rate, String category, Period period, double periodAmount, String source)
    {
        super(name, rate, category, period, periodAmount);
        super.setSD(source);
        color = "black";
    }

    //Methods
    public String getSource()
    {
        return super.getSD();
    }

    public void setSource(String sourceName)
    {
        super.setSD(sourceName);
    }


    public double getCalculateIncomeTotal() {
        calculateIncomeTotal = getPeriodAmount() * getRate();
        calculateIncomeTotal = Math.round(calculateIncomeTotal * 100.0) / 100.0;
        return calculateIncomeTotal;
    }

    public String getColor()
    {
        return this.color;
    }
}
