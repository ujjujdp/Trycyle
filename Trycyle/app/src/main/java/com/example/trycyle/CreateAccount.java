package com.example.trycyle;

import  com.example.trycyle.model.user;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {

    Button createAcc;
    EditText username,password,email;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAuth=FirebaseAuth.getInstance();

        username=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.Password);
        createAcc=findViewById(R.id.create_account);

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("create account in create page");
                String u=email.getText().toString();
                String p=password.getText().toString();
                mAuth.createUserWithEmailAndPassword(u,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            database = FirebaseDatabase.getInstance();
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            DatabaseReference myRef = database.getReference("user/"+currentUser.getUid());

                            user a=new user("Akash",7);
                            myRef.setValue(a);
                            toast(currentUser.getUid());

                        }else{
                            toast(task.getException().toString());
                        }
                    }
                });
            }
        });

    }

    void toast(String a){
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();

    }
}