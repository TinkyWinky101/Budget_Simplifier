package com.example.budget_simplifier_v2;

import javafx.collections.ObservableList;
import java.io.File;

public interface FileReaderManager
{
    public void loadFileData(File textfilename, ObservableList<BudgetItem_IF> BudgetList); //Request to get data from file and create budgetItem
}
