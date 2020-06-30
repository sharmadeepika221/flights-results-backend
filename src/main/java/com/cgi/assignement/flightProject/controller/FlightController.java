package com.cgi.assignement.flightProject.controller;

import com.cgi.assignement.flightProject.dao.impl.FlightDataDaoImpl;
import com.cgi.assignement.flightProject.exception.ResourceNotFoundException;
import com.cgi.assignement.flightProject.model.FlightResults;
import com.cgi.assignement.flightProject.model.ItineraryInfo;
import com.cgi.assignement.flightProject.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller class
 */
@RestController
@RequestMapping(value = "/api/v1/flightResults")
@Api(tags = { "flights" })
public class FlightController extends AbstractRestHandler{
    private static final Logger log = LoggerFactory.getLogger(FlightController.class);
    @Autowired
    private FlightService flightService;

    /**
     * This method is for retrieving all flights results
     * @param request
     * @param response
     * @return ResponseEntity<FlightResults>
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gets flight results.", notes = "Flight results gives all the required details of all flights as per their prices present in given json file")
    public @ResponseBody ResponseEntity<FlightResults> getFlightResults(HttpServletRequest request,
                                                               HttpServletResponse response) {
        FlightResults results = flightService.retrieveFlightResults();
        if (results == null) {
            log.error("No flight Results available");
            throw new ResourceNotFoundException("No record found");
        }
        return new ResponseEntity<FlightResults>(results, HttpStatus.OK);
    }
}
