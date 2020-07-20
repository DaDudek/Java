package model;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Publication> publicationMap= new HashMap<>();

    public Map<Integer, Publication> getPublicationMap() {
        return publicationMap;
    }

    public void setPublicationMap(Map<Integer, Publication> publicationMap) {
        this.publicationMap = publicationMap;
    }

    public Library() {
    }
}
