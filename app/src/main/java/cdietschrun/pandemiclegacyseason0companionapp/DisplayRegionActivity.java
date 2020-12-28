package cdietschrun.pandemiclegacyseason0companionapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

//@RequiresApi(api = Build.VERSION_CODES.R)
@RequiresApi(api = Build.VERSION_CODES.R)
public class DisplayRegionActivity extends AppCompatActivity
{
    public static List<String> europeCities = List.of("East Berlin",
                                        "Istanbul",
                                        "Kiev",
                                        "Leningrad",
                                        "London",
                                        "Madrid",
                                        "Moscow",
                                        "Paris",
                                        "Prague",
                                        "Rome",
                                        "Warsaw");

    public static List<String> northAmericaCities = List.of("Atlanta",
                                              "Havana",
                                              "Los Angeles",
                                              "Mexico City",
                                              "New York",
                                              "San Francisco",
                                              "Toronto",
                                              "Washington");

    public static List<String> southAmericaCities = List.of("Bogata",
                                              "Buenos Aires",
                                              "Lima",
                                              "Santiago",
                                              "São Paulo");

    public static List<String> africaCities = List.of("Algiers",
                                        "Cairo",
                                        "Johannesburg",
                                        "Khartoum",
                                        "Lagos",
                                        "Leopoldville");

    public static List<String> asiaCities = List.of("Baghdad",
                                      "Bangkok",
                                      "Bombay",
                                      "Calcutta",
                                      "Delhi",
                                      "Hanoi",
                                      "Karachi",
                                      "Novosibirsk",
                                      "Peking",
                                      "Pyongyang",
                                      "Riyadh",
                                      "Saigon",
                                      "Shanghai");

    public static List<String> pacificRimCities = List.of("Jakarta",
                                            "Manila",
                                            "Osaka",
                                            "Sydney",
                                            "Tokyo");

    static Map<String, List<String>> regionToCities = Map.of(
            "North America", northAmericaCities,
            "South America", southAmericaCities,
            "Europe", europeCities,
            "Africa", africaCities,
            "Asia", asiaCities,
            "Pacific Rim", pacificRimCities);

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display_region);
//
//        // get the intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        List<String> cities = regionToCities.get(message);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1,
//                cities.stream().toArray(String[]::new));
//
//        ListView listView = findViewById(R.id.regionListView);
//        listView.setAdapter(adapter);
//    }
}