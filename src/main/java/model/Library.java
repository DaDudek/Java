package model;

import exceptions.PublicationNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Serializable {
    public final static String fileName = "Library.obj";
    private List<Publication> publicationsList = new ArrayList<>();
    private Map<String, User> usersMap = new HashMap<>();

    public List<Publication> getPublicationsMap() {
        return publicationsList;
    }

    public void setPublicationMap(List<Publication> publicationList) {
        this.publicationsList = publicationList;
    }

    public Library() {
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

    public void addUser(String email){
        usersMap.put(email,new User(email));
    }

    public Publication borrowPublication(String email, Publication publication){
        usersMap.get(email).borrowPublication(publication);
        return publication;
    }







}
