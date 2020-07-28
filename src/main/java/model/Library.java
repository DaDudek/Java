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

    //publications part

    public void setPublicationMap(List<Publication> publicationList) {
        this.publicationsList = publicationList;
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

    //users part

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public User findUser(String userName){
        return usersMap.get(userName);
    }

    public void addUser(String userName) {
        if (!checkUser(userName)) {
            usersMap.put(userName, new User(userName));
        }
    }

    private boolean checkUser(String userName){
        return usersMap.containsKey(userName);
    }

    public Publication borrowPublication(String userName, Publication publication){
        usersMap.get(userName).borrowPublication(publication);
        return publication;
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }







}
