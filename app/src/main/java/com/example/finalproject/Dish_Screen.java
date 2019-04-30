package com.example.finalproject;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
        final ConstraintLayout layout = findViewById(R.id.layout);
        layout.setBackground(Processor.loadPhoto("background.jpg", this));
        final TextView dish = findViewById(R.id.dishInfo);
        dish.setMovementMethod(new ScrollingMovementMethod());
        final Button show = findViewById(R.id.Show);
        show.setOnClickListener(v -> {
            showInfo();
        });
    }
    private void showInfo() {
        String result;
        final TextView info = findViewById(R.id.dishInfo);
        final ImageView dish = findViewById(R.id.dishImage);
        Drawable toShow;
        if (Processor.resultText.contains("Cow Leaf")) {
            result = Processor.readFromfile("beeftripe/beeftripe.txt", this);
            info.setText(result.replace("\\n", "\n"));
            toShow = Processor.loadPhoto("beeftripe/beeftripe.jpg", this);
            dish.setImageDrawable(toShow);
            return;
        }
        if (Processor.resultText.contains("Never Forget Chicken")) {
            result = Processor.readFromfile("chicken/chicken.txt", this);
            info.setText(result);
            toShow = Processor.loadPhoto("chicken/chicken.png", this);
            dish.setImageDrawable(toShow);
            return;
        }
        if (Processor.resultText.contains("Pork Belly")) {
            result = Processor.readFromfile("porkbelly/porkbelly.txt", this);
            info.setText(result.replace("\\n", "\n"));
            toShow = Processor.loadPhoto("porkbelly/porkbelly.png", this);
            dish.setImageDrawable(toShow);
            return;
        }
        if (Processor.resultText.contains("Sponge Gourd")) {
            result = Processor.readFromfile("spongegourd/spongegourd.txt", this);
            info.setText(result);
            toShow = Processor.loadPhoto("spongegourd/spongegourd.jpg", this);
            dish.setImageDrawable(toShow);
            return;
        }
        if (Processor.resultText.contains("Tofu")) {
            result = Processor.readFromfile("tofu/tofu.txt", this);
            info.setText(result);
            toShow = Processor.loadPhoto("tofu/tofu.jpg", this);
            dish.setImageDrawable(toShow);
            return;
        } else {
            toShow = Processor.loadPhoto("error.jpg",this);
            dish.setImageDrawable(toShow);
            info.setText("Sorry, this dish is not currently in the database.");
        }
    }
}
