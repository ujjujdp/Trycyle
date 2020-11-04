package com.example.trycyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trycyle.model.Cycle;
import com.example.trycyle.model.CycleTransaction;
import com.example.trycyle.model.RandomString;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;

import static com.example.trycyle.model.RandomString.*;


public class MainActivity_timer extends AppCompatActivity {

    TextView starttime,endtime;
    Button end;
    FirebaseDatabase database;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_timer);
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        String random=getAlphaNumericString(10);
        final DatabaseReference myRef = database.getReference("cycle_tranctions/"+currentUser.getUid()+"/"+random);
        Cycle current_cycle = new Cycle();
        if(getIntent().getExtras() != null){
           current_cycle = (Cycle) getIntent().getSerializableExtra("cycle");
        }
        starttime=findViewById(R.id.starttime);
        endtime=findViewById(R.id.endtime);
        end=findViewById(R.id.end_cycling);
// good for time difference
        final long start=SystemClock.uptimeMillis()/1000;
//        starttime.setText(String.valueOf(start));

        Date c= Calendar.getInstance().getTime();
        starttime.setText(c.toString());
        final Cycle finalCurrent_cycle = current_cycle;
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long end=SystemClock.uptimeMillis()/1000;
//                endtime.setText(String.valueOf(end));
                Date c=Calendar.getInstance().getTime();
                endtime.setText(c.toString());

                CycleTransaction cycle_tran = new CycleTransaction(finalCurrent_cycle,currentUser.getUid(),1,100);

                myRef.setValue(cycle_tran);

            }
        });
    }

    public void toast(String a) {
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
    }

}