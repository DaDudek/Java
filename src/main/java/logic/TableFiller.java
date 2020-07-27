package logic;

import controllers.LoginPaneController;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class TableFiller {

    private Library library = Library.getInstance();
    private LoginPaneController loginPaneController = new LoginPaneController();

    public List<Publication> getPositionByCheckBox(boolean showBooks, boolean showComicBooks, boolean showNotBorrowed, boolean showMyBorrowed){
        if (showMyBorrowed){
        return getOnlyBorrowed(loginPaneController.getUser())
        } else if (showNotBorrowed){
            return getOnlyNotBorrowed();
        }
    }
    }

    private List<Publication> getOnlyBorrowed(User user) {
        return user.getBorrowedPublication();
    }

    private List<Publication> getOnlyNotBorrowed(){
        List<Publication> notBorrowedList = new ArrayList<>();
        List<Publication> publicationList = library.getPublicationsList();
        for (int i = 0; i < publicationList.size(); i++) {
            if (!publicationList.get(i).isBorrowed()){
                notBorrowedList.add(publicationList.get(i));
            }
        }
        return notBorrowedList;
    }

    private List<Publication> getAllComicBooks(){
        List<Publication> comicBookList = new ArrayList<>();
        List<Publication> publicationList = library.getPublicationsList();
        for (int i = 0; i < publicationList.size(); i++) {
            if (publicationList.get(i) instanceof ComicBook){
                comicBookList.add(publicationList.get(i));
            }
        }
        return comicBookList;
    }

    private List<Publication> getAllBooks(){
        List<Publication> bookList = new ArrayList<>();
        List<Publication> publicationList = library.getPublicationsList();
        for (int i = 0; i < publicationList.size(); i++) {
            if (publicationList.get(i) instanceof Book){
                bookList.add(publicationList.get(i));
            }
        }
        return bookList;
    }

}
