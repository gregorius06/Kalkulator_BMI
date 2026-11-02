package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        stage.setTitle("Kalkulator BMI - OOP dan GUI");
        tampilkanHome();
        stage.show();
    }

    public static void tampilkanHome() {
        gantiScene("/view/home.fxml", 480, 360);
    }

    public static void tampilkanForm() {
        gantiScene("/view/form-bmi.fxml", 480, 680);
    }

    private static void gantiScene(String fxml, double lebar, double tinggi) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource(fxml));
            Scene scene = new Scene(root, lebar, tinggi);
            scene.getStylesheets().add(MainApp.class.getResource("/view/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
        } catch (IOException e) {
            throw new RuntimeException("Gagal memuat " + fxml, e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
