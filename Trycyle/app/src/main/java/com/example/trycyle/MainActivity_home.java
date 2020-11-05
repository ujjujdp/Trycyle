package com.example.trycyle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.example.trycyle.model.Cycle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


i

public class MainActivity_home extends AppCompatActivity {

    EditText code;
    Button cycle_rent;

    TextView result;
    FirebaseDatabase database;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        database=FirebaseDatabase.getInstance();
        code=findViewById(R.id.cycle_code);

        result=findViewById(R.id.textView2);
        cycle_rent=findViewById(R.id.button);
        //final long[] starttime = new long[1];
        cycle_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    toast("SEARCHING");
                final String cycle_code=code.getText().toString();
                DatabaseReference myRef = database.getReference("cycle/"+cycle_code);
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Cycle avi_cycle = snapshot.getValue(Cycle.class);
                        if(avi_cycle.getStatus().equals("0")){
                            result.setText("Free");
                            //starttime[0] =System.currentTimeMillis();
                            Intent intent=new Intent(MainActivity_home.this , MainActivity_timer.class);
                            intent.putExtra("cycle",avi_cycle);

                            DatabaseReference cycle_status = database.getReference("cycle/"+avi_cycle.getCode()+"/"+"status");
                            cycle_status.setValue("1");

                            startActivity(intent);

                        }
//                        if(snapshot.getValue()==1){result.setText("Taken");}
//                        else if(snapshot.getValue()==0){result.setText("Free");}
//                        else {result.setText("EROR");}


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });














//                String count="";
//                    for(int i=1;i<=5;i++){
//                        DatabaseReference myRef = database.getReference("cycle").child(Integer.toString(i));
//                        ValueEventListener listener=new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                Cycle a =snapshot.getValue(Cycle.class);
//                                toast(a.getStatus().toString());
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        };
//                        myRef.addValueEventListener(listener);
//
//
//
//                    }



               // result.setText(count);



            }
        });
    }

    public void toast(String a) {
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
    }


}