import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

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

        // Grade ComboBox
        ComboBox<String> cbGrade = new ComboBox<>();
        cbGrade.getItems().addAll("A", "B", "C", "D", "E", "F");
        cbGrade.setValue("A");

        // Buttons
        Button btnClear = new Button("Clear");
        Button btnSave = new Button("Save");
        Button btnView = new Button("View Grades");

        // Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(lblFirstName, 0, 0);
        grid.add(txtFirstName, 1, 0);
        grid.add(lblLastName, 0, 1);
        grid.add(txtLastName, 1, 1);
        grid.add(lblCourse, 0, 2);
        grid.add(txtCourse, 1, 2);
        grid.add(lblGrade, 0, 3);
        grid.add(cbGrade, 1, 3);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnClear, btnSave, btnView);
        grid.add(buttonBox, 0, 4, 2, 1);

        // Event Handlers
        btnClear.setOnAction(e -> {
            txtFirstName.clear();
            txtLastName.clear();
            txtCourse.clear();
            cbGrade.setValue("A");
        });

        btnSave.setOnAction(e -> {
            try {
                Student student = new Student(
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    txtCourse.getText(),
                    cbGrade.getValue()
                );

                File file = new File("grades.csv");
                boolean fileExists = file.exists();
                PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
                if (!fileExists) {
                    writer.println("firstName,lastName,course,grade");
                }
                writer.println(student.toString());
                writer.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved successfully!");
                alert.showAndWait();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnView.setOnAction(e -> {
            try {
                File file = new File("grades.csv");
                if (file.exists()) {
                    Scanner scanner = new Scanner(file);
                    StringBuilder content = new StringBuilder();
                    while (scanner.hasNextLine()) {
                        content.append(scanner.nextLine()).append("\n");
                    }
                    scanner.close();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Grade Book Entries");
                    alert.setHeaderText("Saved Grades:");
                    alert.setContentText(content.toString());
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "grades.csv not found.");
                    alert.showAndWait();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Scene setup
        Scene scene = new Scene(grid, 400, 350);
        primaryStage.setTitle("Ahmmed GradeBook App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
