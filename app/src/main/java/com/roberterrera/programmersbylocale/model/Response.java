
package com.roberterrera.programmersbylocale.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Response {

    @SerializedName("locations")
    @Expose
    private List<ProgrammerLocation> locations = new ArrayList<ProgrammerLocation>();

    /**
     * 
     * @return
     *     The locations
     */
    public List<ProgrammerLocation> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The locations
     */
    public void setLocations(List<ProgrammerLocation> locations) {
        this.locations = locations;
    }

}
