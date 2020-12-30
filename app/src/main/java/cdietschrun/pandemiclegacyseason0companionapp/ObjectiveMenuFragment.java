package cdietschrun.pandemiclegacyseason0companionapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveMenuFragment extends Fragment
{
    private List<String> objectives = new ArrayList<>();
    private ObjectiveCardRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.pls0_objective_menu_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // set up objective cards recyclerview
        adapter = new ObjectiveCardRecyclerViewAdapter(objectives, getActivity());
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.objective_view_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.objective_view_grid_spacing_small);
        recyclerView.addItemDecoration(new ObjectiveRecyclerViewItemDecoration(largePadding, smallPadding));

        // set up floating action button for adding a new objective to track
        FloatingActionButton fab = view.findViewById(R.id.fabAddObjective);
        fab.setOnClickListener(clickedView ->
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setTitle(R.string.add_objective_fab)
                   .setItems(R.array.regionsArray, (dialog, position) ->
                   {
                       String[] regionsArray = getResources().getStringArray(R.array.regionsArray);
                       Snackbar.make(clickedView, regionsArray[position] + " chosen", Snackbar.LENGTH_LONG)
                               .setAction("Action", null)
                               .show();

                       objectives.add(regionsArray[position]);
                       adapter.notifyDataSetChanged();
                   });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        return view;
    }
}
