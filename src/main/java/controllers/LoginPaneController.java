package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.SceneChanger;
import logic.UserLogic;
import main.LibraryApk;
import model.Library;
import model.User;

public class LoginPaneController {

    @FXML
    private TextField enterUserNameTextField;

    @FXML
    private Button startApkButton;

    private User user ;
    private final SceneChanger sceneChanger = new SceneChanger();
    private final UserLogic userLogic = new UserLogic();

    public void initialize() {
        startApkButton.setOnAction(actionEvent -> {
                    userLogic.addUser(enterUserNameTextField.getText());
                    user = userLogic.findUser(enterUserNameTextField.getText());
                    sceneChanger.switchScene(actionEvent, LibraryApk.mainPanePath);
                    Library.getInstance().setActualUser(user);
                }
        );
    }


}
