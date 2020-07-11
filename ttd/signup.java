package com.example.lenovo.ttd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Vector;

public class signup extends AppCompatActivity {
    private EditText fname,pass,email;
    private Button but;
    private FirebaseAuth fb;
    private TextView textView;
    private int set=1;
    private ProgressDialog pb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fname = findViewById(R.id.name);
        pass = findViewById(R.id.rpass);
        email = findViewById(R.id.remail);
        but= findViewById(R.id.sign);
        textView= findViewById(R.id.show);


        fb=FirebaseAuth.getInstance();
        pb=new ProgressDialog(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(set==1){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    textView.setText("Hide");
                    set=0;
                }
                else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    set=1;
                    textView.setText("Show");
                }
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee = fname.getText().toString();
                String useremail=email.getText().toString().trim();
                String userpass=pass.getText().toString().trim();
                if (namee.isEmpty() ||  useremail.isEmpty() || userpass.isEmpty()) {
                    Toast.makeText(signup.this, "Please Enter All Details", Toast.LENGTH_LONG).show();
                }
                else {
                    pb.show();
                    pb.setMessage("Please Wait...");
                    fb.createUserWithEmailAndPassword(useremail, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                pb.dismiss();
                                Toast.makeText(signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this, Login.class));
                                finish();
                            } else {
                                pb.dismiss();
                                Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

    }
}
