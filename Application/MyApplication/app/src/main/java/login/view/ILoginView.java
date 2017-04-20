package login.view;

/**
 * Created by mask on 2017/4/18.
 */

public interface ILoginView {
    public void onClearText();
    public void onLoginResult(Boolean result,int code);
    public void onSetProgressBarVisibility(int visibility);
}
