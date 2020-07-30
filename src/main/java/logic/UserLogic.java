package logic;

import model.Library;
import model.User;

public class UserLogic {


    public UserLogic() {
    }

    public User findUser(String userName){
        return Library.getInstance().getUsersMap().get(userName);
    }

    public void addUser(String userName) {
        if (!checkUser(userName)) {
            Library.getInstance().getUsersMap().put(userName, new User(userName));
        }
    }

    private boolean checkUser(String userName){
        return Library.getInstance().getUsersMap().containsKey(userName);
    }

}
