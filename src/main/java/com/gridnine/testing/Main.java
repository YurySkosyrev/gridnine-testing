package com.gridnine.testing;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.impl.DepartureBeforeNowFilter;
import com.gridnine.testing.filter.impl.MoreTwoHoursTransferFilter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();

        System.out.println("The original set of flights:");
        print(flights);

        System.out.println("Departure before the current time filter:");
        Filter filter = new DepartureBeforeNowFilter();
        flightFilter.setFilter(filter);
        print(flightFilter.filtration(flights));

        System.out.println("Arrival time before departure time filter:");
        Filter filter2 = new ArrivalBeforeDepartureFilter();
        flightFilter.setFilter(filter2);
        print(flightFilter.filtration(flights));

        System.out.println("Transfer time more 2 hours filter:");
        Filter filter3 = new MoreTwoHoursTransferFilter();
        flightFilter.setFilter(filter3);
        print(flightFilter.filtration(flights));

    }

    static void print(List<Flight> flights) {
        flights.forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------------->");
        System.out.println();
    }
}
