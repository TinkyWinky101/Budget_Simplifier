module com.example.budget_simplifier_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.budget_simplifier_v2 to javafx.fxml;
    exports com.example.budget_simplifier_v2;

}