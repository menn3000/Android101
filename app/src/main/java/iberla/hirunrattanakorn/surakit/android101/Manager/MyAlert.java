package iberla.hirunrattanakorn.surakit.android101.Manager;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import iberla.hirunrattanakorn.surakit.android101.R;

/**
 * Created by Menn on 10/8/2560.
 */

public class MyAlert {

    private Context context;


    // constructior
    public MyAlert(Context context) {
        this.context = context;
    } // constructior


    public void myDialog(String strTitel, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false); // ie modal dialog
        builder.setIcon(R.mipmap.ic_name);
        builder.setTitle(strTitel);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss(); // click and dismiss
            }//onClick
        });//setPositiveButton

        builder.show();


    }//myDialog

}//Class MyAlert
