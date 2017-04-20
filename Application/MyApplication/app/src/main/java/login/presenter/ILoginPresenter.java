package login.presenter;

/**
 * Created by mask on 2017/4/18.
 */

public interface ILoginPresenter {

    void clear();
    void doLogin(String name,String passwd);
    void setProgressBarVisiblity(int visiblity);
}
