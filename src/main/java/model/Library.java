package model;

import InOut.LibrarySerializable;
import exceptions.PublicationBorrowedException;
import exceptions.PublicationNotFoundException;

import java.io.*;
import java.util.*;

public class Library implements Serializable {
    public final static String publicationFileName = "Publication.obj";
    public final static String userMapFileName = "UserMap.obj";
    private static Library single_instance = new Library();
    private List<Publication> publicationsList = new ArrayList<>();
    private Map<String, User> usersMap = new HashMap<>();
    private User actualUser;


    private Library() {
    }




    public  List<Publication> getPublicationsList() {
        return publicationsList;
    }

    public static Library getInstance(){
        return single_instance;
    }

    public void setPublicationsList(List<Publication> publicationsList) {
        this.publicationsList = publicationsList;
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void setUsersMap(Map<String, User> usersMap) {
        this.usersMap = usersMap;
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(publicationsList, library.publicationsList) &&
                Objects.equals(usersMap, library.usersMap) &&
                Objects.equals(actualUser, library.actualUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationsList, usersMap, actualUser);
    }

    @Override
    public String toString() {
        return "Library" + publicationsList.size();
    }
}
