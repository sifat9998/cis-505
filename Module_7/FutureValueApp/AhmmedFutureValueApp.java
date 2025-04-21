import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AhmmedFutureValueApp extends Application {
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");

    private Label lblYears = new Label("Years:");
    private Label lblFutureValue = new Label("Future Value:");

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private ComboBox<Integer> cbYears = new ComboBox<>();
    private TextArea txtFutureValue = new TextArea();

    private Button btnClear = new Button("Clear");
    private Button btnCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        // Interest rate format style
        lblInterestRateFormat.setTextFill(Color.RED);

        // Add years to ComboBox
        for (int i = 1; i <= 30; i++) cbYears.getItems().add(i);

        // GridPane Layout
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Add labels and inputs
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);
        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        pane.add(lblYears, 0, 3);
        pane.add(cbYears, 1, 3);
        pane.add(lblFutureValue, 0, 4);
        pane.add(txtFutureValue, 1, 5);

        // Button container
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);
        pane.add(actionBtnContainer, 1, 4);

        // Button functionality
        btnClear.setOnAction(e -> {
            txtMonthlyPayment.clear();
            txtInterestRate.clear();
            cbYears.setValue(null);
            txtFutureValue.clear();
        });

        btnCalculate.setOnAction(e -> {
            try {
                double payment = Double.parseDouble(txtMonthlyPayment.getText());
                double rate = Double.parseDouble(txtInterestRate.getText()) / 100;
                int years = cbYears.getValue();
                int months = years * 12;
                double futureValue = payment * (Math.pow(1 + rate / 12, months) - 1) / (rate / 12);
                txtFutureValue.setText(String.format("$%,.2f", futureValue));
            } catch (Exception ex) {
                txtFutureValue.setText("Please enter valid inputs.");
            }
        });

        // Set Scene
        Scene scene = new Scene(pane, 450, 300);
        primaryStage.setTitle("Ahmmed Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
