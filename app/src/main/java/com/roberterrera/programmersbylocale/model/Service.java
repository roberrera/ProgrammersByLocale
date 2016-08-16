
package com.roberterrera.programmersbylocale.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Service {

    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("programmers")
    @Expose
    private List<Programmer> programmers = new ArrayList<Programmer>();

    /**
     * 
     * @return
     *     The platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 
     * @param platform
     *     The platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 
     * @return
     *     The programmers
     */
    public List<Programmer> getProgrammers() {
        return programmers;
    }

    /**
     * 
     * @param programmers
     *     The programmers
     */
    public void setProgrammers(List<Programmer> programmers) {
        this.programmers = programmers;
    }

}
