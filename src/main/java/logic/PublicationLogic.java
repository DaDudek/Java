package logic;

import exceptions.PublicationBorrowedException;
import exceptions.PublicationNotFoundException;
import model.Library;
import model.Publication;
import model.User;

public class PublicationLogic {
    private Library library = Library.getInstance();

    public PublicationLogic() {
    }

    public void addPublication(Publication publication) {
        if (publication == null) {
            throw new PublicationNotFoundException("can't add null position");
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
            Library.getInstance().getActualUser().getBorrowedPublication().add(publication);
            publication.setBorrowed(true);
        }
    }

    public void returnPublication(Publication publication){
        if (publication == null){
            throw new PublicationNotFoundException("can't return null position");
        }
        if (!Library.getInstance().getActualUser().getBorrowedPublication().contains(publication)){
            throw new PublicationBorrowedException("You can't return publication that you have not borrowed");
        }
        publication.setBorrowed(false);
        Library.getInstance().getActualUser().getReturnedPublications().add(publication);
        Library.getInstance().getActualUser().getBorrowedPublication().remove(publication);

    }
}
