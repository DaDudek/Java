package exceptions;

public class PublicationBorrowedException extends RuntimeException{

    public PublicationBorrowedException(String message){
        super(message);
    }
}
