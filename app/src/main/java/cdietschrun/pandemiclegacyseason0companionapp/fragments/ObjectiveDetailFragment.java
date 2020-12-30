package cdietschrun.pandemiclegacyseason0companionapp.fragments;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import cdietschrun.pandemiclegacyseason0companionapp.recyclerviews.ObjectiveCitiesRecyclerViewAdapter;
import cdietschrun.pandemiclegacyseason0companionapp.recyclerviews.ObjectiveRecyclerViewItemDecoration;
import cdietschrun.pandemiclegacyseason0companionapp.R;
import cdietschrun.pandemiclegacyseason0companionapp.models.RegionCities;

public class ObjectiveDetailFragment extends Fragment
{
    private ObjectiveCitiesRecyclerViewAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String objectiveRegionName = ObjectiveDetailFragmentArgs.fromBundle(getArguments()).getObjectiveRegionName();

        View newView = inflater.inflate(R.layout.pls0_objective_detail_fragment, container, false);

        MaterialTextView regionNameTextView = newView.findViewById(R.id.objective_detail_region_name);
        regionNameTextView.setText(objectiveRegionName);

        List<String> cities = RegionCities.regionToCities.get(objectiveRegionName);

        RecyclerView recyclerView = newView.findViewById(R.id.objective_cities_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ObjectiveCitiesRecyclerViewAdapter(cities, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        int largePadding = getResources().getDimensionPixelSize(R.dimen.objective_view_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.objective_view_grid_spacing_small);
        recyclerView.addItemDecoration(new ObjectiveRecyclerViewItemDecoration(largePadding, smallPadding));

        return newView;
    }
}
