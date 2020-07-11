package com.example.lenovo.ttd;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class Home extends AppCompatActivity {
    private EditText editText,editText2,editText3,editText4,editText5;
    private Button button,button2,button3,button4,button5;
    private TextView textView;
    private int q,w,e,r,t;
    private int hour,min,hx,mx;
    private FirebaseAuth firebaseAuth;
    private TimePickerDialog timePickerDialog;
    private AutoCompleteTextView autoCompleteTextView;
    String[] Locations={"Delhi","Ghaziabad","Merrut","Anoopshahr","Noida","Aligarh","Agra",
            "Chandigarh","Uttrakhand","Greater Noida","Nanital","Visac","Mumbai"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editText = findViewById(R.id.hst);
        editText2 = findViewById(R.id.mst);
        editText3 = findViewById(R.id.het);
        editText4 = findViewById(R.id.met);
        button = findViewById(R.id.settime);
        textView = findViewById(R.id.caltime);
        button2 = findViewById(R.id.search);
        button3 = findViewById(R.id.et);
        button4 = findViewById(R.id.st);
        button5 = findViewById(R.id.current);
        autoCompleteTextView = findViewById(R.id.locations);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR);
                min = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Home.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        editText.setText(String.valueOf(i));
                        editText2.setText(String.valueOf(i1));
                    }
                }, hour, min, true);
                timePickerDialog.show();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                hour= calendar.get(Calendar.HOUR);
                min = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Home.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        editText3.setText(String.valueOf(i));
                        editText4.setText(String.valueOf(i1));
                    }
                }, hour, min, true);
                timePickerDialog.show();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q = Integer.parseInt(editText.getText().toString());
                w = Integer.parseInt(editText2.getText().toString());
                e = Integer.parseInt(editText3.getText().toString());
                r = Integer.parseInt(editText4.getText().toString());
                t = (e - q) * 60 + (r - w);
                textView.setText("     You have " + Integer.toString(t) + " Minutes");
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, Locations);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setAdapter(arrayAdapter);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String places= autoCompleteTextView.getText().toString();
                q = Integer.parseInt(editText.getText().toString());
                w = Integer.parseInt(editText2.getText().toString());
                e = Integer.parseInt(editText3.getText().toString());
                r = Integer.parseInt(editText4.getText().toString());
                t = (e - q) * 60 + (r - w);

                if( t<=200 && q>=10 && e<17 && places.equals("Delhi")){
                    startActivity(new Intent(Home.this, Delhi2.class));
                }
                else if( t>200 && places.equals("Delhi")){
                    startActivity(new Intent(Home.this, Delhi1.class));
                }
                else if(t>200 && q>=10 && e<=17 && places.equals("Agra")){
                    startActivity(new Intent(Home.this, Agra1.class));
                }
                else if( q>=10 && e<=20 && places.equals("Anoopshahr")){
                    startActivity(new Intent(Home.this, Anoop.class));
                }
                else if(q>=10 && e<=18 && t<240 && places.equals("Ghaziabad")){
                    startActivity(new Intent(Home.this, Ghaziabad.class));
                }
                else if(q>=10 && e<=17 && t>100 && places.equals("Noida")){
                    startActivity(new Intent(Home.this, Noida1.class));
                }
                else if( q>=10 && e<=22 && t>100 && places.equals("Greater Noida")){
                    startActivity(new Intent(Home.this, Noida2.class));
                }
                else if(q>=10 && e<=19 && t>380 && places.equals("Uttrakhand")){
                    startActivity(new Intent(Home.this, Uk.class));
                }
                else {
                    Toast.makeText(Home.this,"No Such Places",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.logout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(Home.this, Login.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
