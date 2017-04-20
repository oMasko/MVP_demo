package login.model;

/**
 * Created by mask on 2017/4/18.
 */

public interface IUser {
    String getName();
    String getPasswd();
    int checkUserValidity(String name,String passwd);
}
