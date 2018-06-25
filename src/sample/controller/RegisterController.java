package sample.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField registerVarstaTField;

    @FXML
    private Button registerViewButton;

    @FXML
    private Button registerRegisterButton;

    @FXML
    private ChoiceBox<String> registerMateriaCBox;

    @FXML
    private Button registerExitButton;

    @FXML
    private TextField registerPrenumeTField;

    @FXML
    private TextField registerNumeTField;

    @FXML
    void initialize() {
        registerRegisterButton.setOnAction(event -> {
            System.out.println("Butonul REGISTER a fost apasat!");
        });
        registerViewButton.setOnAction(event -> {
            try {
                viewScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        registerExitButton.setOnAction(e -> {
            Platform.exit();
        });
    }
    public void viewScreenButtonPushed(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("../view/view.fxml"));
        Scene viewScene = new Scene(viewParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
}