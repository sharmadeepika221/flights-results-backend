package com.cgi.assignement.flightProject.dao.impl;

import com.cgi.assignement.flightProject.dao.FlightDataDao;
import com.cgi.assignement.flightProject.model.FlightResults;
import com.cgi.assignement.flightProject.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is responsible for reading data from json file.
 */
@Repository
public class FlightDataDaoImpl implements FlightDataDao {
    private static final Logger log = LoggerFactory.getLogger(FlightDataDaoImpl.class);
    @Autowired
    private JsonUtil jsonUtil;
    //this file is present in project dir.
    private String jsonFile = "flights.json";


    /**
     * This method will read the flights.json file and
     * convert it into object of FlightResults class.
     * @return FlightResults
     */
    @Override
    public FlightResults getFlightResults() {
        log.info("Get flights data from flights.json file");
       return jsonUtil.readJsonFile(jsonFile);
    }
}
