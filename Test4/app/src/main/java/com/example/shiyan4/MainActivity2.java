package com.example.shiyan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private  Button button3;
    private  Button button4;
    private  Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
                String Phone = intent.getStringExtra("Phone");
                String PassWord = intent.getStringExtra("Password");
                String VerCode = intent.getStringExtra("VerCode");


                TextView textview1 = (TextView) findViewById(R.id.textView3);
                TextView textview2 = (TextView) findViewById(R.id.textView2);
                TextView textview3 = (TextView) findViewById(R.id.textView4);

                textview1.setText(Phone);
                textview2.setText(PassWord);
                textview3.setText(VerCode);

                button3 = (Button)findViewById(R.id.button3);
                button4 = (Button)findViewById(R.id.button4);
                button5 = (Button)findViewById(R.id.button5);

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent();
                        intent1.setAction("android.intent.action.VIEW");
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.wisedu.cpdaily");
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.chaoxing.mobile");
                startActivity(intent);
            }
        });
    }

    public static void startAction(Context context, String Phone, String Password, String VerCode){
        Intent intent = new Intent(context,MainActivity2.class);
        intent.putExtra("Phone", Phone);
        intent.putExtra("Password", Password);
        intent.putExtra("VerCode", VerCode);
        context.startActivity(intent);
    }

}