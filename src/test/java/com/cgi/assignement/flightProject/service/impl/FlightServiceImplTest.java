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
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
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
        List<ItineraryInfo> itineraryInfos = new ArrayList<>();
        itineraryInfos.add(new ItineraryInfo("11",null, "2000", "abc", 3.5));
        when(flightDataDao.getFlightResults()).thenReturn(new FlightResults((ArrayList<ItineraryInfo>) itineraryInfos, new ArrayList<FlightInfo>()));
        assertEquals(1, flightService.retrieveFlightResults().getItineraries().size());
    }

    @Test
    public void getFlightsResultsWithNoLegsTest() {
        List<ItineraryInfo> itineraryInfos = new ArrayList<>();
        itineraryInfos.add(new ItineraryInfo("11",null, "2000", "abc", 3.5));
        when(flightDataDao.getFlightResults()).thenReturn(new FlightResults((ArrayList<ItineraryInfo>) itineraryInfos, new ArrayList<FlightInfo>()));
        assertEquals(true, flightService.retrieveFlightResults().getItineraries().get(0).getLegs()==null);
        assertThat(flightService.retrieveFlightResults().getItineraries().get(0).getLegs(), nullValue());
    }
    @Test(expected = ResourceNotFoundException.class)
    public void getFlightsWithNoValuesTest() {
        when(flightDataDao.getFlightResults()).thenThrow(new ResourceNotFoundException());
        flightService.retrieveFlightResults();
    }


}
