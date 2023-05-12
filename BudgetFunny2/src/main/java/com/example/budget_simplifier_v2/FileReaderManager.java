package com.example.budget_simplifier_v2;

import javafx.collections.ObservableList;

public interface FileReaderManager
{
    public void loadFileData(String textfilename, ObservableList<IncomeItem> IncomeList, ObservableList<ExpenseItem> ExpenseList); //Request to get data from file and create budgetItem
}


