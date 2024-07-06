package com.example.odyssey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingDetails  extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_details);

        TextView navbarText = findViewById(R.id.headerTitle);
        ImageView imageView = findViewById(R.id.headerBackBtn);

        navbarText.setText("Booking Details");
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.headerBackBtn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
