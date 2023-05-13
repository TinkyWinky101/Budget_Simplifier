package com.example.budget_simplifier_v2;

public class ItemUtility
{
    private static ItemUtility myInstance = new ItemUtility();
    //This is the utility that creates the factory

    public static ItemUtility getInstance()
    {
        return myInstance;
    }

    public BudgetItemFactory_IF createIncomeItemFactory()
    {
        return new IncomeItemFactory();
    }
    public BudgetItemFactory_IF createExpenseItemFactory()
    {
        return new ExpenseItemFactory();
    }


}
