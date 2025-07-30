package com.example.pizzaorder;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText etUsername, etEmail, etPassword;
    CheckBox checkboxTerms;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        checkboxTerms = findViewById(R.id.checkboxTerms);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!checkboxTerms.isChecked()) {
                Toast.makeText(this, "You must agree to the terms", Toast.LENGTH_SHORT).show();
                return;
            }

            new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Do you want to create the account?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    SharedPreferences prefs = getSharedPreferences("AbdPizzaPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("username", username);
                    editor.apply();

                    Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, MenuActivity.class);
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", null)
                .show();
        });
    }
}