package com.example.simple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MultiChoiceDialogFragment extends DialogFragment {
    private String[] genders = new String[] {"男","女"};
    private MultiChoiceDialogFragment.NotifyDialogListener listener;

    public static class NotifyDialogListener {
        public void onDialogPositiveClicked(String gender) {
        }
    }
    public void setListener(MultiChoiceDialogFragment.NotifyDialogListener listener) {
        this.listener = listener;
    }

    ArrayList<String> selectedItems = new ArrayList();
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
              builder.setTitle("多选对话框")
                      .setMultiChoiceItems(genders, null, new DialogInterface.OnMultiChoiceClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                              if(isChecked) {

                                  selectedItems.add(genders[which]);
                              } else {
                                  selectedItems.remove(genders[which]);
                              }
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
