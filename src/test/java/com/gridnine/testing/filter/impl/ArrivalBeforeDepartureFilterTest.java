package com.gridnine.testing.filter.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.FlightFilter;
import com.gridnine.testing.filter.Filter;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ArrivalBeforeDepartureFilterTest {

    @Test
    public void filter(){

        FlightFilter flightFilter = new FlightFilter();

        Filter filter = new ArrivalBeforeDepartureFilter();
        flightFilter.setFilter(filter);

        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

        List<Flight> testFligts = Arrays.asList(
                FlightBuilder.createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                FlightBuilder. createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)));

        List<Flight> correctResult = Arrays.asList(
                FlightBuilder.createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)));


        Assert.assertEquals(flightFilter.filtration(testFligts), correctResult);
    }

}