package com.example.pizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.btnLogin);
        Button signup = findViewById(R.id.btnSignup);
        login.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        signup.setOnClickListener(v -> startActivity(new Intent(this, SignupActivity.class)));
    }
}
