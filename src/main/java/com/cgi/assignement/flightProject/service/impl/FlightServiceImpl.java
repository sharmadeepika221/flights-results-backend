package com.cgi.assignement.flightProject.service.impl;

import com.cgi.assignement.flightProject.dao.FlightDataDao;
import com.cgi.assignement.flightProject.model.FlightResults;
import com.cgi.assignement.flightProject.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to call methods to get data
 */
@Service
public class FlightServiceImpl implements FlightService {
    private static final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);
    @Autowired
    private FlightDataDao flightDataDao;

    /**
     * Retrieve flights results from dao layer.
     * @return FlightResults
     */
    @Override
    public FlightResults retrieveFlightResults() {
        log.info("Retrieving Flights data from Dao class");
        return flightDataDao.getFlightResults();
    }
}
