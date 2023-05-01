package com.example.budget_simplifier_v2;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ItemPageController {

    @FXML
    private AnchorPane AnchorThing;

    @FXML
    private VBox Box;

    @FXML
    private TableColumn<BudgetItem, String> SD;

    @FXML
    private TableColumn<BudgetItem, Double> amount;

    @FXML
    private TableColumn<BudgetItem, String> category;

    @FXML
    private Menu editOption;

    @FXML
    private TableView<BudgetItem> expenseTable;

    @FXML
    private Menu fileOption;

    @FXML
    private Menu helpOption;

    @FXML
    private MenuBar menu;

    @FXML
    private TableColumn<BudgetItem, String> name;

    @FXML
    private TableColumn<BudgetItem, BudgetItem.Period> periodType;

    @FXML
    private TableColumn<BudgetItem, Integer> rate;

}
//    //Other variables
//    private BudgetItemManager ItemManager = new BudgetItemManager();
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        //List used for the periodType cell in income table
//        ObservableList<BudgetItem.Period> comboBoxOption = FXCollections.observableArrayList(
//                BudgetItem.Period.NONE, BudgetItem.Period.HOURLY, BudgetItem.Period.DAILY, BudgetItem.Period.WEEKLY, BudgetItem.Period.MONTHLY,
//                BudgetItem.Period.YEARLY
//        );
//
//
//        //For the expense Table
//        expenseItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        expenseItemRateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
//        expenseItemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//        expenseItemPeriodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
//        expenseItemPeriodAmountColumn.setCellValueFactory(new PropertyValueFactory<>("periodAmount"));
//        expenseItemDestinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
//
//        //For editing the selected column of a row in expense table
//        expenseItemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        expenseItemRateColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        expenseItemCategoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        expenseItemPeriodTypeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboBoxOption));
//        expenseItemPeriodAmountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        expenseItemDestinationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        //Display the items of the table from the observable list
//        expenseTable.setItems(ItemManager.getExpenseList());
//
//        //For the income Table
//        incomeItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        incomeItemRateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
//        incomeItemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//        incomeItemPeriodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
//        incomeItemPeriodAmountColumn.setCellValueFactory(new PropertyValueFactory<>("periodAmount"));
//        incomeItemSourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));
//
//        //
//        incomeItemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        incomeItemRateColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        incomeItemCategoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//
//        incomeItemPeriodTypeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboBoxOption));
//
//        incomeItemPeriodAmountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        incomeItemSourceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        //Display the items of the table from the observable list
//        incomeTable.setItems(ItemManager.getIncomeList());
//
//        //For the combooBox input
//        ObservableList<String> comboBoxOptions = FXCollections.observableArrayList("None", "Hourly", "Daily", "Weekly","Monthly", "Yearly");
//        periodTypeComboBox.setItems(comboBoxOptions);
//    }
//
//    //Add an item to table with the user data
//    @FXML public void addItemToTable()
//    {
//
//        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
//
//        //First determine if all fields were filled out
//        if(nameTextField.getText().isEmpty())
//            return;
//        else if(rateTextField.getText().isEmpty())
//            return;
//        else if(categoryTextField.getText().isEmpty())
//            return;
//        else if(periodTypeComboBox.getValue()==null)
//            return;
//        else if(periodAmountTextField.getText().isEmpty())
//            return;
//        else if(sourceOrDestinationTextField.getText().isEmpty())
//            return;
//
//
//        try //Determine if the inputs entered here were incorrect data types
//        {
//            double rateInput = Double.parseDouble(rateTextField.getText());
//            double periodAmountInput = Double.parseDouble(periodAmountTextField.getText());
//        }
//        catch (Exception e) {
//            a.setAlertType(Alert.AlertType.ERROR);
//            a.setContentText("Incorrect Data Type");
//            a.show();
//            return; //exit
//        }
//
//        //Get the info from the text fields
//        String nameInput = nameTextField.getText();
//        String categoryInput = categoryTextField.getText();
//        String sourceOrDestinationInput = sourceOrDestinationTextField.getText();
//
//        double BudgetItemRate =  Double.parseDouble(rateTextField.getText());
//
//        double BudgetItemPeriodAmountInput = Double.parseDouble(periodAmountTextField.getText());
//
//        String BudgetItemPeriodTypeInput = periodTypeComboBox.getValue(); //Get the string input from checkbox
//        BudgetItemPeriodTypeInput=BudgetItemPeriodTypeInput.toUpperCase();
//        BudgetItem.Period PeriodStorage = BudgetItem.Period.valueOf(BudgetItemPeriodTypeInput); //Convert the string to period
//
//        //Check if the user clicked on income
//        if(incomeRadioButton.isSelected()) {
//            ItemManager.addBudgetItem(false, nameInput, BudgetItemRate, categoryInput, PeriodStorage, BudgetItemPeriodAmountInput, sourceOrDestinationInput);
//        }
//
//        //Check if the user clicked on expense
//        else if(expenseRadioButton.isSelected()){
//            ItemManager.addBudgetItem(true, nameInput, BudgetItemRate, categoryInput, PeriodStorage, BudgetItemPeriodAmountInput, sourceOrDestinationInput);
//        }
//
//    }
//
//    //Used to remove one or multiple row from both tables
//    @FXML public void removeItemFromList(){
//        //Remove
//
//        //Get the index from the income table and delete the item from that index
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//        if(selectedRowIndex>-1)
//            ItemManager.deleteBudgetItem(selectedRowIndex, false);
//
//        //Get index from the expense table and delete the item from that index
//        selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
//        if(selectedRowIndex>-1)
//            ItemManager.deleteBudgetItem(selectedRowIndex, true);
//    }
//
//
//    @FXML public void loadButtonClicked()
//    {
//        String fileName;
//        fileName=fileNameField.getText(); //Obtain the file name
//        ItemManager.loadFileData(fileName); //have the file populate it's data to the Income and Expense observable list
//    }
//
//    @FXML public void saveButtonClicked()
//    {
//        String fileName;
//        fileName=fileNameField.getText();
//        ItemManager.saveFileData(fileName);
//    }
//
//    @FXML public void EditIncomeNameCell(TableColumn.CellEditEvent newIncomeNameEdit)
//    {
//        //Check if the income table was Selected
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, false, newIncomeNameEdit, 0);
//        }
//
//    }
//
//    @FXML public void EditExpenseNameCell(TableColumn.CellEditEvent newExpenseNameEdit)
//    {
//        //Check if the expense table was Selected
//        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
//
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, true, newExpenseNameEdit, 0);
//        }
//
//    }
//
//    @FXML public void EditExpenseRateCell(TableColumn.CellEditEvent newExpenseRateEdit)
//    {
//        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
//        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex(); //get the index from expense table
//
//        try
//        {
//            double newExpenseRate = Double.parseDouble(newExpenseRateEdit.getNewValue().toString());
//        } catch (Exception e) {
//
//            a.setAlertType(Alert.AlertType.ERROR);
//            a.setContentText("Incorrect Data Type");
//            a.show();
//            return;
//        }
//
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, true, newExpenseRateEdit, 1);
//        }
//
//    }
//
//    @FXML public void EditIncomeRateCell(TableColumn.CellEditEvent newIncomeRateEdit)
//    {
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//
//        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
//        try
//        {
//            double newIncomeRate = Double.parseDouble(newIncomeRateEdit.getNewValue().toString());
//        } catch (Exception e) {
//
//            a.setAlertType(Alert.AlertType.ERROR);
//            a.setContentText("Incorrect Data Type");
//            a.show();
//            return;
//        }
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, false, newIncomeRateEdit, 1);
//        }
//    }
//
//    @FXML public void EditIncomeCategoryCell(TableColumn.CellEditEvent newIncomeCategoryEdit)
//    {
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, false, newIncomeCategoryEdit, 2);
//        }
//    }
//
//    @FXML public void EditExpenseCategory(TableColumn.CellEditEvent newExpenseCategoryEdit)
//    {
//        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, true, newExpenseCategoryEdit, 2);
//        }
//    }
//
//    @FXML public void EditIncomePeriodType(TableColumn.CellEditEvent newIncomePeriodTypeEdit)
//    {
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, false, newIncomePeriodTypeEdit, 3);
//        }
//    }
//
//    @FXML public void EditExpensePeriodType(TableColumn.CellEditEvent newExpensePeriodTypeEdit)
//    {
//        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
//
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, true, newExpensePeriodTypeEdit, 3);
//        }
//    }
//
//    @FXML public void EditExpensePeriodAmount(TableColumn.CellEditEvent newExpensePeriodAmountEdit)
//    {
//        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
//
//        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
//        try
//        {
//            double newExpensePeriodAmount = Double.parseDouble(newExpensePeriodAmountEdit.getNewValue().toString());
//        } catch (Exception e) {
//
//            a.setAlertType(Alert.AlertType.ERROR);
//            a.setContentText("Incorrect Data Type");
//            a.show();
//            return;
//        }
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, true, newExpensePeriodAmountEdit, 4);
//        }
//    }
//
//    @FXML public void EditIncomePeriodAmount(TableColumn.CellEditEvent newIncomePeriodAmountEdit)
//    {
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//
//
//        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
//        try
//        {
//            double newIncomePeriodAmount = Double.parseDouble(newIncomePeriodAmountEdit.getNewValue().toString());
//        } catch (Exception e) {
//
//
//            a.setAlertType(Alert.AlertType.ERROR);
//            a.setContentText("Incorrect Data Type");
//            a.show();
//            return;
//        }
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, false, newIncomePeriodAmountEdit, 4);
//        }
//    }
//
//    @FXML public void EditIncomeSource(TableColumn.CellEditEvent newIncomeSourceEdit)
//    {
//        int selectedRowIndex = incomeTable.getSelectionModel().getSelectedIndex();
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, false, newIncomeSourceEdit, 5);
//        }
//    }
//
//    @FXML public void EditExpenseDestination(TableColumn.CellEditEvent newExpenseDestinationEdit)
//    {
//        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
//
//        if(selectedRowIndex>-1)
//        {
//            //Call the modify funtion with the paramenters false for isExpense, indexNumber for selected row, and number for what type of edit they made, and the cell edit event
//            ItemManager.modifyBudgetItem(selectedRowIndex, true, newExpenseDestinationEdit, 5);
//        }
//    }
//
//    @FXML void changeSceneToReportView(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportPage.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(scene);
//        window.setFullScreen(true);
//    }
//
//}
