package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import logic.SceneChanger;

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
    private CheckBox showBooksButton;

    @FXML
    private CheckBox showComicBookButton;

    @FXML
    private CheckBox showNotBorrowedButton;

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
        
    }


}
