package com.example.odyssey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingDetails extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_details);

        // IMAGES
        int[] imageIds = {
                R.drawable.car1,
                R.drawable.car2,
                R.drawable.car3,
                R.drawable.car4,
                R.drawable.car5
        };

        // TITLE
        TextView navbarText = findViewById(R.id.headerTitle);
        ImageView imageView = findViewById(R.id.headerBackBtn);
        navbarText.setText("Booking Details");
        imageView.setOnClickListener(this);

        // MAIN IMAGE
        ImageView mainCarImage = findViewById(R.id.main_car_image);
        mainCarImage.setImageResource(imageIds[0]);

        // IMAGE SLIDER
        LinearLayout imageContainer = findViewById(R.id.horizontal_images_container);
        for (int imageId : imageIds) {
            ImageView horizontalImage = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    300,
                    150
            );
            params.setMargins(10, 0, 10, 0);
            horizontalImage.setLayoutParams(params);
            horizontalImage.setImageResource(imageId);

            horizontalImage.setId(View.generateViewId());
            horizontalImage.setOnClickListener(new View.OnClickListener() {
                private final int id = imageId;

                @Override
                public void onClick(View view) {
                    mainCarImage.setImageResource(id);
                }
            });

            imageContainer.addView(horizontalImage);
        }

        Button reviewBtn=findViewById(R.id.reviewBtn);
        Button aboutBtn=findViewById(R.id.aboutBtn);
        LinearLayout carDetailsTabContainer = findViewById(R.id.carDetailsTabContainer);
        View aboutCarView = getLayoutInflater().inflate(R.layout.about_car, carDetailsTabContainer, false);
        carDetailsTabContainer.addView(aboutCarView);
        reviewBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.headerBackBtn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.reviewBtn) {
            updateCarDetailsContent(R.layout.car_review);
        } else if (view.getId() == R.id.aboutBtn) {
            updateCarDetailsContent(R.layout.about_car);
        }
    }
    private void updateCarDetailsContent(int layoutId) {
        LinearLayout carDetailsTabContainer = findViewById(R.id.carDetailsTabContainer);
        carDetailsTabContainer.removeAllViews();
        View aboutCarView = getLayoutInflater().inflate(layoutId, carDetailsTabContainer, false);
        carDetailsTabContainer.addView(aboutCarView);
    }
}
