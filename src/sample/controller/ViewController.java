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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> viewTView;

    @FXML
    private TableColumn<?, ?> viewPrenumeColumn;

    @FXML
    private TableColumn<?, ?> viewNumeColumn;

    @FXML
    private TableColumn<?, ?> viewMateriaColumn;

    @FXML
    private Button viewExitButton;

    @FXML
    private TableColumn<?, ?> viewVarstaColumn;

    @FXML
    private Button viewBackButton;


    @FXML
    void initialize() {
        viewBackButton.setOnAction(event -> {
            try {
                backScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        viewExitButton.setOnAction(e -> {
            Platform.exit();
        });
    }

    public void backScreenButtonPushed(ActionEvent event) throws IOException {
        Parent welcomeParent = FXMLLoader.load(getClass().getResource("../view/welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
}