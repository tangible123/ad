package com.example.simple;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onSimpleButtonClicked(View view){
        SimpleDialogFragment dialog=new SimpleDialogFragment();
        dialog.show(getSupportFragmentManager(),"simple");
    }

    public void onChoiceButtonClicked(View view) {
        ChoiceDialogFragment dialog = new ChoiceDialogFragment();
        dialog.setListener(new ChoiceDialogFragment.NotifyDialogListener() {
            @Override
            public void onDialogPositiveClicked(String gender) {
                Toast.makeText(getApplicationContext(),"你选择了:"+gender,Toast.LENGTH_SHORT).show();
            }
        });
          dialog.show(getSupportFragmentManager(),"choice");
    }

    public void onSingleChoiceButtonClicked(View view) {
        SingleChoiceDialogFragment dialog = new SingleChoiceDialogFragment();
        dialog.setListener(new SingleChoiceDialogFragment.NotifyDialogListener() {
            @Override
            public void onDialogPositiveClicked(String gender) {
                Toast.makeText(getApplicationContext(),"你选择了:"+gender,Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show(getSupportFragmentManager(),"choice");
    }

    public void onMultiChoiceButtonClicked(View view) {
        MultiChoiceDialogFragment dialog = new MultiChoiceDialogFragment();
        dialog.setListener(new MultiChoiceDialogFragment.NotifyDialogListener() {
            @Override
            public void onDialogPositiveClicked(String gender) {
                Toast.makeText(getApplicationContext(),"你选择了:"+gender,Toast.LENGTH_SHORT).show();
            }

        });
        dialog.show(getSupportFragmentManager(),"choice");
    }

    public void onSelfDefineButton(View view){
        SelfDefineDialogFragment dialog = new SelfDefineDialogFragment();
        dialog.setListener(new SelfDefineDialogFragment.NotifyDialogListener(){
            @Override
            public void onDialogPositiveClicked(String toString, String toString2) {
                Toast.makeText(MainActivity.this, toString + toString2, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show(this.getSupportFragmentManager(),"heheh");
    }

    public void onOldButtonClicked(View view) {
        AlertDialog dialog;
        dialog = new AlertDialog.Builder(this).setTitle("旧版对话框")
                .setMessage("这是旧版的对话框，使用简单\n但是没有自动支持屏幕翻转!")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你确定了!",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你取消了",Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        dialog.show();
    }

}