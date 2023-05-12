package com.example.budget_simplifier_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList; // For ObservableLists
import javafx.scene.control.TableColumn;

class BudgetItemManager
{
    //Observable List containing incomes
    private static ObservableList<IncomeItem> IncomeList = FXCollections.observableArrayList();

    // ObservableList containing Expenses
    private static ObservableList<ExpenseItem> ExpenseList = FXCollections.observableArrayList();

    private boolean loadFileUsed=false;

    //Constructor (i don't know if we need a construtor for BudgetManager)
    BudgetItemManager(){}; // Default Constructor

    //Methods
    public void displayAllItems() //DisplayItems to user
    {
        for(IncomeItem incomeitem : IncomeList)
        {
            System.out.println(incomeitem.getName());
        }
        for(ExpenseItem expenseitem : ExpenseList)
        {
            System.out.println(expenseitem.getName());
        }
    }

    public ObservableList<ExpenseItem> getExpenseList() {
        return ExpenseList;
    }

    public ObservableList<IncomeItem> getIncomeList() {
        return IncomeList;
    }

    public void addBudgetItem(boolean isExpense, String itemName, double theRate, String theCategory, BudgetItem.Period thePeriod, double theAmountOfPeriods, String source) //Add item to one of the ObservableLists
    {
        //If item is expense
        if(isExpense)
        {
            ExpenseItem budget_item = new ExpenseItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);
            ExpenseList.add(budget_item);
        }
        //If item is income
        else
        {
            IncomeItem budget_item = new IncomeItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);
            IncomeList.add(budget_item);
        }

    }

    public void modifyBudgetItem(int indexNumber, boolean isExpense, TableColumn.CellEditEvent editedAtribute, int typeOfEdit) //Modify the item user selects with key(name)
    {
        //get the key from user

        //call getItemIndex to seach for item

        //get item and make the designated modifiacations to item


        if(isExpense==true)
        {
            switch (typeOfEdit) {
                case 0 -> ExpenseList.get(indexNumber).setName(editedAtribute.getNewValue().toString()); //Change the item name
                case 1 -> ExpenseList.get(indexNumber).setRate(Double.parseDouble(editedAtribute.getNewValue().toString())); //Change the rate
                case 2 -> ExpenseList.get(indexNumber).setCategory(editedAtribute.getNewValue().toString()); //Change the category name
                case 3 -> ExpenseList.get(indexNumber).setPeriod(BudgetItem.Period.valueOf(editedAtribute.getNewValue().toString())); //Chnage the PeriodType
                case 4 -> ExpenseList.get(indexNumber).setPeriodAmount(Double.parseDouble(editedAtribute.getNewValue().toString())); //Change the periodAmount
                case 5 -> ExpenseList.get(indexNumber).setDestination(editedAtribute.getNewValue().toString()); //Change the destination
            }
        }

        else //If the item is income isExpense==false
        {

            switch (typeOfEdit) {
                case 0 -> IncomeList.get(indexNumber).setName(editedAtribute.getNewValue().toString());
                case 1 -> IncomeList.get(indexNumber).setRate(Double.parseDouble(editedAtribute.getNewValue().toString()));
                case 2 -> IncomeList.get(indexNumber).setCategory(editedAtribute.getNewValue().toString());
                case 3 -> IncomeList.get(indexNumber).setPeriod(BudgetItem.Period.valueOf(editedAtribute.getNewValue().toString()));
                case 4 -> IncomeList.get(indexNumber).setPeriodAmount(Double.parseDouble(editedAtribute.getNewValue().toString()));
                case 5 -> IncomeList.get(indexNumber).setSource(editedAtribute.getNewValue().toString());
            }
        }
    }

    public void deleteBudgetItem(int indexNumber, boolean isExpense)
    {
        if(isExpense==true) //if the item is expense
        {
            ExpenseList.remove(indexNumber);
        }
        else //Item is an income
        {
            IncomeList.remove(indexNumber);
        }
    }

    TextFileWriter filewrite = new TextFileWriter();
    TextFileReader fileread = new TextFileReader();
    FileMediator fileMediator = new FileMediator(filewrite, fileread);

    public void saveFileData(String textfilename) //store the contents of the array into a text file
    {
        fileMediator.saveFileData(textfilename, IncomeList, ExpenseList);
    }

    public void loadFileData(String textfilename) //Request to get data from file and create budgetItems
    {
        fileMediator.loadFileData(textfilename, IncomeList, ExpenseList);

    }

}