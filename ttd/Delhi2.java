package com.example.lenovo.ttd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Delhi2 extends AppCompatActivity {
    private CardView cardView1,cardView2,cardView3,cardView4,cardView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi2);

        cardView1 = findViewById(R.id.redfort);
        cardView2 = findViewById(R.id.ugrasen);
        cardView3 = findViewById(R.id.qutub);
        cardView4 = findViewById(R.id.lotus);
        cardView5 = findViewById(R.id.splashwater);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi2.this, Redfort.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi2.this, ugrasen.class));
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi2.this, qm.class));
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi2.this, Lotus.class));
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delhi2.this, Splashwater.class));
            }
        });

    }
}
