package com.gevor.comparators;

import com.gevor.domain.Record;

import java.util.Comparator;

public class PhoneNumberComparator implements Comparator<Record> {

    private final boolean ascending;

    public PhoneNumberComparator() {
        this.ascending = true;
    }

    public PhoneNumberComparator(boolean ascending) {
        this.ascending = ascending;
    }
    @Override
    public int compare(Record rec1, Record rec2) {
        if (rec2.getPhoneNumber() == null) {
            return (rec1.getPhoneNumber() == null) ? 0 : -1;
        }
        if (rec1.getPhoneNumber() == null) {
            return 1;
        }
        return ascending ? rec1.getPhoneNumber().compareTo(rec2.getPhoneNumber()) :
                rec2.getPhoneNumber().compareTo(rec1.getPhoneNumber());
    }
}
