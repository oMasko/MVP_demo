package login.model;

/**
 * Created by mask on 2017/4/18.
 */

public class UserModel implements IUser {
    String name;
    String passwd;

    public UserModel(String name,String passwd){
        this.name = name;
        this.passwd = passwd;

    }

    public String getName(){
        return name;
    }
    public String getPasswd(){
        return passwd;
    }

    public int checkUserValidity(String name,String passwd){
        if (name == null||passwd==null||!name.equals(getName())||!passwd.equals(getPasswd())){
            return -1;
        }
        return 0;
    }
}
