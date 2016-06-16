package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/31/16.
 */
public class LoginFragment extends BaseFragment {
    EditText usernameField;
    EditText passwordField;
    Button loginButton;
    Button newUserButton;

    public static final String USER_NAME_EDITTEXT = "USER_NAME_EDITTEXT";
    public static final String PASSWORD_EDITTEXT = "PASSWORD_EDITTEXT";
    public static final String LOGIN_BUTTON = "LOGIN_BUTTON";
    public static final String NEW_USER_BUTTON = "NEW_USER_BUTTON";

    public LoginFragment(){}

    public static BaseFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        usernameField = (EditText)rootView.findViewById(R.id.user_name);
        passwordField = (EditText)rootView.findViewById(R.id.password);
        loginButton = (Button)rootView.findViewById(R.id.login_button);
        newUserButton = (Button)rootView.findViewById(R.id.new_user_button);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView(USER_NAME_EDITTEXT, usernameField);
        listener.registerView(PASSWORD_EDITTEXT, passwordField);
        listener.registerView(LOGIN_BUTTON, loginButton);
        listener.registerView(NEW_USER_BUTTON, newUserButton);
        loginButton.setOnClickListener(listener);
        newUserButton.setOnClickListener(listener);
    }
}
