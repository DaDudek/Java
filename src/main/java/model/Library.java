package model;

import exceptions.PublicationNotFoundException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    public final static String fileName = "Library.obj";
    private Map<Integer, Publication> publicationsMap = new HashMap<>();
    private Map<String, Publication> usersMap = new HashMap<>();

    public Map<Integer, Publication> getPublicationsMap() {
        return publicationsMap;
    }

    public void setPublicationMap(Map<Integer, Publication> publicationMap) {
        this.publicationsMap = publicationMap;
    }

    public Library() {
    }

    public void addPublication(Publication publication) {
        if (publication == null) {
            throw new NullPointerException("can't add null position");
        } else {
            publicationsMap.put(publication.getId(), publication);
        }
    }

    public void removePublication(Publication publication){
        if (publication == null){
            throw new NullPointerException("can't remove null position");
        }
        publicationsMap.remove(publication.getId());
    }




}
