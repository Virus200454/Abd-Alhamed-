package com.example.pizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn = findViewById(R.id.startButton);
        btn.setOnClickListener(v -> startActivity(new Intent(this, MenuActivity.class)));
    }
}
