package com.example.budget_simplifier_v2;

//import com.example.budget_simplifier_v2.App_Model.BudgetItemManager;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextFileReader
{

    public void loadFileData(File file, ObservableList<BudgetItem_IF> budgetList)
    {
        // Bring in the Factory and Utility instance for adding to the list
        ItemUtility myUtility = ItemUtility.getInstance();
        BudgetItemFactory_IF itemFactory;

        boolean isExpense;
        String convert_string, loaded_name, loaded_category, loaded_source;
        double loaded_rate, loaded_periodamount;
        BudgetItem.Period loaded_period;


        try
        {
            Scanner filereader = new Scanner(file); // Create scanner from that file
            while(filereader.hasNextLine()) // While the reader has more lines
            {
                if(filereader.nextLine().equals("Expense")) // Read the next line first to check if it says Income or Expense
                    itemFactory = myUtility.createExpenseItemFactory();
                else
                    itemFactory = myUtility.createIncomeItemFactory();

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
                BudgetItem_IF budget_item = itemFactory.createBudgetItem(loaded_name, loaded_rate, loaded_category, loaded_period, loaded_periodamount, loaded_source);
                budgetList.add(budget_item);
            }
            filereader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error when loading file");
        }
    }

}
