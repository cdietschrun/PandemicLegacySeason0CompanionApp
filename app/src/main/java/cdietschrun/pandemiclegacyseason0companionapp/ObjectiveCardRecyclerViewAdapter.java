package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class ObjectiveCardRecyclerViewAdapter extends RecyclerView.Adapter<ObjectiveCardRecyclerViewAdapter.ObjectiveCardViewHolder>
{
    private FragmentActivity activity;
    private List<String> objectives;

    ObjectiveCardRecyclerViewAdapter(List<String> objectives, FragmentActivity activity)
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
    public void onBindViewHolder(@NonNull  ObjectiveCardViewHolder objectiveCardViewHolder, int position)
    {
        if (objectives != null && position < objectives.size())
        {
            String objectiveRegion = objectives.get(position);
            objectiveCardViewHolder.button.setText(objectiveRegion);

            // setup the linkage for the button to navigate to the details page for an objective
            objectiveCardViewHolder.button.setOnClickListener(clickedView ->
            {
                ObjectiveDetailFragment objectiveDetailFragment = new ObjectiveDetailFragment();
                objectiveDetailFragment.setRegion(objectiveRegion);
                ((NavigationHost) activity).navigateTo(objectiveDetailFragment, true);
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
