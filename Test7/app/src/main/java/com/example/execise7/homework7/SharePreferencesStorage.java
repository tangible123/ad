package com.example.execise7.homework7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.execise7.R;
import org.apache.commons.codec.binary.Hex ;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SharePreferencesStorage extends Fragment implements View.OnClickListener{

    private String fname  ;
    private TextView counter ;
    private TextView password ;
    private Button btn ;
    private View view ;

    public SharePreferencesStorage() {
        super(R.layout.storage_sharepreferences);
        view = getView() ;
        fname = "text" ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        counter = (TextView) view.findViewById(R.id.username) ;
        password = (TextView) view.findViewById(R.id.password) ;
        btn = (Button)view.findViewById(R.id.button5) ;
        SharedPreferences settings = getContext().getSharedPreferences(fname,Context.MODE_PRIVATE);

        counter.setText(settings.getString("username",""));
        password.setText(settings.getString("password",""));
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button5:
                puttext() ;
                login() ;
                break;
        }
    }

    private void puttext() {
        SharedPreferences settings = getContext().getSharedPreferences(fname,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = settings.edit();
        edit.putString("username",counter.getText().toString());
        //SHA256加密
        edit.putString("password",string2SHA256(password.getText().toString()));
        edit.commit();
    }

    private void login(){

        SharedPreferences settings = getContext().getSharedPreferences(fname,Context.MODE_PRIVATE);
        Toast toast = Toast.makeText(getContext(),"登录"+settings.getString("username",null).toString()
                ,Toast.LENGTH_SHORT);
        toast.show();
    }


    public static String string2SHA256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encodeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

}