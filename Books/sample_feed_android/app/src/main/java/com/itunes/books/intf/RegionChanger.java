package com.itunes.books.intf;

import java.util.ArrayList;

public interface RegionChanger {
    ArrayList<RegionChangeListener> REGION_CHANGE_LISTENERS = new ArrayList<>();

    void addOnRegionChangeListener(RegionChangeListener regionChangeListener);
}
