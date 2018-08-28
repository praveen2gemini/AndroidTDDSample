package com.dpdlad.testdrivenpractice.presenter;

import android.support.annotation.NonNull;

/**
 * @author Praveen on 27/08/18.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final LoginViewNotifier loginView;
    private int loginAttempt;

    public LoginPresenterImpl(LoginViewNotifier loginView) {
        this.loginView = loginView;
    }

    @Override
    public int incrementLoginAttempt() {
        loginAttempt = loginAttempt + 1;
        return loginAttempt;
    }

    @Override
    public void resetLoginAttempt() {
        loginAttempt = 0;
    }

    @Override
    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }


    @Override
    public void doLoginWithCredentials(@NonNull String userName, @NonNull String password) {
        if (isLoginAttemptExceeded()) {
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }

        if (userName.equals("test") && password.equals("test")) {
            loginView.showLoginSuccessMessage();
            resetLoginAttempt();
            return;
        }

        // increment login attempt only if it's fail
        incrementLoginAttempt();
        loginView.showErrorMessageForUserNamePassword();
    }
}
