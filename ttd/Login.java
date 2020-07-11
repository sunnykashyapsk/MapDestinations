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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button Butt;
    private TextView info,textView;
    private FirebaseAuth fbb;
    private FirebaseAuth.AuthStateListener mauth;
    private ProgressDialog pb;
    private RelativeLayout relativeLayout;
    private int set=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email =  findViewById(R.id.email);
        pass =  findViewById(R.id.pass);
        info = findViewById(R.id.join);
        Butt =  findViewById(R.id.login);
        textView=  findViewById(R.id.lsho);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, signup.class));
            }
        });


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

        fbb=FirebaseAuth.getInstance();
        FirebaseUser user=fbb.getCurrentUser();



        pb=new ProgressDialog(this);

        if (user!=null)
        {
           startActivity(new Intent(Login.this, Home.class));
        }
        Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uemail= email.getText().toString();
                String upass=pass.getText().toString();
                if (uemail.isEmpty()||upass.isEmpty())
                    Toast.makeText(Login.this,"Enter all details",Toast.LENGTH_SHORT).show();
                else {
                    pb.show();
                    pb.setMessage("Please Wait...");
                    fbb.signInWithEmailAndPassword(uemail, upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                pb.dismiss();
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, Home.class));
                                finish();
                            } else {
                                pb.dismiss();
                                Toast.makeText(Login.this, "Login Failed\nUsername 0r Password may be incorrect or Data may be off", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });


    }
}
