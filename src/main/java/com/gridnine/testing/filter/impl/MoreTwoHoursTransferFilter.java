package com.gridnine.testing.filter.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.filter.Filter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MoreTwoHoursTransferFilter implements Filter {

    @Override
    public List<Flight> filterMethod(List<Flight> flights) {
        List<Flight> filteredFlights = flights
                .stream()
                .filter(f -> timeBetweenSegments(f) < 2)
                .collect(Collectors.toList());

        return filteredFlights;
    }

    private static long timeBetweenSegments(Flight f) {
        long transferTime = 0;
        for (int i = 0; i < f.getSegments().size() - 1; i++)
            transferTime += Duration
                    .between(f.getSegments().get(i).getArrivalDate(), f.getSegments().get(i + 1).getDepartureDate())
                    .toHours();

        return transferTime;
    }

}
