package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorPaneController {

    @FXML
    private Button exitButton;

    @FXML
    private Label errorMessageLabel;


    public void initialize(){
        exitButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        });
    }

    public Label getErrorMessageLabel() {
        return errorMessageLabel;
    }

}
