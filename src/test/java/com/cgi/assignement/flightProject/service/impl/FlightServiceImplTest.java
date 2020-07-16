package com.cgi.assignement.flightProject.service.impl;

import com.cgi.assignement.flightProject.dao.FlightDataDao;
import com.cgi.assignement.flightProject.exception.ResourceNotFoundException;
import com.cgi.assignement.flightProject.model.FlightInfo;
import com.cgi.assignement.flightProject.model.FlightResults;
import com.cgi.assignement.flightProject.model.ItineraryInfo;
import com.cgi.assignement.flightProject.service.FlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceImplTest {

    @Autowired
    private FlightService flightService;

    @MockBean
    private FlightDataDao flightDataDao;

    @Test
    public void getFlightsResultsTest() {
        when(flightDataDao.getFlightResults()).thenReturn(new FlightResults(new ArrayList<ItineraryInfo>(), new ArrayList<FlightInfo>()));
        assertEquals(0, flightService.retrieveFlightResults().getItineraries().size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getFlightsWithNoValuesTest() {
        when(flightDataDao.getFlightResults()).thenThrow(new ResourceNotFoundException());
        flightService.retrieveFlightResults();
    }


}
