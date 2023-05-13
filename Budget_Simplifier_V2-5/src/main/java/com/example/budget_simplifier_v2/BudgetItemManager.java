package com.example.budget_simplifier_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList; // For ObservableLists
import javafx.scene.control.TableColumn;

import java.io.File;

class BudgetItemManager
{
    //Observable List containing incomes and expenses together
    private static ObservableList<BudgetItem_IF> BudgetList = FXCollections.observableArrayList();
    private boolean loadFileUsed=false;
    ItemUtility myUtility = ItemUtility.getInstance();
    BudgetItemFactory_IF itemFactory;

    //Constructor (I don't know if we need a constructor for BudgetManager)
    BudgetItemManager(){}; // Default Constructor

    //Methods
    public void displayAllItems() //DisplayItems to user
    {
        for (BudgetItem_IF item : BudgetList) {
            System.out.println(item.getName());
        }
    }



    public void addBudgetItem(boolean isExpense, String itemName, double theRate, String theCategory, BudgetItem_IF.Period thePeriod, double theAmountOfPeriods, String source) //Add item to one of the ObservableLists
    {
        //If item is expense
        if(isExpense)
        {
            itemFactory = myUtility.createExpenseItemFactory();
            BudgetItem_IF budget_item = itemFactory.createBudgetItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);

            //ExpenseItem budget_item = new ExpenseItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);

            BudgetList.add(budget_item);
        }
        //If item is income
        else
        {
            itemFactory = myUtility.createIncomeItemFactory();
            BudgetItem_IF budget_item = itemFactory.createBudgetItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);

            //ExpenseItem budget_item = new ExpenseItem(itemName, theRate, theCategory, thePeriod, theAmountOfPeriods, source);

            BudgetList.add(budget_item);
        }


    }

    public void modifyBudgetItem(int indexNumber, boolean isExpense, TableColumn.CellEditEvent editedAttribute, int typeOfEdit) //Modify the item user selects with key(name)
    {
        //get the key from user

        //call getItemIndex to search for item

        //get item and make the designated modifications to item
        switch(typeOfEdit) {
            case 0:
                BudgetList.get(indexNumber).setName(editedAttribute.getNewValue().toString()); //Change the item name
                break;
            case 1:
                BudgetList.get(indexNumber).setRate(Double.parseDouble(editedAttribute.getNewValue().toString())); //Change the rate
                break;
            case 2:
                BudgetList.get(indexNumber).setCategory(editedAttribute.getNewValue().toString()); //Change the category name
                break;
            case 3:
                BudgetList.get(indexNumber).setPeriod(BudgetItem_IF.Period.valueOf(editedAttribute.getNewValue().toString())); //Change the PeriodType
                break;
            case 4:
                BudgetList.get(indexNumber).setPeriodAmount(Double.parseDouble(editedAttribute.getNewValue().toString())); //Change the periodAmount
                break;
            case 5:
                BudgetItem_IF holder = BudgetList.get(indexNumber);
                holder.setSD(editedAttribute.getNewValue().toString());

               /* if(BudgetList.get(indexNumber).getClass().getSimpleName() == "IncomeItem"){ //modified item is an IncomeItem
                    IncomeItem holder = (IncomeItem)BudgetList.get(indexNumber);
                    holder.setSD(editedAttribute.getNewValue().toString());
                }
                else{
                    ExpenseItem holder = (ExpenseItem) BudgetList.get(indexNumber);
                    holder.setSD(editedAttribute.getNewValue().toString());
                }*/

        }
    }

    public void deleteBudgetItem(int indexNumber)
    {
        BudgetList.remove(indexNumber);
    }

    public ObservableList<BudgetItem_IF> getList(){
        return BudgetList;
    }

    // Change the three things
    public void saveFileData(String text_filename) //store the contents of the array into a text file
    {

        TextFileWriter file_write = new TextFileWriter();
        file_write.saveFileData(text_filename, BudgetList);
    }
//
    public void loadFileData(File file) //Request to get data from file and create budgetItems
    {
        TextFileReader file_read = new TextFileReader();
        file_read.loadFileData(file, BudgetList);

    }

    public String getColor(BudgetItem_IF item){
        String colorString;
        colorString = "-fx-text-background-color: " + item.getColor() + ';';

        // Original Design, no longer used.

        /*System.out.println(item.getClass().getSimpleName()); testing print
        System.out.println(colorString); testing print

       if(item instanceof ExpenseItem){
            return colorString + " red;";
        }
        else if(item instanceof IncomeItem){
            return colorString + " black;";
        }
        else {
            return "";
        }
        */
        return colorString;
    }
}
