package com.example.execise6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.execise6.R;

public class Fragment2 extends Fragment {


    private Button baidu ;
    private Button  jinrexiaoyuan ;
    private Button xuexitong ;
    private View view ;

    public Fragment2() {
        super(R.layout.layout02);
        view = getView() ;
    }

    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

        baidu = (Button) view.findViewById(R.id.baidu) ;
        jinrexiaoyuan = (Button) getView().findViewById(R.id.jinrexiaoyuan) ;
        xuexitong = (Button) view.findViewById(R.id.xuexitong) ;

        baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent() ;
                intent.setAction("android.intent.action.VIEW") ;
                intent.setData(Uri.parse("http://www.baidu.com")) ;
                startActivity(intent);
                Log.e("MainActivity","start baidu") ;
            }
        });

        jinrexiaoyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =getActivity().getPackageManager().getLaunchIntentForPackage("com.wisedu.cpdaily");
                startActivity(intent);
                Log.e("MainActivity","start jinrexiaoyuan") ;
            }
        });

        xuexitong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.chaoxing.mobile");
                startActivity(intent);
                Log.e("MainActivity","start xuexitong") ;
            }
        });
    }


}