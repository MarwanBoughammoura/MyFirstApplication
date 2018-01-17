package fr.eseo.course.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Marwan on 17/01/2018.
 */


public class People implements Serializable  {

    public People(String name, String birthYear, String gender, String hairColor, String height, String homeWorldUrl, String mass, String skinColor, String created, String edited, String url, ArrayList<String> filmsUrls, ArrayList<String> speciesUrls, ArrayList<String> starshipsUrls, ArrayList<String> vehiclesUrls) {
        this.name = name;
        this.birth_year = birthYear;
        this.gender = gender;
        this.hair_color = hairColor;
        this.height = height;
        this.homeWorldUrl = homeWorldUrl;
        this.mass = mass;
        this.skin_color = skinColor;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String name;
    public String birth_year;
    public String gender;
    public String hair_color;
    public String height;
    public String homeWorldUrl;
    public String mass;
    public String skin_color;
    public String created;
    public String edited;
    public String url;



    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hair_color;
    }

    public String getHeight() {
        return height;
    }

    public String getHomeWorldUrl() {
        return homeWorldUrl;
    }

    public String getMass() {
        return mass;
    }

    public String getSkinColor() {
        return skin_color;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }

    public People(final String name) {

        this.name = name;
    }



}
