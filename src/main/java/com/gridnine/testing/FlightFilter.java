package com.gridnine.testing;

import com.gridnine.testing.filter.Filter;

import java.util.List;

public class FlightFilter {
    private Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Flight> filtration(List<Flight> flights) {
        return filter.filterMethod(flights);
    }
}
