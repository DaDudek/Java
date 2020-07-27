package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import logic.SceneChanger;
import main.LibraryApk;
import model.Book;
import model.ComicBook;
import model.Library;
import model.Publication;

import java.time.Year;

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
    private TableView<Publication> mainTableView;

    @FXML
    private TableColumn<Publication, String> titleTableColumn;

    @FXML
    private TableColumn<Publication, String> authorTableColumn;

    @FXML
    private TableColumn<Publication, Year> yearTableColumn;

    @FXML
    private TableColumn<Book, Integer> pagesTableColumn;

    @FXML
    private TableColumn<Book, String> languageTableColumn;

    @FXML
    private TableColumn<ComicBook, String> publishingHouseTableColumn;

    @FXML
    private TableColumn<ComicBook, Integer> howManyStoriesTableColumn;

    @FXML
    private TableColumn<Publication, Boolean> borrowedTableColumn;

    private SceneChanger sceneChanger = new SceneChanger();

    public void initialize(){
        addBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createBookPane));
        addComicBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createComicBookPane));
    }


}
