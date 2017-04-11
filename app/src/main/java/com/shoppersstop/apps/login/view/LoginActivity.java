package com.shoppersstop.apps.login.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.shoppersstop.apps.R;
import com.shoppersstop.apps.base.BaseActivity;
//import com.shoppersstop.apps.landing.view.LandingActivity;
import com.shoppersstop.apps.login.presenter.LoginPresenter;
import com.shoppersstop.apps.login.presenter.LoginPresenterImpl;


public class LoginActivity extends BaseActivity implements LoginView,View.OnClickListener {

    private ProgressBar mProgressBar;
    private EditText mUsername;
    private EditText mPassword;
    private Button mBtnLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar_login);
        mUsername = (EditText) findViewById(R.id.edittext_login_username);
        mPassword = (EditText) findViewById(R.id.edittext_login_password);
        mBtnLogin = (Button) findViewById(R.id.button_login);
        mBtnLogin.setOnClickListener(this);
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void setUsernameError() {
        mUsername.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        mPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToLanding() {
      //  startActivity(new Intent(this, LandingActivity.class));
        finish();
    }

    @Override
    public void showInProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideInProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
            mLoginPresenter.validateUserCredentials(mUsername.getText().toString(), mPassword.getText().toString());
    }
}
