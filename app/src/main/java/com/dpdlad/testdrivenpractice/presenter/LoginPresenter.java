package com.dpdlad.testdrivenpractice.presenter;

import android.support.annotation.NonNull;

/**
 * @author Praveen on 27/08/18.
 */
public interface LoginPresenter {

    int incrementLoginAttempt();

    void resetLoginAttempt();

    boolean isLoginAttemptExceeded();

    void doLoginWithCredentials(@NonNull String userName, @NonNull String password);

    interface LoginViewNotifier {

        void showErrorMessageForUserNamePassword();

        void showErrorMessageForMaxLoginAttempt();

        void showLoginSuccessMessage();

    }
}
