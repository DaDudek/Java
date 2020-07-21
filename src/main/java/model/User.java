package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String emailAddress;
    private List<Publication> borrowedPublication = new ArrayList<>();
    private List<Publication> returnedPublications = new ArrayList<>();

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Publication> getBorrowedPublication() {
        return borrowedPublication;
    }

    public List<Publication> getReturnedPublications() {
        return returnedPublications;
    }

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User(){}
}