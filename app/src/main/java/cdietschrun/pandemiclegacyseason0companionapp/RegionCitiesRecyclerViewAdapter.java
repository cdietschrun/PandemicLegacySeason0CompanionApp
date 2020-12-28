package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionCitiesRecyclerViewAdapter extends RecyclerView.Adapter<RegionCitiesRecyclerViewAdapter.RegionCitiesViewHolder>
{
    private List<String> regions;

    RegionCitiesRecyclerViewAdapter(List<String> regions)
    {
        this.regions = regions;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RegionCitiesViewHolder onCreateViewHolder(ViewGroup viewGroup, int index)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                               .inflate(R.layout.item, viewGroup, false);
        return new RegionCitiesViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(RegionCitiesViewHolder regionCitiesViewHolder, int index)
    {
        //        personViewHolder.personName.setText(persons.get(i).name);

        List<String> cities = DisplayRegionActivity.regionToCities.get(regions.get(index));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(regionCitiesViewHolder.cv.getContext(),
                android.R.layout.simple_list_item_1, cities.stream().toArray(String[]::new));

        //        ListView listView = findViewById(R.id.regionCitiesListView);
        //                listView.setAdapter(adapter);
        regionCitiesViewHolder.cardListView.setAdapter(adapter);
    }

    @Override
    public int getItemCount()
    {
        return regions.size();
    }

    public static class RegionCitiesViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        ListView cardListView;

        RegionCitiesViewHolder(View itemView)
        {
            super(itemView);
            cv = itemView.findViewById(R.id.cardView);
            cardListView = itemView.findViewById(R.id.cardListView);
        }
    }
}
