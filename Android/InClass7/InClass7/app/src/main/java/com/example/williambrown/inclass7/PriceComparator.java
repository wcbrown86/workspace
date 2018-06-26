package com.example.williambrown.inclass7;

/**
 * Created by williambrown on 6/15/17.
 */

class PriceComparator implements java.util.Comparator<Tunes> {
    @Override
    public int compare(Tunes o1, Tunes o2) {

        return Double.compare(o1.getTrackPrice(), o2.getTrackPrice());

    }
}
