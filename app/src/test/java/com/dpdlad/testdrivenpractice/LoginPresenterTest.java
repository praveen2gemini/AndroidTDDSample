package com.dpdlad.testdrivenpractice;

import com.dpdlad.testdrivenpractice.login.presenter.LoginPresenter;
import com.dpdlad.testdrivenpractice.login.presenter.LoginPresenterImpl;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * @author Praveen on 27/08/18.
 */
public class LoginPresenterTest {


    @Test
    public void checkLoginAttemptTest() {
        int incrementedValue;
        LoginPresenter.LoginViewNotifier loginView = mock(LoginPresenter.LoginViewNotifier.class);
        LoginPresenter loginPresenter = new LoginPresenterImpl(loginView);
        Assert.assertEquals(1, incrementedValue = loginPresenter.incrementLoginAttempt());
        System.out.println(incrementedValue);
        Assert.assertEquals(2, incrementedValue = loginPresenter.incrementLoginAttempt());
        System.out.println(incrementedValue);
        Assert.assertEquals(3, incrementedValue = loginPresenter.incrementLoginAttempt());
        System.out.println(incrementedValue);
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }
}
