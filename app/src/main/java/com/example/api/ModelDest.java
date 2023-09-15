package com.example.api;


import android.net.Uri;

import java.net.URI;

public class ModelDest {

    String Id, destinationName, aboutPlace, history, attraction, holiday,webLink,
    location, district, duration, rating, createdAt;
//    URI thumbnaillUri;
    String thumb;


//    ArrayList<String> photos, category, season;

    public ModelDest() {
    }

    public ModelDest(String id, String destinationName, String aboutPlace, String history, String attraction, String thumb,
                     String holiday, String webLink, String location, String district, String duration, String rating, String createdAt) {

        Id = id;
        this.destinationName = destinationName;
        this.aboutPlace = aboutPlace;
        this.history = history;
        this.attraction = attraction;
        this.thumb = thumb;
        this.holiday = holiday;
        this.webLink = webLink;
        this.location = location;
        this.district = district;
        this.duration = duration;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getAboutPlace() {
        return aboutPlace;
    }

    public void setAboutPlace(String aboutPlace) {
        this.aboutPlace = aboutPlace;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
