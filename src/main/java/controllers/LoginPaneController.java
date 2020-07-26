package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

    public User getUser() {
        return user;
    }

    public void initialize() {
        startApkButton.setOnAction(actionEvent -> {
                    library.addUser(enterUserNameTextField.getText());
                    user = library.getUser(enterUserNameTextField.getText());
                    try {
                        Scene secondScene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/mainPane.fxml")));
                        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        window.setScene(secondScene);
                        window.setTitle(LibraryApk.apkName);
                        window.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
