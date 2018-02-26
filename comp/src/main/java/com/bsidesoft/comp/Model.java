package com.bsidesoft.comp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
    private String title;
    private Set<Runnable> listeners = new HashSet<>();

    public String title() {
        return title;
    }

    public void title(String t) {
        title = t;
        noti();
    }

    public void addListener(Runnable l) {
        listeners.add(l);
    }
    public void removeListener(Runnable l){
        listeners.remove(l);
    }

    private void noti() {
        for(Runnable r:listeners) r.run();
    }
}
