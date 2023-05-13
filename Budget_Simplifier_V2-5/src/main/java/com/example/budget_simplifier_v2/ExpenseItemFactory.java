package com.example.budget_simplifier_v2;

public class ExpenseItemFactory implements BudgetItemFactory_IF {
    public ExpenseItemFactory(){}

    public BudgetItem_IF createBudgetItem(String name, double rate, String category, BudgetItem_IF.Period period,double periodAmount, String source)
    {
        return new ExpenseItem(name, rate, category, period, periodAmount, source);
    }

}
