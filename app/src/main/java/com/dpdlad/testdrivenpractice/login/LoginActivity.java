package com.dpdlad.testdrivenpractice.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dpdlad.testdrivenpractice.R;
import com.dpdlad.testdrivenpractice.brands.MobileBrandListActivity;
import com.dpdlad.testdrivenpractice.login.presenter.LoginPresenter;
import com.dpdlad.testdrivenpractice.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginViewNotifier {


    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
    }


    private void initializeViews() {
        //Initialize presenter
        loginPresenter = new LoginPresenterImpl(this);

        //Initialize views
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLoginWithCredentials(edtUserName.getText().toString().trim(),
                        edtPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void showErrorMessageForUserNamePassword() {
        Snackbar.make(edtPassword, "Please check Username or Password.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(btnLogin, "You have exceeded MAX attempt.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(btnLogin, "Login successful.", Snackbar.LENGTH_LONG).show();
        startActivity(new Intent(this, MobileBrandListActivity.class));
    }
}
