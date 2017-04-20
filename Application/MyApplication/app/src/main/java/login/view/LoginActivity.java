package login.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import login.presenter.ILoginPresenter;
import login.presenter.LoginPresenterCompl;
import login.view.ILoginView;
import myapplication.mask.com.myapplication.R;

/**
 * Created by mask on 2017/4/18.
 */

public class LoginActivity extends ActionBarActivity implements ILoginView,View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    ILoginPresenter loginPresenter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //find view

        editUser = (EditText)findViewById(R.id.et_login_username);
        editPass = (EditText)findViewById(R.id.et_login_password);
        btnLogin = (Button)findViewById(R.id.bt_login_login);
        btnClear = (Button)findViewById(R.id.bt_login_clear);
        progressBar = (ProgressBar)findViewById(R.id.progress_login);


        //set listener

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);


        //init

        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_login_clear:
                loginPresenter.clear();
                break;
            case R.id.bt_login_login:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                loginPresenter.doLogin(editUser.getText().toString(),editPass.getText().toString());
                break;


        }
    }

     @Override
    public void onClearText(){
         editUser.setText("");
         editPass.setText("");
     }

    @Override
    public void onLoginResult(Boolean result,int code){
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Login Fail,code="+code,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility){
        progressBar.setVisibility(visibility);
    }
}
