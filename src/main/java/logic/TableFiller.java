package logic;

import controllers.LoginPaneController;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class TableFiller {

    private Library library = Library.getInstance();
    private LoginPaneController loginPaneController = new LoginPaneController();

    public List<Publication> getAllPublication(){return library.getPublicationsList();}

    public List<Publication> getUserReturned(User user) {return user.getReturnedPublications();}

    public List<Publication> getUserBorrowed(User user) {
        return user.getBorrowedPublication();
    }

    public List<Publication> getByContainsTitle(String title){
        List<Publication> listByKey = new ArrayList<>();
        List<Publication> publicationList = library.getPublicationsList();
        for (int i = 0; i < publicationList.size(); i++) {
            if (publicationList.get(i).getTitle().toLowerCase().contains(title.toLowerCase())){
                listByKey.add(publicationList.get(i));
            }
        }
        return listByKey;
    }

    public List<Publication> getOnlyNotBorrowed(){
        List<Publication> notBorrowedList = new ArrayList<>();
        List<Publication> publicationList = library.getPublicationsList();
        for (int i = 0; i < publicationList.size(); i++) {
            if (!publicationList.get(i).isBorrowed()){
                notBorrowedList.add(publicationList.get(i));
            }
        }
        return notBorrowedList;
    }

    public List<Publication> getOnlyComicBooks(){
        List<Publication> comicBookList = new ArrayList<>();
        List<Publication> publicationList = library.getPublicationsList();
        for (int i = 0; i < publicationList.size(); i++) {
            if (publicationList.get(i) instanceof ComicBook){
                comicBookList.add(publicationList.get(i));
            }
        }
        return comicBookList;
    }

    public List<Publication> getOnlyBooks(){
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
