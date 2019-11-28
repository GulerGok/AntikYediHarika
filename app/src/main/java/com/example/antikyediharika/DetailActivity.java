package com.example.antikyediharika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.example.antikyediharika.MainActivity.selectedImage;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView wonderNameText = findViewById(R.id.wonderNameText);
        TextView countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent();
       String wonderName = intent.getStringExtra("name");
       String countryName = intent.getStringExtra("countryname");
       wonderNameText.setText(wonderName);
       countryNameText.setText(countryName);

       Singleton singleton = Singleton.getInstance();
       imageView.setImageBitmap(singleton.getChosenImage());

       // imageView.setImageBitmap(selectedImage);


    }
}
