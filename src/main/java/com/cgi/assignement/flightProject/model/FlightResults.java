package com.cgi.assignement.flightProject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Json data will be read in form of object of this class.
 */
public class FlightResults {
    @SerializedName("itineraries")
    private List<ItineraryInfo> itineraries;
    @SerializedName("legs")
    private List<FlightInfo> legs;

    public FlightResults(ArrayList<ItineraryInfo> itineraryInfos, ArrayList<FlightInfo> flightInfos) {
        this.itineraries = itineraryInfos;
        this.legs = flightInfos;
    }

    public List<ItineraryInfo> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<ItineraryInfo> itineraries) {
        this.itineraries = itineraries;
    }

    public List<FlightInfo> getLegs() {
        return legs;
    }

    public void setLegs(List<FlightInfo> legs) {
        this.legs = legs;
    }
}
