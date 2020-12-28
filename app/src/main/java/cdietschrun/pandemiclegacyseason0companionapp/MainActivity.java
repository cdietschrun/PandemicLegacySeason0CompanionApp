package cdietschrun.pandemiclegacyseason0companionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "cdietschrun.companionApp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Spinner spinner = (Spinner) findViewById(R.id.regionSpinner);
//        // create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.regionsArray,
//                android.R.layout.simple_spinner_item);
//        //specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //apply the adapter to the spinner
//        spinner.setAdapter(adapter);
    }

    public void fabClick(View view)
    {
//        Snackbar.make(view, "Here's a Snackbar3", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

// 2. Chain together various setter methods to set the dialog characteristics
//                builder.setMessage(R.string.dialog_message)
//                        .setTitle(R.string.dialog_title);
        builder.setTitle(R.string.region_fab)
                .setItems(R.array.regionsArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /** Called when the user taps the Send button */
//    public void sendMessage(View view) {
//        Intent intent = new Intent(this, DisplayRegionActivity.class);
////        EditText editText = (EditText) findViewById(R.id.);
////        String message = editText.getText().toString();
////        Spinner spinner = (Spinner) findViewById(R.id.regionSpinner);
//        String region = spinner.getSelectedItem().toString();
//        intent.putExtra(EXTRA_MESSAGE, region);
//        startActivity(intent);
//    }
}