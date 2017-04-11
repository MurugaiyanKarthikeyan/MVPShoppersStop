package com.shoppersstop.apps.login.presenter;

import com.shoppersstop.apps.login.model.LoginInteractor;
import com.shoppersstop.apps.login.model.LoginInteractorImpl;
import com.shoppersstop.apps.login.view.LoginView;

/**
 * Created by S54164 on 4/6/2017.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListener  {
    private LoginView loginView;
    private LoginInteractor loginInteractor;
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }
    @Override
    public void validateUserCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showInProgress();
        }

        loginInteractor.login(username, password,this);
    }

    @Override public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideInProgress();
        }
    }

    @Override public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideInProgress();
        }
    }

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToLanding();
        }
    }
}
