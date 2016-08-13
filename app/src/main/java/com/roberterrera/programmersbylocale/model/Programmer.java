
package com.roberterrera.programmersbylocale.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Programmer {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("favorite_color")
    @Expose
    private String favoriteColor;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("is_artist")
    @Expose
    private Boolean isArtist;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The favoriteColor
     */
    public String getFavoriteColor() {
        return favoriteColor;
    }

    /**
     * 
     * @param favoriteColor
     *     The favorite_color
     */
    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    /**
     * 
     * @return
     *     The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     * @return
     *     The weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The isArtist
     */
    public Boolean getIsArtist() {
        return isArtist;
    }

    /**
     * 
     * @param isArtist
     *     The is_artist
     */
    public void setIsArtist(Boolean isArtist) {
        this.isArtist = isArtist;
    }

}
