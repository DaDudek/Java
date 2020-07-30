package InOut;

import logic.SceneChanger;
import model.Library;
import model.Publication;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySerializable {
    private SceneChanger sceneChanger = new SceneChanger();

    public void saveLibrary(){
        savePublication();
        saveUserMap();
    }

    public void loadLibrary(){
        loadPublication();
        loadUserMap();

    }

    private void savePublication(){
        try {
            FileOutputStream fileOut = new FileOutputStream(Library.publicationFileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Library.getInstance().getPublicationsList());
            objectOut.close();
            fileOut.close();
        } catch (Exception exception){
        }
    }

    private void saveUserMap(){
        try {
            FileOutputStream fileOut = new FileOutputStream(Library.userMapFileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Library.getInstance().getUsersMap());
            objectOut.close();
            fileOut.close();
        } catch (Exception exception){
        }
    }

    private void loadPublication(){
        try {
            String fileName = "";
            File file = new File(Library.publicationFileName);
            if (file.exists()){
                fileName = Library.publicationFileName;
            }
            else {
                fileName = "initial.obj";
            }
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Publication> publicationList = (ArrayList<Publication>) objectInputStream.readObject();
            Library.getInstance().setPublicationsList(publicationList);
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception exception){
        }
    }

    private void loadUserMap(){
        try {
            FileInputStream fileInputStream = new FileInputStream(Library.userMapFileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Map<String, User> userMap =(HashMap<String, User>) objectInputStream.readObject();
            Library.getInstance().setUsersMap(userMap);
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception exception){
        }
    }


}
