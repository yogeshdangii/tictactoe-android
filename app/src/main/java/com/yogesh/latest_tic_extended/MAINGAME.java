package com.yogesh.latest_tic_extended;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MAINGAME extends AppCompatActivity {

    Button btn1 ,btn2 , btn3, btn4,  btn5, btn6, btn7 , btn8 , btn9 , resetbut;
    TextView turn ;
    boolean flag = true;
    int count = 0;
    String player1, player2;
    Intent loginpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maingame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.maingame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginpage = getIntent();
        player1 =  loginpage.getStringExtra("player1");  // this one is x
         player2 =  loginpage.getStringExtra("player2"); // this one is o

        init();

        resetbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetfast();
            }
        });
    }
    public void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        resetbut = findViewById(R.id.resetbut);
        turn = findViewById(R.id.turn);
        turn.setText(player1 + " vs " + player2 );
    }
    public void Action (View view) {


        Button current = (Button) view;
        if (current.getText() != "X" && current.getText() != "O") {
            if (flag)
                current.setText("X");
            else
                current.setText("O");

            flag = !flag;
            count++;

        }

        if(count > 4 )
        {
            checks();
        }

    }



    public void reset(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count = 0;
                flag = !flag;
                Toast.makeText(getApplicationContext(), " <<-- RESET -->> " , Toast.LENGTH_SHORT).show();

            }
        } , 1000);


    }


    public void resetfast(){

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = !flag ;
        Toast.makeText(getApplicationContext(), " <<-- RESET -->> " , Toast.LENGTH_SHORT).show();
    }

    public void choosewinner(Button btncurr , boolean executed)
    {
        if(btncurr.getText() == "X") {
            Toast.makeText(this, player1 + " wins ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, player2 + " wins ", Toast.LENGTH_SHORT).show();

        }
        reset();
        executed = true;

    }
    public boolean winner(Button btn11,Button btn22,Button btn33)
    {
        if(btn11.getText() == btn22.getText() && btn22.getText() == btn33.getText() && (btn33.getText()== "X" || btn33.getText() == "O") )
        {
            return true;
        }

        return false;
    }



    public void checks()
    {

        boolean executed = false;

        if(winner(btn1,btn2,btn3) )
        {
           choosewinner(btn1, executed);
        }
        if(winner(btn4,btn5,btn6) )
        {
            choosewinner(btn4, executed);
        }
        if(winner(btn7,btn8,btn9) )
        {
            choosewinner(btn7, executed);
        }
        if(winner(btn1,btn4,btn7) )
        {
            choosewinner(btn1, executed);
        }
        if(winner(btn2,btn5,btn8) )
        {
            choosewinner(btn2, executed);
        }
        if(winner(btn3,btn6,btn9) )
        {
            choosewinner(btn3, executed);
        }
        if(winner(btn1,btn5,btn9) )
        {
            choosewinner(btn1, executed);
        }
        if(winner(btn3,btn5,btn7) )
        {
            choosewinner(btn3, executed);
        }

        if(count == 9 && !executed)
        {
            Toast.makeText(this, "It's a Tie ", Toast.LENGTH_SHORT).show();
            reset();
        }


    }


}