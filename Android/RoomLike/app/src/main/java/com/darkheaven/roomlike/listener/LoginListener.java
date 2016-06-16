package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.fragment.LoginFragment;
import com.darkheaven.roomlike.sync.GetUser;

/**
 * Created by tinyiota on 5/31/16.
 */
public class LoginListener extends BaseListener {
    public LoginListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get(LoginFragment.NEW_USER_BUTTON))){

        }else if(v.equals(views.get(LoginFragment.LOGIN_BUTTON))){
            GetUser task = new GetUser();
            task.setListener(this);
            task.execute("http://10.0.2.2:8080/user/"
                    + ((EditText) views.get(LoginFragment.USER_NAME_EDITTEXT)).getText().toString() + "/"
                    + ((EditText) views.get(LoginFragment.PASSWORD_EDITTEXT)).getText().toString());
        }
    }

    @Override
    public void initViews() {
        super.initViews();
    }

    public void loginSuccess(){
        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
        MainActivity.changeScreen(MainActivity.GROCERY_SCREEN);
    }
}
