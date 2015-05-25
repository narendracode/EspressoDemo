package com.hello.espresso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    EditText userNameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button signupButton;
    TextView msgTextView;
    public static final String  INVALID_LOGIN_MESSAGE = "Username/Password incorrect, please try again." ;

    public LoginActivity(){
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginButton = (Button)findViewById(R.id.loginButton);
        signupButton = (Button)findViewById(R.id.signupButton);
        userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        msgTextView = (TextView) findViewById(R.id.msgTextView);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(username !=null && password !=null && username.equals(password)){
                    msgTextView.setText("");
                    //invoke home activity
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    msgTextView.setText(INVALID_LOGIN_MESSAGE);
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

