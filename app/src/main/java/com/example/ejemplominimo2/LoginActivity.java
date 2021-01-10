package com.example.ejemplominimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences mySharedPreferences;
    String username;

    public String getUsername(View v){
        EditText usernameContainer;
        usernameContainer = (EditText)findViewById(R.id.editTextTextPersonName);
        return usernameContainer.getText().toString();
    }

    public String getPassword(View v) {
        EditText passwordContainer;
        passwordContainer = (EditText) findViewById(R.id.editTextTextPassword);
        return passwordContainer.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mySharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);

        if(mySharedPreferences.getAll().size()!=0){
            username = (String)mySharedPreferences.getAll().get("Username");
            Toast.makeText(getApplicationContext(), "Welcome back, " + username + "!", Toast.LENGTH_SHORT).show();
            openMainActivity();
        }
    }

    public void onLoginClick(View v) {
        username = getUsername(v);
        String password = getPassword(v);
        if(username.equals("user") && password.equals("dsamola")){
            SharedPreferences.Editor editor = getSharedPreferences("mySharedPreferences", MODE_PRIVATE).edit();
            editor.putString("Username", username);
            editor.apply();
            openMainActivity();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong credentials.", Toast.LENGTH_SHORT).show();
        }
    }

    public void openMainActivity(){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

}