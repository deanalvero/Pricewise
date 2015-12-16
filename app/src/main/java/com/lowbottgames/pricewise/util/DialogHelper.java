package com.lowbottgames.pricewise.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Dean on 12/15/2015.
 */
public class DialogHelper {

    public static AlertDialog showErrorDialog(Context context, CharSequence message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setMessage(message);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
