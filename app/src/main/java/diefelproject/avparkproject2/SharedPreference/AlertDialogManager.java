package diefelproject.avparkproject2.SharedPreference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import diefelproject.avparkproject2.R;

/**
 * Created by macbook on 9/12/16.
 */
public class AlertDialogManager {
    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     *               - pass null if you don't want icon
     * */
    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // setting dialog title
        alertDialog.setTitle(title);

        // setting dialog message
        alertDialog.setMessage(message);

        if(status != null)
            // setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.img_1950 : R.drawable.img_1950);

        // setting button ok
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // showing alert
        alertDialog.show();
    }
}