package cdietschrun.pandemiclegacyseason0companionapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.R)
public class DisplayRegionActivity extends AppCompatActivity {

    List<String> europeCities = List.of("East Berlin",
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

    List<String> northAmericaCities = List.of("Atlanta",
                                              "Havana",
                                              "Los Angeles",
                                              "Mexico City",
                                              "New York",
                                              "San Francisco",
                                              "Toronto",
                                              "Washington");

    List<String> southAmericaCities = List.of("Bogata",
                                              "Buenos Aires",
                                              "Lima",
                                              "Santiago",
                                              "São Paulo");

    List<String> africaCities = List.of("Algiers",
                                        "Cairo",
                                        "Johannesburg",
                                        "Khartoum",
                                        "Lagos",
                                        "Leopoldville");

    List<String> asiaCities = List.of("Baghdad",
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

    List<String> pacificRimCities = List.of("Jakarta",
                                            "Manila",
                                            "Osaka",
                                            "Sydney",
                                            "Tokyo");

    Map<String, List<String>> regionToCities = Map.of(
            "North America", northAmericaCities,
            "South America", southAmericaCities,
            "Europe", europeCities,
            "Africa", africaCities,
            "Asia", asiaCities,
            "Pacific Rim", pacificRimCities);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_region);

        // get the intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // capture the layout's textview and set the string as its text
        TextView textView = findViewById(R.id.textView);

        textView.setText(regionToCities.get(message).toString());
    }
}