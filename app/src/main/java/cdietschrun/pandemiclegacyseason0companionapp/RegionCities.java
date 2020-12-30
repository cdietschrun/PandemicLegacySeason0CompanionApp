package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.R)
public class RegionCities
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

    public static Map<String, List<String>> regionToCities = Map.of(
            "North America", northAmericaCities,
            "South America", southAmericaCities,
            "Europe", europeCities,
            "Africa", africaCities,
            "Asia", asiaCities,
            "Pacific Rim", pacificRimCities);
}