package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;
import java.util.List;

public interface Filter {
    List<Flight> filterMethod(List<Flight> flights);
}