package com.example.huarondao;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    public void onBegin(View view) {
        Intent intent = new Intent(this,LevelSelectActivity.class);
        startActivity(intent);
        finish();
    }

    public void onExit(View view) {


    }


}
