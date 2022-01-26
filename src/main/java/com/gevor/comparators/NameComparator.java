package com.gevor.comparators;

import com.gevor.domain.Record;

import java.util.Comparator;

public class NameComparator implements Comparator<Record> {

    private final boolean ascending;

    public NameComparator() {
        this.ascending = true;
    }

    public NameComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Record rec1, Record rec2) {
        if (rec2.getName() == null) {
            return (rec1.getName() == null) ? 0 : -1;
        }
        if (rec1.getName() == null) {
            return 1;
        }
        return ascending ? rec1.getName().compareTo(rec2.getName()) : rec2.getName().compareTo(rec1.getName());
    }
}
