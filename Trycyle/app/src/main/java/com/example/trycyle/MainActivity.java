package com.example.trycyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.trycyle.model.Cycle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button signin,createAcc;
    EditText username,password;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buttons

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);




        createAcc = findViewById(R.id.createAccount);
        signin=findViewById(R.id.signin);
        mAuth=FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"signIN",Toast.LENGTH_LONG).show();
                username=findViewById(R.id.username);
                password=findViewById(R.id.password);
                String u = username.getText().toString();
                String p = password.getText().toString();
                mAuth.signInWithEmailAndPassword(u,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            toast("user is loggined");
                            Intent intent=new Intent(MainActivity.this , MainActivity_home.class);
                            startActivity(intent);
                        }else{
                            toast(task.getException().toString());
                        }
                    }
                });
                //Intent intent=new Intent(MainActivity.this , Home.class);
                //startActivity(intent);
            }
        });

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("create accout");
                Intent intent=new Intent(MainActivity.this , CreateAccount.class);
                startActivity(intent);


            }
        });


    }

    void toast(String a){
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
    }
}

