package com.example.simple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class SelfDefineDialogFragment extends DialogFragment {
    private String[] genders = new String[] {"男","女"};
    private  SelfDefineDialogFragment.NotifyDialogListener listener;

    public static class NotifyDialogListener {
        public void onDialogPositiveClicked(String toString, String toString2 ){}
    }

    public void setListener(SelfDefineDialogFragment.NotifyDialogListener listener) {
        this.listener = listener;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custon_dialog,null);
        EditText editTextName1 = view.findViewById(R.id.editTextName1);
        EditText editTextName2 = view.findViewById(R.id.editTextName2);
        builder.setView(view)
                .setTitle("自定义对话框")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity().getApplicationContext(),"你确定了！",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity().getApplicationContext(),"你取消了",Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }

}
