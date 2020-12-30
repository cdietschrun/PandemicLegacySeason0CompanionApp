package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class ObjectiveDetailFragment extends Fragment
{
    private String objectiveRegion;
    private ObjectiveCitiesRecyclerViewAdapter adapter;

//    public ObjectiveDetailFragment(String objectiveRegion)
//    {
//        this.objectiveRegion = objectiveRegion;
//    }

    public void setRegion(String objectiveRegion)
    {
        this.objectiveRegion = objectiveRegion;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View newView = inflater.inflate(R.layout.pls0_objective_detail_fragment, container, false);

        MaterialTextView regionNameTextView = newView.findViewById(R.id.objective_detail_region_name);
        regionNameTextView.setText(objectiveRegion);

        List<String> cities = RegionCities.regionToCities.get(objectiveRegion);

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
