package ness.edu.dialogs;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pickTheTime(View view) {
        TimePickerDialog dialog = new TimePickerDialog(this,
                this, 10, 22, true);
        dialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    public void showStandardDialog(View view) {
        //https://developer.android.com/guide/topics/ui/dialogs.html
        //title, Message, positiveButton, negativeButton

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // DialogInterface.OnClickListener
        builder.setTitle("The app requires Internet to proceed")
                .setMessage("Do you want to quit?")
                .setPositiveButton("Quit", this)
                .setNegativeButton("Stay", this);
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();

        AlertDialog dialog = builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case AlertDialog.BUTTON_POSITIVE:
               // Toast.makeText(this, "Quiting...", Toast.LENGTH_SHORT).show();
                System.exit(0);
                //finish();
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                Toast.makeText(this, "Staying...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showListDialog(View view) {//title, And setItems...
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final String[] colors = {"Red", "Green", "Blue"};


        String[] stringArray = getResources().getStringArray(R.array.toppings);
        
        builder.setTitle("Pick A Color:");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedColor = colors[which];
                Toast.makeText(MainActivity.this, selectedColor, Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}
