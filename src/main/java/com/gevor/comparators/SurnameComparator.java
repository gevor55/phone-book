package com.gevor.comparators;

import com.gevor.domain.Record;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Record> {

    private final boolean ascending;

    public SurnameComparator() {
        this.ascending = true;
    }

    public SurnameComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Record rec1, Record rec2) {
        if (rec2.getSurname() == null) {
            return (rec1.getSurname()  == null) ? 0 : -1;
        }
        if (rec1.getSurname()  == null) {
            return 1;
        }
        return ascending ? rec1.getSurname().compareTo(rec2.getSurname() ) :
                rec2.getSurname() .compareTo(rec1.getSurname() );
    }
}
