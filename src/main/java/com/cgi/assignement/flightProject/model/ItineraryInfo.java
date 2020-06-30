package com.cgi.assignement.flightProject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Java class to contains all information about a particular Itinerary.
 */
public class ItineraryInfo {

    private String id;
    @SerializedName("legs")
    private List<String> legs;
    private String price;
    private String agent;
    private double agent_rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public double getAgent_rating() {
        return agent_rating;
    }

    public void setAgent_rating(double agent_rating) {
        this.agent_rating = agent_rating;
    }

    public List<String> getLegs() {
        return legs;
    }

    public void setLegs(List<String> legs) {
        this.legs = legs;
    }
}

