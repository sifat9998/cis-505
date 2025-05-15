import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AhmmedGradeBookApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels
        Label lblFirstName = new Label("First Name:");
        Label lblLastName = new Label("Last Name:");
        Label lblCourse = new Label("Course:");
        Label lblGrade = new Label("Grade:");

        // Input fields
        TextField txtFirstName = new TextField();
        TextField txtLastName = new TextField();
        TextField txtCourse = new TextField();

        // Grade ComboBox (A–F)
        ComboBox<String> cbGrade = new ComboBox<>();
        cbGrade.getItems().addAll("A", "B", "C", "D", "E", "F");

        // Buttons
        Button btnClear = new Button("Clear");
        Button btnView = new Button("View Grades");
        Button btnSave = new Button("Save");

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add controls to grid
        grid.add(lblFirstName, 0, 0);
        grid.add(txtFirstName, 1, 0);
        grid.add(lblLastName, 0, 1);
        grid.add(txtLastName, 1, 1);
        grid.add(lblCourse, 0, 2);
        grid.add(txtCourse, 1, 2);
        grid.add(lblGrade, 0, 3);
        grid.add(cbGrade, 1, 3);

        // Button group
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(btnClear, btnView, btnSave);
        grid.add(hbox, 0, 4, 2, 1);

        // Scene setup
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Ahmmed Grade Book App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
