package com.example.budget_simplifier_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExpenseInputScreen implements Initializable {

    private ExpenseInputManager expenseManager = new ExpenseInputManager();

    @FXML
    private Button AddItemButton;

    @FXML
    private Label ItemInfoLabel;

    @FXML
    private Label ItemLabel;

    @FXML
    private TextField SD;

    @FXML
    private VBox Seperator;

    @FXML
    private VBox VBoxThing;

    @FXML
    private TextField catName;

    @FXML
    private RadioButton expense;

    @FXML
    private RadioButton income;

    @FXML
    private TextField itemName;

    @FXML
    private TextField itemRate;

    @FXML
    private ToggleGroup itemType;

    @FXML
    private TextField periodAmount;

    @FXML
    private ChoiceBox<String> periodType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> comboBoxOptions = FXCollections.observableArrayList("None", "Hourly", "Daily", "Weekly","Monthly", "Yearly");
        periodType.setItems(comboBoxOptions);
    }

    @FXML
    void submit(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.NONE);

        if(!(income.isSelected() || expense.isSelected())){
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Item type is not selected");
            a.show();
            return;
        }
        if (itemName.getText().isEmpty()) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Item Name is empty");
            a.show();
            return;
        }
        if (itemRate.getText().isEmpty()) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Item Rate is empty");
            a.show();
            return;
        }
        if (catName.getText().isEmpty()) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Category Name is empty");
            a.show();
            return;
        }
        if (periodType.getValue() == null) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Period Type is empty");
            a.show();
            return;
        }
        if (periodAmount.getText().isEmpty()) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Period Amount is empty");
            a.show();
            return;
        }
        if (SD.getText().isEmpty()) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Source Destination is empty");
            a.show();
            return;
        }

        try //Determine if the inputs entered here were incorrect data types
        {
            double rateInput = Double.parseDouble(itemRate.getText());
            double periodAmountInput = Double.parseDouble(periodAmount.getText());
        } catch (Exception e) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Incorrect Data Type");
            a.show();
            return; //exit
        }

        String nameInput = itemName.getText();
        String categoryInput = catName.getText();
        String sourceOrDestinationInput = SD.getText();

        double BudgetItemRate = Double.parseDouble(itemRate.getText());

        double BudgetItemPeriodAmountInput = Double.parseDouble(periodAmount.getText());

        String BudgetItemPeriodTypeInput = periodType.getValue(); //Get the string input from checkbox
        BudgetItemPeriodTypeInput = BudgetItemPeriodTypeInput.toUpperCase();
        BudgetItem_IF.Period PeriodStorage = BudgetItem_IF.Period.valueOf(BudgetItemPeriodTypeInput); //Convert the string to period


        // false if income, true if expense
        boolean incomeOrExpense = (!income.isSelected() && expense.isSelected());

        expenseManager.pullItemInputs(incomeOrExpense, nameInput, BudgetItemRate, categoryInput, PeriodStorage, BudgetItemPeriodAmountInput, sourceOrDestinationInput);

        // get a handle to the stage
        Stage stage = (Stage)AddItemButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

//        ItemManager.addBudgetItem(false, nameInput, BudgetItemRate, categoryInput, PeriodStorage, BudgetItemPeriodAmountInput, sourceOrDestinationInput);

}
