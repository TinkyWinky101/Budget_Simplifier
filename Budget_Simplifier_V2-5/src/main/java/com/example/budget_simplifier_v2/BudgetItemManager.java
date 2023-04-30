package com.example.budget_simplifier_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList; // For ObservableLists
import javafx.scene.control.TableColumn;

class BudgetItemManager
{
    //Observable List containing incomes and expenses together
    private static ObservableList<BudgetItem> BudgetList = FXCollections.observableArrayList();
    private boolean loadFileUsed=false;

    //Constructor (i don't know if we need a construtor for BudgetManager)
    BudgetItemManager(){}; // Default Constructor

    //Methods
    public void displayAllItems() //DisplayItems to user
    {
        for (BudgetItem item : BudgetList) {
            System.out.println(item.getName());
        }
    }



    public void addBudgetItem(boolean isExpense, String itemName, double theRate, String theCategory, BudgetItem.Period thePeriod, double theAmountOfPeriods, String source) //Add item to one of the ObservableLists
    {
        //If item is expense
        if(isExpense)
        {
            ExpenseItem budget_item = new ExpenseItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);
            BudgetList.add(budget_item);
        }
        //If item is income
        else
        {
            IncomeItem budget_item = new IncomeItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);
            BudgetList.add(budget_item); //repeated code
        }

    }

    public void modifyBudgetItem(int indexNumber, boolean isExpense, TableColumn.CellEditEvent editedAtribute, int typeOfEdit) //Modify the item user selects with key(name)
    {
        //get the key from user

        //call getItemIndex to seach for item

        //get item and make the designated modifiacations to item
        switch(typeOfEdit) {
            case 0 -> BudgetList.get(indexNumber).setName(editedAtribute.getNewValue().toString()); //Change the item name
            case 1 -> BudgetList.get(indexNumber).setRate(Double.parseDouble(editedAtribute.getNewValue().toString())); //Change the rate
            case 2 -> BudgetList.get(indexNumber).setCategory(editedAtribute.getNewValue().toString()); //Change the category name
            case 3 -> BudgetList.get(indexNumber).setPeriod(BudgetItem.Period.valueOf(editedAtribute.getNewValue().toString())); //Chnage the PeriodType
            case 4 -> BudgetList.get(indexNumber).setPeriodAmount(Double.parseDouble(editedAtribute.getNewValue().toString())); //Change the periodAmount
            case 5:
                if(BudgetList.get(indexNumber).getClass().getSimpleName() == "IncomeItem"){ //modified item is an IncomeItem
                    IncomeItem holder = (IncomeItem)BudgetList.get(indexNumber);
                    holder.setSource(editedAtribute.getNewValue().toString());
                }
                else{
                    ExpenseItem holder = (ExpenseItem) BudgetList.get(indexNumber);
                    holder.setDestination(editedAtribute.getNewValue().toString());
                }

        }
    }

    public void deleteBudgetItem(int indexNumber, boolean isExpense)
    {
        BudgetList.remove(indexNumber);
    }


    // Change the three things
    public void saveFileData(String textfilename) //store the contents of the array into a text file
    {

        TextFileWriter filewrite = new TextFileWriter();
        filewrite.saveFileData(textfilename, IncomeList, ExpenseList);
    }

    public void loadFileData(String textfilename) //Request to get data from file and create budgetItems
    {
        TextFileReader fileread = new TextFileReader();
        fileread.saveFileData(textfilename, IncomeList, ExpenseList);

    }

}