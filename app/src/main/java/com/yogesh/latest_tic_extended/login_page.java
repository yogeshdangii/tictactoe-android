package com.yogesh.latest_tic_extended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_page extends AppCompatActivity {

    EditText player1 , player2 ;
    Button playbutton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        Intent gameplay;
        gameplay =  new Intent(getApplicationContext(), MAINGAME.class);


        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstplayer = player1.getText().toString();
                String secondplayer = player2.getText().toString();

                if(firstplayer.isEmpty() || secondplayer.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "enter name of both players" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                gameplay.putExtra("player1" , firstplayer);
                gameplay.putExtra("player2" , secondplayer);
                startActivity(gameplay);
                }
            }
        });
    }
    public void init (){
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        playbutton = findViewById(R.id.playbutton);
    }
}