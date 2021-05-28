package com.example.simple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialogFragment extends DialogFragment {
    private String[] genders = new String[] {"男","女"};
    private SingleChoiceDialogFragment.NotifyDialogListener listener;

    public static class NotifyDialogListener {
        public void onDialogPositiveClicked(String gender) {
        }
    }
    public void setListener(SingleChoiceDialogFragment.NotifyDialogListener listener) {
        this.listener = listener;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("单择对话框")
                .setSingleChoiceItems(genders, 0,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogPositiveClicked(genders[which]);
                        //gender = genders[which];
                    }
                })
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
