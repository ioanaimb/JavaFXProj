package sample.controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button welcomeExitButton;

    @FXML
    private Button welcomeRegisterButton;

    @FXML
    private Button welcomeViewButton;

    @FXML
    void initialize() {
        welcomeRegisterButton.setOnAction(event -> {
            try {
                registerScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeViewButton.setOnAction(event -> {
            try {
                viewScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeExitButton.setOnAction(e -> {
            Platform.exit();
        });
    }

    public void registerScreenButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        Scene registerScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }

    public void viewScreenButtonPushed(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("../view/view.fxml"));
        Scene viewScene = new Scene(viewParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
}