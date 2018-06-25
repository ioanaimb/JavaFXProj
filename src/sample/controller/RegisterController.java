package sample.controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
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
        registerMateriaCBox.setItems(FXCollections.observableArrayList("Matematica",
                "Fizica", "Chimie", "Biologie", "Arta"));
        registerRegisterButton.setOnAction(event -> {
            String nume = registerNumeTField.getText();
            String prenume = registerPrenumeTField.getText();
            int varsta = Integer.parseInt(registerVarstaTField.getText());
            String materia = registerMateriaCBox.getValue();
            addStudent(nume,prenume,varsta,materia);
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
    public void addStudent(String nume, String prenume, int varsta, String materia){
        String dbUrl = "jdbc:mysql://localhost/admin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "student";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            String insertDb = "insert into student"
                    + "(nume,prenume,varsta,materia)"
                    + "values ('"
                    + nume + "', '" + prenume + "'," +
                    varsta + ",'" + materia + "')";
            System.out.println(insertDb);
                myStmt.executeUpdate(insertDb);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}