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
        private Button showOnlyBooksButton;

        @FXML
        private Button showOnlyComicBooksButton;

        @FXML
        private Button ShowOnlyNotBorrowedButton;

        @FXML
        private Button showUserBorrowedButton;

        @FXML
        private Button showUserReturnedHistoryButton;
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
    private Library library = Library.getInstance();

    public void initialize(){
        configureTableColumns();
        fillTable();
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

    private void fillTable() {
        ObservableList<Publication> items = mainTableView.getItems();
        items.addAll(library.getPublicationsList()); }

    public TableView<Publication> getMainTableView() {
        return mainTableView;
    }
}
