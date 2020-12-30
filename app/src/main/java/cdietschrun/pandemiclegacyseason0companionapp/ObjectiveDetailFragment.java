package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

public class ObjectiveDetailFragment extends Fragment
{
    private final String objectiveRegion;

    public ObjectiveDetailFragment(String objectiveRegion)
    {
        this.objectiveRegion = objectiveRegion;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View newView = inflater.inflate(R.layout.pls0_objective_detail_fragment, container, false);
        MaterialTextView regionNameTextView = newView.findViewById(R.id.objective_detail_region_name);
        regionNameTextView.setText(objectiveRegion);

        return newView;
    }
}
