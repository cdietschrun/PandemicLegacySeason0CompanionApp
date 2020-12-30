package cdietschrun.pandemiclegacyseason0companionapp.models;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Objective
{
    static final AtomicInteger NEXT_ID = new AtomicInteger(0);
    private final Integer id = NEXT_ID.getAndIncrement();
    private String name = "";
    private String regionName;
    private List<String> cities;

    public Objective(String regionName)
    {
        this.regionName = regionName;
    }

    public Integer getId()
    {
        return id;
    }

    public String getRegionName()
    {
        return regionName;
    }
}
