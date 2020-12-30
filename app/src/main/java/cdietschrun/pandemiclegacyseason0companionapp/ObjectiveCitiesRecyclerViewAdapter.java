package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ObjectiveCitiesRecyclerViewAdapter extends RecyclerView.Adapter<ObjectiveCitiesRecyclerViewAdapter.ObjectiveCitiesViewHolder>
{
    private FragmentActivity activity;
    private List<String> cities;

    ObjectiveCitiesRecyclerViewAdapter(List<String> cities, FragmentActivity activity)
    {
        this.cities = cities;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ObjectiveCitiesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                                  .inflate(R.layout.pls0_objective_cities_card, viewGroup, false);
        return new ObjectiveCitiesViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(@NonNull ObjectiveCitiesViewHolder objectiveCitiesViewHolder, int position)
    {
        if (cities != null && position < cities.size())
        {
            String cityName = cities.get(position);
            objectiveCitiesViewHolder.checkbox.setText(cityName);
            objectiveCitiesViewHolder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) ->
                    Snackbar.make(buttonView, buttonView.getText() + " chosen", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show());
        }
    }

    @Override
    public int getItemCount()
    {
//        return cities.size();
        return 3;
    }


    public static class ObjectiveCitiesViewHolder extends RecyclerView.ViewHolder
    {
        MaterialCheckBox checkbox;

        ObjectiveCitiesViewHolder(View itemView)
        {
            super(itemView);
            checkbox = itemView.findViewById(R.id.objective_city_checkbox);
        }
    }
}
