package main;

import InOut.LibrarySerializable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Library;


public class LibraryApk extends Application {
    public static final String apkName= "Library apk by Dawid";
    public static final String mainPanePath ="/fxml/mainPane.fxml";
    public static final String loginPanePath ="/fxml/loginPane.fxml";
    public static final String errorPanePath ="/fxml/errorPane.fxml";
    public static final String createBookPane ="/fxml/createBookPane.fxml";
    public static final String createComicBookPane ="/fxml/createComicBookPane.fxml";





    public static void main(String[] args) {
        LibrarySerializable librarySerializable = new LibrarySerializable();
        librarySerializable.loadLibrary();
        launch(args);
        librarySerializable.saveLibrary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane startPane = FXMLLoader.load(getClass().getResource(loginPanePath));
        Scene scene = new Scene(startPane);
        stage.setScene(scene);
        stage.setTitle(apkName);
        stage.show();
    }
}
