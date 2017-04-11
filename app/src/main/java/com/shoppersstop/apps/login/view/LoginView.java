package com.shoppersstop.apps.login.view;

import android.view.View;

import com.shoppersstop.apps.base.BaseView;

/**
 * Created by S54164 on 4/6/2017.
 */

public interface LoginView extends BaseView{
     void setUsernameError();
     void setPasswordError();
     void navigateToLanding();

}
