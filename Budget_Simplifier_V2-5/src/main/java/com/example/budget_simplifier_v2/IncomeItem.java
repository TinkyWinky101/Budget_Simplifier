package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItem;

public class IncomeItem extends BudgetItem
{
    //Data members
    private String source;
    private double calculateIncomeTotal;
    //Constructors

    IncomeItem(String name, double rate, String category, Period period, double periodAmount, String source)
    {
        super(name, rate, category, period, periodAmount);
        this.source = source;
    }

    //Methods
    public String getSource()
    {
        return source;
    }

    public void setSource(String sourceName)
    {
        source = sourceName;
    }


    public double getCalculateIncomeTotal() {
        calculateIncomeTotal = getPeriodAmount() * getRate();
        calculateIncomeTotal = Math.round(calculateIncomeTotal * 100.0) / 100.0;
        return calculateIncomeTotal;
    }
}
