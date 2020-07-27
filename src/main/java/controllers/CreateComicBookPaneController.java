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
import model.ComicBook;
import model.Library;
import model.Publication;

import java.util.InputMismatchException;

public class CreateComicBookPaneController {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField publishingHouseTextField;

    @FXML
    private TextField howManyStoriesTextField;

    @FXML
    private Label authorLabel;

    @FXML
    private Label publishingHouseLabel;

    @FXML
    private Label howManyStoriesLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Button addComicBookButton;

    private SceneChanger sceneChanger = new SceneChanger();

    private Library library = Library.getInstance();

    public void initialize(){

        addComicBookButton.setOnAction(this::createComicBook);
        goBackButton.setOnAction(actionEvent -> sceneChanger.switchScene(actionEvent, LibraryApk.mainPanePath));


    }

    private boolean checkData(String title, String author, int year, String publishingHouse, int howManyStories){
        if (title.equals("")){
            return false;
        }
        if (author.equals("")){
            return false;
        }
        if (year < 0){
            return false;
        }
        if (howManyStories < 0) {
            return false;
        }
        if (publishingHouse.equals("")){
            return false;
        }
        return true;
    }

    private void createComicBook(ActionEvent actionEvent){
        try{
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            int year = Integer.parseInt(yearTextField.getText());
            String publishingHouse = publishingHouseTextField.getText();
            int howManyStories = Integer.parseInt(howManyStoriesTextField.getText());

            if (checkData(title,author,year,publishingHouse,howManyStories)){
                library.addPublication(new ComicBook(title, author, year ,publishingHouse, howManyStories));
            }
            else {
                throw new WrongDataException("wrong data");
            }

        } catch (InputMismatchException | WrongDataException exception){
            sceneChanger.openNewWindow(LibraryApk.errorPanePath);
        }}

}
