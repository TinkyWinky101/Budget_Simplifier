package com.example.budget_simplifier_v2;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ItemPageController implements Initializable {

    @FXML
    private AnchorPane AnchorThing;

    @FXML
    private VBox Box;

    @FXML
    private MenuItem ReportOption;

    @FXML
    private TableColumn<BudgetItem, String> SD;

    @FXML
    private TableColumn<BudgetItem, Double> amount;

    @FXML
    private TableColumn<BudgetItem, String> category;

    @FXML
    private TableView<BudgetItem> expenseTable;

    @FXML
    private Menu fileOption;

    @FXML
    private Menu helpOption;

    @FXML
    private MenuItem instructions;

    @FXML
    private MenuItem loadItemOption;

    @FXML
    private MenuBar menu;

    @FXML
    private TableColumn<BudgetItem, String> name;

    @FXML
    private MenuItem newBudgetItemThing;

    @FXML
    private TableColumn<BudgetItem, BudgetItem.Period> periodType;

    @FXML
    private MenuItem quitChoice;

    @FXML
    private MenuItem deleteOption;

    @FXML
    private TableColumn<BudgetItem, Double> rate;

    @FXML
    private MenuItem saveItemsOption;


    private BudgetItemManager itemManager = new BudgetItemManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //List used for periodType cell in income table
        ObservableList<BudgetItem.Period> comboBoxOption = FXCollections.observableArrayList(
                BudgetItem.Period.NONE, BudgetItem.Period.HOURLY, BudgetItem.Period.DAILY, BudgetItem.Period.WEEKLY, BudgetItem.Period.MONTHLY,
                BudgetItem.Period.YEARLY
        );

        //Big table
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        SD.setCellValueFactory(new PropertyValueFactory<>("SD"));
        periodType.setCellValueFactory(new PropertyValueFactory<>("period"));
        amount.setCellValueFactory(new PropertyValueFactory<>("periodAmount"));

        //for editing
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        rate.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        category.setCellFactory(TextFieldTableCell.forTableColumn());
        periodType.setCellFactory(ComboBoxTableCell.forTableColumn(comboBoxOption));
        amount.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        SD.setCellFactory(TextFieldTableCell.forTableColumn());


        expenseTable.setItems(itemManager.getList());
        itemManager.displayAllItems();
        //color a row font red if it is an expense item
        expenseTable.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected boolean isItemChanged(BudgetItem oldItem, BudgetItem newItem) {
                return true;
            }

            @Override
            protected void updateItem(BudgetItem item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && item instanceof ExpenseItem) {
                    System.out.println(item.getName());
                    setStyle("-fx-text-fill: red;");
                }
            }
        });

    }

    @FXML
    void createNewItem(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExpenseScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Expense Form");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    void loadItemFromFile(ActionEvent event) {

    }

    @FXML
    void pullInstructions(ActionEvent event) {

    }

    @FXML
    void quitApplication(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Close the application?");
        Optional<ButtonType> choose = a.showAndWait();
        if (choose.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    @FXML
    void saveItemToFile(ActionEvent event) {

    }


    @FXML
    void showReport(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReportScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Report");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }


    //Used to remove one or multiple row from both tables
    @FXML
    public void deleteSelection() {
        //Remove
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Delete selection?");
        Optional<ButtonType> choose = a.showAndWait();
        if (choose.get() == ButtonType.OK) {
            int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();
            if (selectedRowIndex > -1)
                itemManager.deleteBudgetItem(selectedRowIndex);
        }
        //Get the index from the income table and delete the item from that index

    }
}
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
