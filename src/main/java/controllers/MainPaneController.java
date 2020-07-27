package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
        configureTableColumns();
        createTestData();
        addBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createBookPane));
        addComicBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createComicBookPane));
    }

    private void configureTableColumns() {

        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTableColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        pagesTableColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));
        languageTableColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        publishingHouseTableColumn.setCellValueFactory(new PropertyValueFactory<>("publishingHouse"));
        howManyStoriesTableColumn.setCellValueFactory(new PropertyValueFactory<>("howManyStories"));
        borrowedTableColumn.setCellValueFactory(new PropertyValueFactory<>("borrowed"));
    }

    private void createTestData() {
        ObservableList<Publication> items = mainTableView.getItems();
        items.add(new Book("author", "title", 1, 1, "polish"));
        items.add(new Book("author1", "title1", 2, 2, "polish1"));
        items.add(new ComicBook("author", "title", 3,"DC",3));
        items.add(new ComicBook("author1", "title1", 4,"DC1",4));
    }

}
