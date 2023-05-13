package com.example.budget_simplifier_v2;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class reportPageController implements Initializable {

    private reportPageManager ReportManager = new reportPageManager();

    @FXML
    private VBox BoxStuff;

    @FXML
    private TableView<ExpenseItem> ExpanseTable;

    @FXML
    private TableColumn<BudgetItem_IF, Double> ExpanseTableAmount;

    @FXML
    private TableColumn<BudgetItem_IF, String> ExpanseTableName;

    @FXML
    private PieChart ExpensePieChart;

    @FXML
    private Label ExpenseTotalLabel;

    @FXML
    private GridPane GridPanelThing;

    @FXML
    private PieChart IncomePieChart;

    @FXML
    private TableView<IncomeItem> IncomeTable;

    @FXML
    private TableColumn<IncomeItem, Double> IncomeTableAmount;

    @FXML
    private Label IncomeTotalLabel;

    @FXML
    private Label expanseLabel;

    @FXML
    private Label incomeLabel;

    @FXML
    private TableColumn<IncomeItem, String> incomeTableName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        incomeTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        IncomeTableAmount.setCellValueFactory(new PropertyValueFactory<>("calculateIncomeTotal"));
        IncomeTable.setItems(ReportManager.getIncomeList());

        ExpanseTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ExpanseTableAmount.setCellValueFactory(new PropertyValueFactory<>("calculateExpenseTotal"));
        ExpanseTable.setItems(ReportManager.getExpenseList());

        ReportManager.addPieChartDataToLists();

        ReportManager.updateExpenseTotal();
        ReportManager.updateIncomeTotal();

        IncomeTotalLabel.setText("Income Total: " + ReportManager.getIncomeTotal());
        ExpenseTotalLabel.setText("Expense Total: " + ReportManager.getExpenseTotal());

        ExpensePieChart.setData(ReportManager.getPieDataExpenseList());
        IncomePieChart.setData(ReportManager.getPieDataIncomeList());
    }
}