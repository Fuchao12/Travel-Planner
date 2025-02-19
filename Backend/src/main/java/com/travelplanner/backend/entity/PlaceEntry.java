package com.travelplanner.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Place_Entries")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "place_entry_id")
    @JsonProperty("place_entry_id")
    private int placeEntryId;

    @Column(name = "rapid_place_id")
    @JsonProperty("rapid_place_id")
    private String rapidPlaceId;

    @Column(name = "latitude")
    @JsonProperty("latitude")
    private Double lat;

    @Column(name = "longitude")
    @JsonProperty("longitude")
    private Double lon;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("timeblock")
    private Timeblock timeblock;

    @ManyToOne
    @JoinColumn(name="daily_plan_id", nullable = false)
    private DailyPlan dailyPlan;

    public DailyPlan getDailyPlan() {
        return dailyPlan;
    }
    public void setDailyPlan(DailyPlan dailyPlan) {
        this.dailyPlan = dailyPlan;
    }

    public int getPlaceEntryId() {
        return placeEntryId;
    }

    public void setPlaceEntryId(int placeEntryId) {
        this.placeEntryId = placeEntryId;
    }

    public String getRapidPlaceId() {
        return rapidPlaceId;
    }

    public void setRapidPlaceId(String rapidPlaceId) {
        this.rapidPlaceId = rapidPlaceId;
    }

    public Timeblock getTimeblock() {

        return timeblock;
    }

    public void setTimeblock(Timeblock timeblock) {

        this.timeblock= timeblock;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
