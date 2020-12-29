package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class ObjectiveCardRecyclerViewAdapter extends RecyclerView.Adapter<ObjectiveCardRecyclerViewAdapter.ObjectiveCardViewHolder>
{
    private List<String> objectives;

    ObjectiveCardRecyclerViewAdapter(List<String> objectives)
    {
        this.objectives = objectives;
    }

    @Override
    public ObjectiveCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int index)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                                  .inflate(R.layout.objective_card, viewGroup, false);
        return new ObjectiveCardViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(ObjectiveCardViewHolder objectiveCardViewHolder, int position)
    {
        if (objectives != null && position < objectives.size())
        {
            String objectiveRegion = objectives.get(position);
            objectiveCardViewHolder.button.setText(objectiveRegion);
        }
        //        personViewHolder.personName.setText(persons.get(i).name);


//        List<String> cities = RegionCities.regionToCities.get(regions.get(index));

//        Log.i("christag", cities.toString());

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(objectiveCardViewHolder.cv.getContext(),
//                android.R.layout.simple_list_item_1, cities.stream()
//                                                           .toArray(String[]::new));

        //        ListView listView = findViewById(R.id.regionCitiesListView);
        //                listView.setAdapter(adapter);
//        objectiveCardViewHolder.cardListView.setAdapter(adapter);
    }

    @Override
    public int getItemCount()
    {
        return objectives.size();
    }

    public static class ObjectiveCardViewHolder extends RecyclerView.ViewHolder
    {
        MaterialButton button;

        ObjectiveCardViewHolder(View itemView)
        {
            super(itemView);
            button = itemView.findViewById(R.id.regionButton);
        }
    }
}
