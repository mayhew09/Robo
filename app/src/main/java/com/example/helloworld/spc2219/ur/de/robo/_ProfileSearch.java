package com.example.helloworld.spc2219.ur.de.robo;

/**
 * Created by Christine on 04.06.2015.
 */
public class _ProfileSearch {
    //variables
    //we will get the necessary variables from Funktionengruppe
    int _id;
    String _name; // probably it's not necessary ?
    String _graduation;
    String _apprenticeship;
    String _studies;
    String _abilities;
    String _actualPosition;
    int _radiusForSearch;
    int _fbID;
    int _ratings; // or String?




    // Empty constructor
    public _ProfileSearch(){

    }
    // constructor
    public _ProfileSearch(String name, String graduation) {
        this._name = name;
        this._graduation = graduation;


    }
    // constructor
    public _ProfileSearch(String name, String graduation, String apprenticeship, String studies, String abilities, String actualPosition, int radiusForSearch, int fbID,  int ratings){
        this._name = name;
        this._graduation = graduation;
        this._apprenticeship = apprenticeship;
        this._studies = studies;
        this._abilities = abilities;
        this._actualPosition = actualPosition;
        this._radiusForSearch = radiusForSearch;
        this._fbID = fbID;
        this._ratings = ratings;
    }


    // getting id for database
    public int getId(){
        return this._id;
    }

    // setting id for database
    public void setId(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting graduation
    public String getGraduation(){
        return this._graduation;
    }

    // setting graduation
    public void setGraduation(String graduation){
        this._graduation = graduation;
    }

    //getting and setting methods for all attributes etc.....
}



