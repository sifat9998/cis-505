import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AhmmedEnhancedFutureValueApp extends Application {

    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private ComboBox<Integer> cbYears;
    private TextArea txtResults;
    private Label lblFutureValueDate;
    private Button btnClear;
    private Button btnCalculate;

    @Override
    public void start(Stage primaryStage) {
        Label lblMonthlyPayment = new Label("Monthly Payment:");
        Label lblInterestRate = new Label("Interest Rate:");
        Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
        lblInterestRateFormat.setTextFill(Color.RED);
        lblFutureValueDate = new Label();

        txtMonthlyPayment = new TextField();
        txtInterestRate = new TextField();
        txtResults = new TextArea();
        txtResults.setEditable(false);

        cbYears = new ComboBox<>();
        for (int i = 1; i <= 10; i++) {
            cbYears.getItems().add(i);
        }
        cbYears.setValue(0);

        btnClear = new Button("Clear");
        btnCalculate = new Button("Calculate");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);

        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);

        GridPane.setHalignment(lblInterestRateFormat, javafx.geometry.HPos.RIGHT);
        pane.add(lblInterestRateFormat, 1, 2);

        pane.add(new Label("Years:"), 0, 3);
        pane.add(cbYears, 1, 3);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);
        pane.add(actionBtnContainer, 1, 4);

        pane.add(lblFutureValueDate, 1, 5);
        pane.add(txtResults, 1, 6);

        // Button event handlers
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Ahmmed Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    }

    private void calculateResults() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            int years = cbYears.getValue();

            double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);

            lblFutureValueDate.setText("Calculation as of " + getToday());
            txtResults.setText("The future value is $" + String.format("%,.2f", futureValue));

        } catch (NumberFormatException e) {
            txtResults.setText("Please enter valid numeric values.");
        }
    }

    private String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
