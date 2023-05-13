package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItemManager;
import com.example.budget_simplifier_v2.ExpenseItem;
import com.example.budget_simplifier_v2.IncomeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class reportPageManager {
    //Data memebers
    BudgetItemManager newItemManager = new BudgetItemManager();

    private double incomeTotal;
    private double expenseTotal;

    private static ObservableList<IncomeItem> newIncomeList = FXCollections.observableArrayList();
    private static ObservableList<ExpenseItem> newExpenseList = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> PieDataIncomeList = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> PieDataExpenseList = FXCollections.observableArrayList();

    public void updateIncomeTotal()
    {
        incomeTotal=0.0;
        for(IncomeItem incomeItem : newIncomeList)
        {
            double incomeCalcAmount = incomeItem.getCalculateIncomeTotal();
            incomeTotal+= incomeCalcAmount;
        }

        incomeTotal = Math.round(incomeTotal * 100.0) / 100.0;
    }

    public String getExpenseTotal() {
        String ExpenseString = String.valueOf(+ expenseTotal);
        return ExpenseString;
    }

    public String getIncomeTotal() {
        String IncomeString = String.valueOf(+ incomeTotal);
        return IncomeString;
    }

    public void updateExpenseTotal()
    {
        expenseTotal=0.0;
        for(ExpenseItem expenseItem: newExpenseList)
        {
            double expenseCalcAmount = expenseItem.getCalculateExpenseTotal();
            expenseTotal+= expenseCalcAmount;
        }
        expenseTotal = Math.round(expenseTotal * 100.0) / 100.0;
    }

    public ObservableList<PieChart.Data> getPieDataExpenseList() {
        return PieDataExpenseList;
    }

    public ObservableList<PieChart.Data> getPieDataIncomeList() {
        return PieDataIncomeList;
    }

    public ObservableList<ExpenseItem> getExpenseList() {
        newExpenseList.clear();
        for(int i = 0; i < newItemManager.getList().size(); i++){
            if(newItemManager.getList().get(i) instanceof ExpenseItem){
                newExpenseList.add((ExpenseItem)newItemManager.getList().get(i));
            }
        }
//        newExpenseList = newItemManager.getExpenseList();
        return newExpenseList;
    }



    public ObservableList<IncomeItem> getIncomeList() {
        newIncomeList.clear();
        for(int i = 0; i < newItemManager.getList().size(); i++){
            if(newItemManager.getList().get(i) instanceof IncomeItem){
                newIncomeList.add((IncomeItem) newItemManager.getList().get(i));
            }
        }
//        newIncomeList = newItemManager.getIncomeList();
        return newIncomeList;
    }



    public void addPieChartDataToLists()
    {
        //Add the name and calculated amount to the PieChartExpenseData list
        for(ExpenseItem expenseItem : newExpenseList)
        {
            String expenseName = expenseItem.getName();
            double expenseCalcAmount = expenseItem.getCalculateExpenseTotal();

            PieChart.Data expensePieChartData = new PieChart.Data(expenseName, expenseCalcAmount);
            PieDataExpenseList.add(expensePieChartData);
        }

        for(IncomeItem incomeItem : newIncomeList)
        {
            String incomeName = incomeItem.getName();
            double incomeCalcAmount = incomeItem.getCalculateIncomeTotal();

            PieChart.Data incomePieChartData = new PieChart.Data(incomeName, incomeCalcAmount);
            PieDataIncomeList.add(incomePieChartData);
        }

    }

}