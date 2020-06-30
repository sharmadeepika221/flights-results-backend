package com.cgi.assignement.flightProject.model;

/**
 * Java class handles all information about a particular flight.
 */
public class FlightInfo {

    private String id;
    private String departure_airport;
    private String arrival_airport;
    private String departure_time;
    private String arrival_time;
    private int stops;
    private String airline_name;
    private String airline_id;
    private int duration_mins;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(String airline_id) {
        this.airline_id = airline_id;
    }

    public int getDuration_mins() {
        return duration_mins;
    }

    public void setDuration_mins(int duration_mins) {
        this.duration_mins = duration_mins;
    }
}
