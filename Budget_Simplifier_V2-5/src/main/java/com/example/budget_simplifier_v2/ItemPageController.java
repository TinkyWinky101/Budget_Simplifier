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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
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

        expenseTable.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(BudgetItem item, boolean empty) {
                super.updateItem(item, empty);
                setStyle(itemManager.getColor(item));
//                if (item instanceof ExpenseItem) {
//                    setStyle("-fx-text-background-color: red;");
//                } else if (item instanceof IncomeItem) {
//                    setStyle("-fx-text-background-color: black;");
//                } else {
//                    setStyle("");
//                }

            }

        });


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
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt"));
        chooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        chooser.setTitle("Load File");
        Stage stage = new Stage();
        File selectedFile = chooser.showOpenDialog(stage);
        itemManager.loadFileData(selectedFile);
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
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt"));
        chooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        chooser.setTitle("Save File");
        Stage stage = new Stage();
        File selectedFile = chooser.showSaveDialog(stage);
        if (selectedFile != null) {
            itemManager.saveFileData(selectedFile.getName());
        }
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

    @FXML
    public void EditNameCell(TableColumn.CellEditEvent newIncomeNameEdit) {
        //Check if the income table was Selected
        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();


        if (selectedRowIndex > -1) {
            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
            itemManager.modifyBudgetItem(selectedRowIndex, false, newIncomeNameEdit, 0);
        }

    }


    @FXML
    public void EditRateCell(TableColumn.CellEditEvent newExpenseRateEdit) {
        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex(); //get the index from expense table

        try {
            double newExpenseRate = Double.parseDouble(newExpenseRateEdit.getNewValue().toString());
        } catch (Exception e) {

            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Incorrect Data Type");
            a.show();
            return;
        }


        if (selectedRowIndex > -1) {
            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
            itemManager.modifyBudgetItem(selectedRowIndex, true, newExpenseRateEdit, 1);
        }

    }

    @FXML
    public void EditCategoryCell(TableColumn.CellEditEvent newExpenseCategoryEdit) {
        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();

        if (selectedRowIndex > -1) {
            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
            itemManager.modifyBudgetItem(selectedRowIndex, true, newExpenseCategoryEdit, 2);
        }
    }

    @FXML
    public void EditPeriodType(TableColumn.CellEditEvent newIncomePeriodTypeEdit) {
        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();

        if (selectedRowIndex > -1) {
            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
            itemManager.modifyBudgetItem(selectedRowIndex, false, newIncomePeriodTypeEdit, 3);
        }
    }

    @FXML
    public void EditPeriodAmount(TableColumn.CellEditEvent newIncomePeriodAmountEdit) {
        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();


        Alert a = new Alert(Alert.AlertType.NONE); //Set up alert object
        try {
            double newIncomePeriodAmount = Double.parseDouble(newIncomePeriodAmountEdit.getNewValue().toString());
        } catch (Exception e) {


            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Incorrect Data Type");
            a.show();
            return;
        }

        if (selectedRowIndex > -1) {
            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
            itemManager.modifyBudgetItem(selectedRowIndex, false, newIncomePeriodAmountEdit, 4);
        }
    }

    @FXML
    public void EditSD(TableColumn.CellEditEvent newIncomeSourceEdit) {
        int selectedRowIndex = expenseTable.getSelectionModel().getSelectedIndex();

        if (selectedRowIndex > -1) {
            //Call the modify funtion with the paramenters false for isExpense, idexNumber for selected row, and number for what type of edit they made, and the cell edit event
            itemManager.modifyBudgetItem(selectedRowIndex, false, newIncomeSourceEdit, 5);
        }
    }


}
