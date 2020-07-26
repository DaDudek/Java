package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.SceneChanger;
import main.LibraryApk;
import model.Library;
import model.User;

import java.io.IOException;

public class LoginPaneController {

    @FXML
    private TextField enterUserNameTextField;

    @FXML
    private Button startApkButton;

    private Library  library = Library.getInstance();
    private User user ;
    private SceneChanger sceneChanger = new SceneChanger();

    public User getUser() {
        return user;
    }

    public void initialize() {
        startApkButton.setOnAction(actionEvent -> {
                    library.addUser(enterUserNameTextField.getText());
                    user = library.getUser(enterUserNameTextField.getText());
                    sceneChanger.changeScene(actionEvent, "/fxml/mainPane.fxml");
                }
        );
    }


}
