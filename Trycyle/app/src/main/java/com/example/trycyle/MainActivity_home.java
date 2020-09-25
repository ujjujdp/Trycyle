package com.example.trycyle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_home extends AppCompatActivity {

    EditText code;
    Button cycle_rent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        cycle_rent=findViewById(R.id.button);
        cycle_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    toast("SEARCHING");
            }
        });
    }

    public void toast(String a) {
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
    }


}