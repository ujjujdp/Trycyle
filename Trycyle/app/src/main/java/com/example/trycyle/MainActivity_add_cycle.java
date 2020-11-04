package com.example.trycyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trycyle.model.Cycle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity_add_cycle extends AppCompatActivity {


    EditText cycle_code,cycle_name;
    Button add_cycle;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_cycle);

        cycle_code=findViewById(R.id.cycle_id);
        cycle_name=findViewById(R.id.cycle_name);
        add_cycle=findViewById(R.id.submit);

        add_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("cycle/"+cycle_code.getText().toString());
                Cycle A=new Cycle(cycle_name.getText().toString(),cycle_code.getText().toString(),"0");

                myRef.setValue(A).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        toast("successfully added to firebase database");
                    }
                });
            }
        });




    }

    void toast(String a){
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();

    }
}