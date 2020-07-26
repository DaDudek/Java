package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Library;
import model.User;

public class LoginPaneController {

    @FXML
    private TextField enterEmailTextField;

    @FXML
    private Button startApkButton;

    private Library  library = Library.getInstance();
    private User user ;

    public User getUser() {
        return user;
    }

    public void initialize(){
        startApkButton.setOnAction(actionEvent -> {
            library.addUser(enterEmailTextField.getText());
            user = library.getUser(enterEmailTextField.getText());
                }
        );
    }


}
