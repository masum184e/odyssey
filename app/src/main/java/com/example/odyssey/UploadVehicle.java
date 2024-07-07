package com.example.odyssey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UploadVehicle  extends AppCompatActivity implements  View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_vehicle);

        ImageView headerBackBtn=findViewById(R.id.headerBackBtn);
        headerBackBtn.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.headerBackBtn) {
            Intent intent = new Intent(this, BookingDetails.class);
            startActivity(intent);
        }
    }
}
