package logic;

import controllers.ErrorPaneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.LibraryApk;

import java.io.IOException;

public class SceneChanger {

    public void switchScene(ActionEvent actionEvent, String fxmlPath){
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

    public void openAndSetErrorWindow(String errorMessage){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(LibraryApk.errorPanePath));
        try {
            Parent tmp = loader.load();
            Scene errorScene = new Scene(tmp);
            Stage errorWindow = new Stage();
            errorWindow.setScene(errorScene);
            errorWindow.setTitle("error");

            ErrorPaneController controller = loader.getController();
            controller.getErrorMessageLabel().setText(errorMessage);
            errorWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
