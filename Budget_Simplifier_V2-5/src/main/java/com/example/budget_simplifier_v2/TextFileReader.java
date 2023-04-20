package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItem;
//import com.example.budget_simplifier_v2.App_Model.BudgetItemManager;
import com.example.budget_simplifier_v2.ExpenseItem;
import com.example.budget_simplifier_v2.IncomeItem;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.Scanner;

public class TextFileReader
{

    public void saveFileData(String textfilename, ObservableList<IncomeItem> IncomeList, ObservableList<ExpenseItem> ExpenseList)
    {
        BudgetItemManager BudgetManagerCopy = new BudgetItemManager();
        boolean isExpense;
        String convert_string, loaded_name, loaded_category, loaded_source;
        double loaded_rate, loaded_periodamount;
        BudgetItem.Period loaded_period;



        // Before we create the writer we need to check if the filename is ends with .txt and add it if it doesnt
        if(!(textfilename.endsWith(".txt"))) // filename doesnt with .txt
            textfilename += ".txt";            // add it to the filename

        try
        {
            File filetoload = new File(textfilename); // Create file in try case
            Scanner filereader = new Scanner(filetoload); // Create scanner from that file
            while(filereader.hasNextLine()) // While the reader has more lines
            {
                if(filereader.nextLine().equals("Expense")) // Read the next line first to check if it says Income or Expense
                    isExpense = true; // If "Expense," mark as Expense with true
                else
                    isExpense = false; // Mark as false if it's an income

                // We now read and convert for all values before calling addBudgetItem()
                loaded_name = filereader.nextLine();              // read in the name
                convert_string = filereader.nextLine();           // read in the rate which needs conversion
                loaded_rate = Double.parseDouble(convert_string); // convert String rate to double
                loaded_category = filereader.nextLine();          // read in the category
                convert_string = filereader.nextLine();           // read in the period which needs to be Period
                loaded_period = BudgetItem.Period.valueOf(convert_string);  // Convert using valueOf from Period
                convert_string = filereader.nextLine();           // read in the periodAmount which needs conversion
                loaded_periodamount = Double.parseDouble(convert_string); // convert String periodAmount to double
                loaded_source = filereader.nextLine();

                // File add the item
                BudgetManagerCopy.addBudgetItem(isExpense, loaded_name, loaded_rate, loaded_category, loaded_period, loaded_periodamount, loaded_source);
            }
            filereader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error when loading file");
        }
    }

}
