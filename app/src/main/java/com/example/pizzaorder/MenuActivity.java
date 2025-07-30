package com.example.pizzaorder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    TextView welcomeText;
    Button startButton;
    Switch switchMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        welcomeText = findViewById(R.id.welcomeText);
        startButton = findViewById(R.id.startButton);
        switchMode = findViewById(R.id.switchMode);

        SharedPreferences prefs = getSharedPreferences("AbdPizzaPrefs", MODE_PRIVATE);
        String username = prefs.getString("username", "User");
        welcomeText.setText("Welcome, " + username + "!");

        startButton.setOnClickListener(v -> {
            Toast.makeText(this, "Starting your order...", Toast.LENGTH_SHORT).show();
        });

        switchMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Night Mode Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Night Mode Disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}