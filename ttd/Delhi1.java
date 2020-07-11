package com.example.lenovo.ttd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Delhi1 extends AppCompatActivity {
    private CardView cardView1,cardView2,cardView3,cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi1);

        cardView1 = findViewById(R.id.citywalk);
        cardView2 = findViewById(R.id.cp);
        cardView3 = findViewById(R.id.ig);
        cardView4 = findViewById(R.id.nc);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi1.this, citywak.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi1.this, cp.class));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi1.this, ig.class));
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi1.this, Roxy.class));
            }
        });
    }
}
