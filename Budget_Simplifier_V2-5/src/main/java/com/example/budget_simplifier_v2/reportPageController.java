package com.example.budget_simplifier_v2;

import com.example.budget_simplifier_v2.BudgetItem;
import com.example.budget_simplifier_v2.ExpenseItem;
import com.example.budget_simplifier_v2.IncomeItem;
import com.example.budget_simplifier_v2.reportPageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class reportPageController implements Initializable{

    private reportPageManager ReportManager = new reportPageManager();

    //Tables for the income and expense items
    @FXML private TableView<IncomeItem> incomeCalcTable;
    @FXML private TableView<ExpenseItem> expenseCalcTable;
    @FXML private TableView<BudgetItem> finalCalcTable;

    //Columns for the income table
    @FXML private TableColumn<IncomeItem, String> incomeNameCol;
    @FXML private TableColumn<ExpenseItem, Double> incomeCalculatedAmountCol;

    //Columns for the expense table
    @FXML private TableColumn<ExpenseItem, String> expenseNameCol;
    @FXML private TableColumn<ExpenseItem, Double> expenseCalculatedAmountCol;

    //PieCharts
    @FXML private PieChart incomeChart;
    @FXML private PieChart expenseChart;

    //
    @FXML private Label incomeTotal;
    @FXML private Label expenseTotal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set up the columns for the income table
        incomeNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        incomeCalculatedAmountCol.setCellValueFactory(new PropertyValueFactory<>("calculateIncomeTotal"));

        //Have the income table set up with the income list
        incomeCalcTable.setItems(ReportManager.getIncomeList());

        //Set up the columns for expense list
        expenseNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        expenseCalculatedAmountCol.setCellValueFactory(new PropertyValueFactory<>("calculateExpenseTotal"));

        //Have the expense table set with the expense list
        expenseCalcTable.setItems(ReportManager.getExpenseList());

        //SetUp the ChartData
        ReportManager.addPieChartDataToLists();

        //
        ReportManager.updateExpenseTotal();
        ReportManager.updateIncomeTotal();

        incomeTotal.setText(ReportManager.getIncomeTotal());
        expenseTotal.setText(ReportManager.getExpenseTotal());

        expenseChart.setData(ReportManager.getPieDataExpenseList());
        incomeChart.setData(ReportManager.getPieDataIncomeList());

    }

    @FXML public void changeSceneToItemView(ActionEvent event) throws IOException
    {
        Parent newScene = FXMLLoader.load(getClass().getResource("ItemPage.fxml"));
        Scene scene = new Scene(newScene);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.setFullScreen(true);
    }

}
