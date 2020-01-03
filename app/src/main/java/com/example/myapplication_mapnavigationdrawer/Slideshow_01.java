package com.example.myapplication_mapnavigationdrawer.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_mapnavigationdrawer.R;

public class Slideshow_01  extends AppCompatActivity {
    private Button button1;
    private EditText ed_1;
    private EditText ed_2;
    private EditText ed_3;
    private EditText ed_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.fragment_slideshow2 );
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener( new View.OnClickListener () {
            @Override
            public void onClick(View view){
                ed_1 = findViewById(R.id.ed_1);
                String ed1 = ed_1.getText().toString();
                ed_2 = findViewById(R.id.ed_2);
                String ed2 = ed_2.getText().toString();
                ed_3 = findViewById(R.id.ed_3);
                String ed3 = ed_3.getText().toString();
                ed_4 = findViewById(R.id.ed_4);
                String ed4 = ed_4.getText().toString();
                Intent i = new Intent (  );
                Bundle b = new Bundle (  );
                b.putString ( "ed_1", String.valueOf ( ed_1 ) );
                b.putString ( "ed_2", String.valueOf ( ed_2 ) );
                b.putString ( "ed_3", String.valueOf ( ed_3 ) );
                b.putString ( "ed_4", String.valueOf ( ed_4 ) );
                i.putExtras ( b );
                setResult ( 101,i );
                finish ();
            }
        });
    }
}
