package controllers;

import exceptions.WrongDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.DataChecker;
import logic.SceneChanger;
import main.LibraryApk;
import model.Book;
import model.Library;

import java.util.InputMismatchException;

public class CreateBookPaneController {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField pagesTextField;

    @FXML
    private TextField languageTextField;

    @FXML
    private Label authorLabel;

    @FXML
    private Label pagesLabel;

    @FXML
    private Label languageLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Button addBookButton;

    private Library library = Library.getInstance();
    private SceneChanger sceneChanger = new SceneChanger();
    private DataChecker dataChecker = new DataChecker();




    public void initialize(){

        addBookButton.setOnAction(this::createBook);
        goBackButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.mainPanePath));


    }


    private void createBook(ActionEvent actionEvent){
        try{
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            int year = Integer.parseInt(yearTextField.getText());
            int pages = Integer.parseInt(yearTextField.getText());
            String language = languageTextField.getText();

            if (dataChecker.checkBookData(title,author,year,pages,language)){
                library.addPublication(new Book(title, author, year ,pages, language));
                sceneChanger.switchScene(actionEvent, LibraryApk.mainPanePath);
            }
            else {
                throw new WrongDataException("wrong data");
            }

        } catch (Exception exception){
            sceneChanger.openNewWindow(LibraryApk.errorPanePath);
        }}




}
