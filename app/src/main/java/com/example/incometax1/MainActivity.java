package com.example.incometax1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText edtxt;
    TextView text1;
    TextView text2;
    Button but_go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt =findViewById(R.id.ed);
        text1=findViewById(R.id.tx1);
        text2=findViewById(R.id.tx2);
        but_go=findViewById(R.id.go);
        but_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Integer.parseInt(String.valueOf(edtxt.getText()));
                    calculate();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You have exceeded the Input Limit!",
                            Toast.LENGTH_LONG).show();
                    text1.setText("");
                }
            }
        });
    }
    public void calculate() //this funtion calculate tax based on individual income 
    {
        long Total = 0;
        long Tax=0;
        long in= Integer.parseInt(edtxt.getText().toString());
        if (in >= 200000 && in < 1000000)
        {
            Tax= (in * 5)/100;
            Total = in + Tax;
        }
        else if(in >= 1000000 && in < 2000000)
        {
            Tax = (in * 10)/100;
            Total = in + Tax;
        }
        else if(in >= 2000000 && in < 3000000)
        {
            Tax= (in * 15)/100;
            Total = in + Tax;
        }
        else if (in >= 3000000 && in < 4000000)
        {
            Tax = (in * 20)/100;
            Total = in + Tax;
        }
        else if(in >= 4000000 && in < 5000000)
        {
            Tax = (in * 25)/100;
            Total = in + Tax;
        }
        else if (in >= 5000000 && in < 7000000)
        {
            Tax = (in * 30)/100;
            Total = in + Tax;
        }
        else if (in >= 7000000 && in < 10000000)
        {
            Tax = (in * 35)/100;
            Total = in + Tax;
        }
        else if (in >= 10000000)
        {
            Tax = (in * 40)/100;
            Total = in + Tax;
        }
        text2.setText("Tax on your income "+edtxt.getText()+"= \t"+Tax+"\n \n"+
                "Total Income (Inclusion of Tax) "+"= \t"+Total);
    } }
