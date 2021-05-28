package com.example.execise7.homework7;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.execise7.R;

import java.io.*;

public class InStorage extends Fragment implements View.OnClickListener {

    private TextView tv ;
    private Button btn1 ;
    private Button btn2 ;
    private String fname  ;
    private View view ;

    public InStorage() {
        super(R.layout.in_storage);
        view = getView() ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = (TextView) view.findViewById(R.id.editTextTextPersonName) ;
        btn1 = (Button) view.findViewById(R.id.button) ;
        btn2 = (Button) view.findViewById(R.id.button2) ;
        fname = "myText" ;

        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                putText();
                break;
            case R.id.button2:
                getText();
                break;
        }
    }

    void getText(){
        try {
            FileInputStream is = getContext().openFileInput(fname) ;
            BufferedReader reader = new BufferedReader(new InputStreamReader(is)) ;
            String value = reader.readLine() ;
            Toast toast = Toast.makeText(getContext(),value,Toast.LENGTH_SHORT) ;
            toast.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void putText(){
        try {
            String value = tv.getText().toString() ;
            FileOutputStream os = getContext().openFileOutput(fname, Context.MODE_PRIVATE) ;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os)) ;
            writer.write(value);
            writer.close();
            Toast toast = Toast.makeText(getContext(),"写入成功",Toast.LENGTH_SHORT) ;
            toast.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}