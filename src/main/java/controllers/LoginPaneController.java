package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.SceneChanger;
import main.LibraryApk;
import model.Library;
import model.User;

public class LoginPaneController {

    @FXML
    private TextField enterUserNameTextField;

    @FXML
    private Button startApkButton;

    private Library  library = Library.getInstance();
    private User user ;
    private SceneChanger sceneChanger = new SceneChanger();

    public void initialize() {
        startApkButton.setOnAction(actionEvent -> {
                    library.addUser(enterUserNameTextField.getText());
                    user = library.findUser(enterUserNameTextField.getText());
                    sceneChanger.switchScene(actionEvent, LibraryApk.mainPanePath);
                    library.setActualUser(user);
                }
        );
    }


}
