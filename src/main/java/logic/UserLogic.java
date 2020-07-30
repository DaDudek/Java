package logic;

import model.Library;
import model.User;

public class UserLogic {
    private Library library = Library.getInstance();
    private User user;

    public UserLogic(User user) {
        this.user = user;
    }

    public User findUser(String userName){
        return library.getUsersMap().get(userName);
    }

    public void addUser(String userName) {
        if (!checkUser(userName)) {
            library.getUsersMap().put(userName, new User(userName));
        }
    }

    private boolean checkUser(String userName){
        return library.getUsersMap().containsKey(userName);
    }

}
