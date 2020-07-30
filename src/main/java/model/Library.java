package model;

import exceptions.PublicationBorrowedException;
import exceptions.PublicationNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Serializable {
    public final static String fileName = "Library.obj";
    private static Library single_instance = null;
    private List<Publication> publicationsList = new ArrayList<>();
    private Map<String, User> usersMap = new HashMap<>();
    private User actualUser;


    private Library() {
    }

    public  List<Publication> getPublicationsList() {
        return publicationsList;
    }

    public static Library getInstance(){
        if (single_instance == null){
            single_instance = new Library();
        }
        return single_instance;
    }


    public void setPublicationMap(List<Publication> publicationList) {
        this.publicationsList = publicationList;
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }



    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }







}
