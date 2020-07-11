package com.example.lenovo.ttd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Noida2 extends AppCompatActivity {
    private CardView cardView1,cardView2,cardView3,cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noida2);

        cardView1 = findViewById(R.id.grandvenice);
        cardView2 = findViewById(R.id.akshardham);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Noida2.this, tgv.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Noida2.this, aksh.class));
            }
        });

    }
}
