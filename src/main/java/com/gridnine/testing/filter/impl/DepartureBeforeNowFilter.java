package com.gridnine.testing.filter.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.filter.Filter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeNowFilter implements Filter {
    @Override
    public List<Flight> filterMethod(List<Flight> flights) {

        List<Flight> filteredFlights = flights
                .stream()
                .filter(f -> f.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());

        return filteredFlights;
    }
}
