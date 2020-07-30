package logic;

import exceptions.PublicationBorrowedException;
import exceptions.PublicationNotFoundException;
import model.Library;
import model.Publication;
import model.User;

public class PublicationLogic {
    private Library library = Library.getInstance();
    private User user;

    public PublicationLogic() {
    }

    public PublicationLogic(User user) {
        this.user = user;
    }

    public void addPublication(Publication publication) {
        if (publication == null) {
            throw new NullPointerException("can't add null position");
        } else {
            library.getPublicationsList().add(publication);
        }
    }

    public void removePublication(Publication publication){
        if (publication == null){
            throw new NullPointerException("can't remove null position");
        }
        if (publication.isBorrowed()){
            throw new PublicationBorrowedException("can't remove borrowed publication");
        }
        if (!library.getPublicationsList().contains(publication)){
            throw new PublicationNotFoundException("publication is available in library");
        }
        library.getPublicationsList().remove(publication);
    }

    public void borrowPublication(Publication publication){
        if (publication == null){
            throw new PublicationNotFoundException("can't borrow null position");
        }
        if (publication.isBorrowed()){
            throw new PublicationBorrowedException("this publication is already borrowed");
        }
        else {
            user.getBorrowedPublication().add(publication);
            publication.setBorrowed(true);
        }
    }

    public void returnPublication(Publication publication){
        if (user.getBorrowedPublication().contains(publication)){
            publication.setBorrowed(false);
            user.getReturnedPublications().add(publication);
            user.getBorrowedPublication().remove(publication);
        }
        throw new PublicationNotFoundException("You are not allowed to return publication that you have not borrowed");
    }
}
