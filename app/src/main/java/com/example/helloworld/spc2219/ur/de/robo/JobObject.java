package com.example.helloworld.spc2219.ur.de.robo;

import java.util.Date;

/**
 * Created by Christine on 29.05.2015.
 */
public class JobObject {

    String id;
    String employer;
    String title;
    Date beginning;
    String[] requirements;
    String[] tasks;
    // with Streetnumber!
    String street;
    String plz;
    String city;

    public JobObject(String id_o) {
        id = id_o;

    }

    public JobObject(String id_o, String employer_o, String title_o, String[] requirements_o, String[] tasks_o, String street_o, String plz_o, String city_o) {
        this.id = id_o;
        employer = employer_o;
        title = title_o;
       // beginning = beginning_o;
        requirements = requirements_o;
        tasks = tasks_o;
        street = street_o;
        plz = plz_o;
        city = city_o;

    }
    @Override
    public String toString() {
        if (employer != null && title != null) {
            return employer + " " + title;
        }
        else {
            return null;
        }
    }

    public String getID(){
        return  id;
    }

    public String getEmployer(int id) {
        if (employer != null){
            return employer;
        }
           return title;
    }
    public void setTitle(String jobTitle){
        title = jobTitle;
    }
    public void setEmployer(String employer2){
        employer = employer2;
    }



}