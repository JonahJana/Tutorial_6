package com.example.tutorial_6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DrawingCanvas dCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dCanvas = findViewById(R.id.myCanvas);
        dCanvas.pathColour = Color.YELLOW;
    }
}
