package controllers;

import exceptions.WrongDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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



    public void initialize(){

        addBookButton.setOnAction(this::createBook);
        goBackButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.mainPanePath));


    }

    private boolean checkData(String title, String author, int year, int pages, String language){
        if (title.equals("")){
            return false;
        }
        if (author.equals("")){
            return false;
        }
        if (year < 0){
            return false;
        }
        if (pages < 0) {
            return false;
        }
        if (language.equals("")){
            return false;
        }
        return true;
    }

    private void createBook(ActionEvent actionEvent){
        try{
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            int year = Integer.parseInt(yearTextField.getText());
            int pages = Integer.parseInt(yearTextField.getText());
            String language = languageTextField.getText();

            if (checkData(title,author,year,pages,language)){
                library.addPublication(new Book(title, author, year ,pages, language));
            }
            else {
                throw new WrongDataException("wrong data");
            }

        } catch (InputMismatchException | WrongDataException exception){
            sceneChanger.openNewWindow(LibraryApk.errorPanePath);
        }}




}
