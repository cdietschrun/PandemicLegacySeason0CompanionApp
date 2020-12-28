package cdietschrun.pandemiclegacyseason0companionapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<String> regions = new ArrayList<String>();
    private RecyclerView recyclerView;
    private RegionCitiesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RegionCitiesRecyclerViewAdapter(regions);
        recyclerView.setAdapter(adapter);
    }

    public void fabClick(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.region_fab)
               .setItems(R.array.regionsArray, new DialogInterface.OnClickListener()
               {
                   @RequiresApi(api = Build.VERSION_CODES.N)
                   public void onClick(DialogInterface dialog, int position)
                   {
                       String[] regionsArray = getResources().getStringArray(R.array.regionsArray);
                       Snackbar.make(view, regionsArray[position] + " chosen", Snackbar.LENGTH_LONG)
                               .setAction("Action", null)
                               .show();

                       regions.add(regionsArray[position]);
                       updateUI();
                   }
               });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateUI()
    {
        adapter.notifyDataSetChanged();
    }
}