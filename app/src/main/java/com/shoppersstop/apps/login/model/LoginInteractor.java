package com.shoppersstop.apps.login.model;

/**
 * Created by S54164 on 4/6/2017.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(final String username,final String password,OnLoginFinishedListener loginFinishedListener);
}
