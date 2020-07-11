package com.example.lenovo.ttd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Ghaziabad extends AppCompatActivity {
    private CardView cardView1,cardView2,cardView3,cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghaziabad);

        cardView1 = findViewById(R.id.drizzing);
        cardView2 = findViewById(R.id.cityforest);
        cardView3=findViewById(R.id.wsm);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Ghaziabad.this, drizzing.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Ghaziabad.this, cityforest.class));
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Ghaziabad.this, wsm.class));
            }
        });


    }
}
