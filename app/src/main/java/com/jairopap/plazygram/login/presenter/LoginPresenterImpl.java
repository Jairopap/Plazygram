package com.jairopap.plazygram.login.presenter;
import com.jairopap.plazygram.login.Interactor.LoginInteractor;
import com.jairopap.plazygram.login.Interactor.LoginInteractorImpl;
import com.jairopap.plazygram.login.view.LoginView;

/**
 * Created by Administrador on 02/07/2017.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        interactor = new LoginInteractorImpl(this);
    }


    @Override
    public void singIn(String username, String password) {

        loginView.disableInputs();
        loginView.showProgresBar();
        interactor.singIn(username, password);

    }

    @Override
    public void loginSuccess() {
        loginView.goHome();

        loginView.hideProgresBar();
    }

    @Override
    public void loginError(String error) {
        loginView.enableInputs();
        loginView.hideProgresBar();
        loginView.loginError(error);
    }
}
