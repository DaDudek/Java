package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.LibraryApk;

import java.io.IOException;

public class SceneChanger {

    public void changeScene(ActionEvent actionEvent, String fxmlPath){
        try{
            Scene secondScene = new Scene(FXMLLoader.load(getClass().getResource(fxmlPath)));
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(secondScene);
            window.setTitle(LibraryApk.apkName);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
