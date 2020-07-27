package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import logic.SceneChanger;
import main.LibraryApk;
import model.Library;

public class MainPaneController {

    @FXML
    private TextField publicationTitleTextField;

    @FXML
    private Button addBookButton;

    @FXML
    private Button addComicBookButton;

    @FXML
    private Button deletePublicationButton;

    @FXML
    private Button borrowPublicationButton;

    @FXML
    private Button returnPublicationButton;

    @FXML
    private CheckBox showBooksCheckBox;

    @FXML
    private CheckBox showComicBookCheckBoox;

    @FXML
    private CheckBox showNotBorrowedCheckBox;

    @FXML
    private CheckBox showMyBorrowedCheckBox;

    @FXML
    private TableView<?> mainTableView;

    @FXML
    private TableColumn<?, ?> titleTableColumn;

    @FXML
    private TableColumn<?, ?> authorTableColumn;

    @FXML
    private TableColumn<?, ?> yearTableColumn;

    @FXML
    private TableColumn<?, ?> pagesTableColumn;

    @FXML
    private TableColumn<?, ?> languageTableColumn;

    @FXML
    private TableColumn<?, ?> publishingHouseTableColumn;

    @FXML
    private TableColumn<?, ?> howManyStoriesTableColumn;

    @FXML
    private TableColumn<?, ?> borrowedTableColumn;

    private SceneChanger sceneChanger = new SceneChanger();

    public void initialize(){
        addBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createBookPane));
        addComicBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createComicBookPane));
    }


}
