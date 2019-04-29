package com.example.finalproject;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public final class Dish_Screen extends AppCompatActivity {
    private static final String TAG = "Dish Screen";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_screen);
        findViewById(R.id.backToHome).setOnClickListener(v -> {
            Intent newIntent = new Intent(this, Photo_Catcher.class);
            startActivity(newIntent);
        });
        final TextView json = findViewById(R.id.jsonDoc);
        json.setMovementMethod(new ScrollingMovementMethod());
        final TextView dish = findViewById(R.id.dishInfo);
        dish.setMovementMethod(new ScrollingMovementMethod());
        final Button show = findViewById(R.id.Show);
        show.setOnClickListener(v -> {
            json.setVisibility(View.VISIBLE);
            json.setText(Processor.resultText);
            showInfo();
        });
    }
    private void showInfo() {
        String result;
        final TextView info = findViewById(R.id.dishInfo);
        final ImageView dish = findViewById(R.id.dishImage);
        Drawable toShow;
        if (Processor.resultText.contains("Beef")) {
            result = Processor.readFromfile("beef/beef.txt", this);
            info.setText(result);
            toShow = Processor.loadPhoto("beef/beef.jpeg", this);
            dish.setImageDrawable(toShow);
        }
    }
}
