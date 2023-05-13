package com.example.budget_simplifier_v2;

public class IncomeItemFactory implements BudgetItemFactory_IF
{
    public IncomeItemFactory(){}

    public BudgetItem_IF createBudgetItem(String name, double rate, String category, BudgetItem_IF.Period period,double periodAmount, String source)
    {
        return new IncomeItem(name, rate, category, period, periodAmount, source);
    }

}