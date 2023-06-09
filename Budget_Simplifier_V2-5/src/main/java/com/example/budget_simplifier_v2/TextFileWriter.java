package com.example.budget_simplifier_v2;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter
{
    public void saveFileData(String textfilename, ObservableList<BudgetItem_IF> budgetList)
    {
        // The variables that the ObservableLists contain for each Income or Expense Object
        String text_to_add = ""; // The text that will be added to the application

        // filereader should do all this
        // Before we create the writer we need to check if the filename is ends with .txt and add it if it doesnt
        if(!(textfilename.endsWith(".txt"))) // filename doesnt with .txt
            textfilename += ".txt";            // add it to the filename

        // try to create new file for editing
        try
        {
            File filecreator = new File(textfilename);
            // Open the file with filewriter
            if (filecreator.createNewFile())
            {
                System.out.println("File created: " + filecreator.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred when trying to create a new file.");
            e.printStackTrace();
        }
        // Open the file with filewriter
        try {
            FileWriter writer = new FileWriter(textfilename); // Open file

            for(BudgetItem_IF budgetItem: budgetList){
                if(budgetItem instanceof IncomeItem){
                    text_to_add += "Income\n";
                }
                else{
                    text_to_add += "Expense\n";
                }
                text_to_add += budgetItem.getName() + "\n";
                text_to_add += budgetItem.getRate() + "\n";
                text_to_add += budgetItem.getCategory() + "\n";
                text_to_add += budgetItem.getPeriod() + "\n";
                text_to_add += budgetItem.getPeriodAmount() + "\n";
                text_to_add += budgetItem.getSD() + "\n";
                writer.write(text_to_add);
                text_to_add = "";

            }
//            // Iterate through income array list
//            for(IncomeItem budget_item : IncomeList)
//            {
//                text_to_add = "Income\n";
//                text_to_add += budget_item.getName() + "\n";
//                text_to_add += budget_item.getRate() + "\n";
//                text_to_add += budget_item.getCategory() + "\n";
//                text_to_add += budget_item.getPeriod() + "\n";
//                text_to_add += budget_item.getPeriodAmount() + "\n";
//                text_to_add += budget_item.getSource() + "\n";
//                writer.write(text_to_add);
//            }
//
//            // Then iterate through the budget list
//            for(ExpenseItem budget_item : ExpenseList)
//            {
//                text_to_add = "Expense\n";
//                text_to_add += budget_item.getName() + "\n";
//                text_to_add += budget_item.getRate() + "\n";
//                text_to_add += budget_item.getCategory() + "\n";
//                text_to_add += budget_item.getPeriod() + "\n";
//                text_to_add += budget_item.getPeriodAmount() + "\n";
//                text_to_add += budget_item.getDestination() + "\n";
//                writer.write(text_to_add);
//            }

            writer.close(); // Finally close the file

        }
        catch (Exception e)
        {
            System.out.println("Error when saving into file");
        }
    }
}
