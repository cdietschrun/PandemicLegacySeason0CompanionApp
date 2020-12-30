package cdietschrun.pandemiclegacyseason0companionapp.recyclerviews;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import cdietschrun.pandemiclegacyseason0companionapp.R;
import cdietschrun.pandemiclegacyseason0companionapp.fragments.ObjectiveDetailFragment;

public class ObjectiveCardRecyclerViewAdapter extends RecyclerView.Adapter<ObjectiveCardRecyclerViewAdapter.ObjectiveCardViewHolder>
{
    private FragmentActivity activity;
    private List<String> objectives;

    public ObjectiveCardRecyclerViewAdapter(List<String> objectives, FragmentActivity activity)
    {
        this.objectives = objectives;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ObjectiveCardViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int index)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                                  .inflate(R.layout.pls0_objective_card, viewGroup, false);
        return new ObjectiveCardViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(@NonNull ObjectiveCardViewHolder objectiveCardViewHolder, int position)
    {
        if (objectives != null && position < objectives.size())
        {
            String objectiveRegion = objectives.get(position);
            objectiveCardViewHolder.button.setText(objectiveRegion);

            // setup the linkage for the button to navigate to the details page for an objective
            objectiveCardViewHolder.button.setOnClickListener(clickedView ->
            {
                ObjectiveDetailFragment objectiveDetailFragment = new ObjectiveDetailFragment();

                Bundle bundle = new Bundle();
                bundle.putString("objectiveRegionName", objectiveRegion);
                Navigation.findNavController(objectiveCardViewHolder.itemView).navigate(R.id.action_objectiveMenuFragment_to_objectiveDetailFragment, bundle);
            });
        }
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
            button = itemView.findViewById(R.id.objective_detail_button);
        }
    }
}
