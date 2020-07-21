package model;

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

    public void addPublication(Publication publication){
        publicationsMap.put(publication.getId(), publication);
    }



}
