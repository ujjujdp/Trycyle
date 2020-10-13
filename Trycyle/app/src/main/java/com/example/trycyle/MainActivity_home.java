package com.example.trycyle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< master
import com.example.trycyle.model.Cycle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

=======
>>>>>>> master
public class MainActivity_home extends AppCompatActivity {

    EditText code;
    Button cycle_rent;
<<<<<<< master
    FirebaseDatabase database;
    FirebaseAuth mAuth;
=======
>>>>>>> master
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