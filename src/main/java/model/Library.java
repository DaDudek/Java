package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
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
