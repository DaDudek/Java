package model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    public final static String fileName = "Library.obj";
    private Map<Integer, Publication> publicationMap= new HashMap<>();

    public Map<Integer, Publication> getPublicationMap() {
        return publicationMap;
    }

    public void setPublicationMap(Map<Integer, Publication> publicationMap) {
        this.publicationMap = publicationMap;
    }

    public Library() {
    }

    public void addPublication(Publication publication){
        publicationMap.put(publication.getId(), publication);
    }

    public void saveChanges(){
        try(    FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream ous = new ObjectOutputStream(fos) )
        {
            ous.writeObject(publicationMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
