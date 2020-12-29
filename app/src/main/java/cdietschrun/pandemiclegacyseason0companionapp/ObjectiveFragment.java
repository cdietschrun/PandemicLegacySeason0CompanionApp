package cdietschrun.pandemiclegacyseason0companionapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveFragment extends Fragment
{
    private List<String> objectives = new ArrayList<String>();
    private ObjectiveCardRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.pls0_objective_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ObjectiveCardRecyclerViewAdapter(objectives);
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.objective_view_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.objective_view_grid_spacing_small);
        recyclerView.addItemDecoration(new ObjectiveRecyclerViewItemDecoration(largePadding, smallPadding));

        FloatingActionButton fab = view.findViewById(R.id.fabAddObjective);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

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

                               objectives.add(regionsArray[position]);
                               adapter.notifyDataSetChanged();
                           }
                       });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }
}
