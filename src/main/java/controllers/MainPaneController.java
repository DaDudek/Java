package controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import logic.PublicationLogic;
import logic.SceneChanger;
import logic.TableFiller;
import main.LibraryApk;
import model.*;

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
        private Button showAllPublicationButton;

        @FXML
        private Button showOnlyBooksButton;

        @FXML
        private Button showOnlyComicBooksButton;

        @FXML
        private Button showOnlyNotBorrowedButton;

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
    private TableFiller tableFiller = new TableFiller();
    private PublicationLogic publicationLogic = new PublicationLogic();

    public void initialize(){
        configureTableColumns();
        showAllPublication();
        addBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createBookPane));
        addComicBookButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.createComicBookPane));
        deletePublicationButton.setOnAction(actionEvent -> removePublication());
        borrowPublicationButton.setOnAction(actionEvent -> borrowPublication());
        returnPublicationButton.setOnAction(actionEvent -> returnPublication());
        showAllPublicationButton.setOnAction(actionEvent -> showAllPublication());
        showOnlyBooksButton.setOnAction(actionEvent -> showOnlyBooks());
        showOnlyComicBooksButton.setOnAction(actionEvent -> showOnlyComicBooks());
        showOnlyNotBorrowedButton.setOnAction(actionEvent -> showOnlyNotBorrowed());
        showUserBorrowedButton.setOnAction(actionEvent -> showUserBorrowed(library.getActualUser()));
        showUserReturnedHistoryButton.setOnAction(actionEvent -> showUserReturnedHistory(library.getActualUser()));



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
        publicationTitleTextField.addEventFilter(KeyEvent.KEY_RELEASED, event -> lookByTitle(publicationTitleTextField.getText()));

    }

    private void showOnlyBooks(){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getOnlyBooks());
    }

    private void showAllPublication(){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getAllPublication());
    }

    private void showOnlyComicBooks(){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getOnlyComicBooks());
    }

    private void showOnlyNotBorrowed(){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getOnlyNotBorrowed());
    }

    private void showUserReturnedHistory(User user){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getUserReturned(user));
    }

    private void showUserBorrowed(User user){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getUserBorrowed(user));
    }

    private void lookByTitle(String text){
        mainTableView.getItems().clear();
        mainTableView.getItems().addAll(tableFiller.getByContainsTitle(text));
    }

    private Publication getPublicationByClick(){
        return mainTableView.getSelectionModel().getSelectedItem();
    }

    private void removePublication(){
        Publication publication = getPublicationByClick();
        try {
            publicationLogic.removePublication(publication);
            showAllPublication();
        }
        catch (Exception exception){
            sceneChanger.openAndSetErrorWindow(exception.getMessage());
        }
    }

    private void borrowPublication(){
        Publication publication = getPublicationByClick();
        try {
            publicationLogic.borrowPublication(publication);
            showAllPublication();
        }
        catch (Exception exception){
            sceneChanger.openAndSetErrorWindow(exception.getMessage());
        }
    }

    private void returnPublication(){
        Publication publication = getPublicationByClick();
        try {
            publicationLogic.returnPublication(publication);
            showAllPublication();
        }
        catch (Exception exception){
            sceneChanger.openAndSetErrorWindow(exception.getMessage());
        }
    }
}
