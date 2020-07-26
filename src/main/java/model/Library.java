package model;

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

    public List<Publication> getPublicationsMap() {
        return publicationsList;
    }

    public void setPublicationMap(List<Publication> publicationList) {
        this.publicationsList = publicationList;
    }

    private Library() {
    }

    public static Library getInstance(){
        if (single_instance == null){
            single_instance = new Library();
        }
        return single_instance;
    }

    public void addPublication(Publication publication) {
        if (publication == null) {
            throw new NullPointerException("can't add null position");
        } else {
            publicationsList.add(publication);
        }
    }

    public void removePublication(Publication publication){
        if (publication == null){
            throw new NullPointerException("can't remove null position");
        }
        publicationsList.remove(publication);
    }

    public User getUser(String email){
        return usersMap.get(email);
    }

    public void addUser(String email) {
        if (!checkUser(email)) {
            usersMap.put(email, new User(email));
        }
    }

    private boolean checkUser(String email){
        return usersMap.containsKey(email);
    }

    public Publication borrowPublication(String email, Publication publication){
        usersMap.get(email).borrowPublication(publication);
        return publication;
    }







}
