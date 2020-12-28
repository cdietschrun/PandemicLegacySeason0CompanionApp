package cdietschrun.pandemiclegacyseason0companionapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "cdietschrun.companionApp.MESSAGE";
    private List<String> regions;
    private RecyclerView recyclerView;
    private RVAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         TextView cardView = findViewById(R.id.person_name);
//         cardView.setText("test");

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeData();
        initializeAdapter();

//        Spinner spinner = (Spinner) findViewById(R.id.regionSpinner);
//        // create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.regionsArray,
//                android.R.layout.simple_spinner_item);
//        //specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //apply the adapter to the spinner
//        spinner.setAdapter(adapter);

//        regions.add("test");
//        RecyclerView recyclerView = findViewById(R.id.regionCitiesRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mAdapter = new RegionCitiesAdapter(regions);
//        recyclerView.setAdapter(mAdapter);
    }

    private void initializeData(){
        regions = new ArrayList<String>();
//        people.add(new Person("Emma Wilson"));
    }

    private void initializeAdapter(){
        mAdapter = new RVAdapter(regions);
        recyclerView.setAdapter(mAdapter);
    }

    public void fabClick(View view) {
//        Snackbar.make(view, "Here's a Snackbar3", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

// 2. Chain together various setter methods to set the dialog characteristics
//                builder.setMessage(R.string.dialog_message)
//                        .setTitle(R.string.dialog_title);
        builder.setTitle(R.string.region_fab)
                .setItems(R.array.regionsArray, new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        String[] some_array = getResources().getStringArray(R.array.regionsArray);
                        Snackbar.make(view, "Here's a Snackbar3: " + some_array[which], Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

//                        people.add(new Person("fucku"));
                        regions.add(some_array[which]);
//                        regions.add(some_array[which]);
                        updateUI();
//                        List<String> cities = DisplayRegionActivity.regionToCities.get(some_array[which]);
//
////                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), )
//
//                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                                view.getContext(), android.R.layout.simple_list_item_1,
//                                cities.stream().toArray(String[]::new));
//
//                        ListView listView = findViewById(R.id.regionCitiesListView);
//                        listView.setAdapter(adapter);
                    }
                });

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateUI()
    {
        mAdapter.notifyDataSetChanged();
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