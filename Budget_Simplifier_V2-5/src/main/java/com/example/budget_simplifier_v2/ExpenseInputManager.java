package com.example.budget_simplifier_v2;

public class ExpenseInputManager {
    private BudgetItemManager manager = new BudgetItemManager();

    public void pullItemInputs(boolean isExpense, String itemName, double theRate, String theCategory, BudgetItem.Period thePeriod, double theAmountOfPeriods, String source){
        manager.addBudgetItem(isExpense, itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);
    }
}
