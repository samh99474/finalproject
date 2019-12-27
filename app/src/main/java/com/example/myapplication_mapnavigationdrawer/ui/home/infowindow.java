package com.example.myapplication_mapnavigationdrawer.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication_mapnavigationdrawer.MainActivity;
import com.example.myapplication_mapnavigationdrawer.R;

public class infowindow extends AppCompatActivity {

    private Button back ;
    private Button reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infowindow);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        reservation = findViewById(R.id.reservation);
        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(infowindow.this,"您已成功預約",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
