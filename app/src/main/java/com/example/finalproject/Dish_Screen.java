package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public final class Dish_Screen extends AppCompatActivity {
    private static final String TAG = "Dish Screen";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_screen);
        findViewById(R.id.backToHome).setOnClickListener(v -> {
            Intent newintent = new Intent(this, Photo_Catcher.class);
            startActivity(newintent);
        });
        Intent intent = getIntent();
        final TextView json = findViewById(R.id.jsonDoc);
        json.setMovementMethod(new ScrollingMovementMethod());
        final Button show = findViewById(R.id.Show);
        show.setOnClickListener(v -> {
            json.setVisibility(View.VISIBLE);
            json.setText(Processor.resultText);
        });

    }
}
