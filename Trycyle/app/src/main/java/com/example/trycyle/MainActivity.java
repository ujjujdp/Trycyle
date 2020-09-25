package com.example.trycyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button signin,createAcc;
    EditText username,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buutons
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

