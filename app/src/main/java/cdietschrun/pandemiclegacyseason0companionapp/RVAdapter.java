package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        //        TextView personName;
        ListView cardListView;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
//            personName = (TextView)itemView.findViewById(R.id.person_name);
            cardListView = itemView.findViewById(R.id.cardLv);
        }
    }

    List<String> regions;

//    RVAdapter(List<Person> persons){
//        this.persons = persons;
//    }

    RVAdapter(List<String> regions) {
        this.regions = regions;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
//        personViewHolder.personName.setText(persons.get(i).name);

        List<String> cities = DisplayRegionActivity.regionToCities.get(regions.get(i));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                personViewHolder.cv.getContext(), android.R.layout.simple_list_item_1,
                cities.stream().toArray(String[]::new));

//        ListView listView = findViewById(R.id.regionCitiesListView);
//                listView.setAdapter(adapter);
        personViewHolder.cardListView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }
}
