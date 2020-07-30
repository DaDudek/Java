package model;

import exceptions.PublicationBorrowedException;
import exceptions.PublicationNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private String userName;
    private List<Publication> borrowedPublication = new ArrayList<>();
    private List<Publication> returnedPublications = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public List<Publication> getBorrowedPublication() {
        return borrowedPublication;
    }

    public List<Publication> getReturnedPublications() {
        return returnedPublications;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(borrowedPublication, user.borrowedPublication) &&
                Objects.equals(returnedPublications, user.returnedPublications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, borrowedPublication, returnedPublications);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}