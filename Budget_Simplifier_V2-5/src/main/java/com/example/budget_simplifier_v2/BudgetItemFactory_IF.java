package com.example.budget_simplifier_v2;
interface BudgetItemFactory_IF
{
    BudgetItem_IF createBudgetItem(String name, double rate, String category, BudgetItem_IF.Period period,double periodAmount, String source);
}
