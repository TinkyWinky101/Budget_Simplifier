package com.example.budget_simplifier_v2;

import javafx.collections.ObservableList;

public interface FileWriterManager
{
    public void saveFileData(String textfilename, ObservableList<IncomeItem> IncomeList, ObservableList<ExpenseItem> ExpenseList); //Request to get data from file and create budgetItem

}
