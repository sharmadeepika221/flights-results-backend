package com.cgi.assignement.flightProject.util;

import com.cgi.assignement.flightProject.model.FlightResults;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Util class to handle operations of Json.
 */
@Component
public class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private Gson gson;
    private JsonParser parser;

    public JsonUtil() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this. parser = new JsonParser();
    }

    /**
     * reads json file using Gson
     * @param file
     * @return FlightResults
     */
    public FlightResults readJsonFile(String file){
        FlightResults results = null;
        try {
            FileReader fr = new FileReader(file);
            String jsonStr = parser.parse(fr).toString();
            results = gson.fromJson(jsonStr, FlightResults.class);
        } catch (FileNotFoundException e) {
            log.error("File does not exist", e);
        } finally{
            return results;
        }
    }


}
