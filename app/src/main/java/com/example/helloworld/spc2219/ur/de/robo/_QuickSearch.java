package com.example.helloworld.spc2219.ur.de.robo;

/**
 * Created by Christine on 04.06.2015.
 */
public class _QuickSearch {
    int id;
    int plz;
    String branche;



    // Empty constructor
    public _QuickSearch(){

    }
    // constructor
    public _QuickSearch(int plz, String branche) {
        this.plz = plz;
        this.branche = branche;
    }

    // getting id for database
    public int methode_getId(){
        return this.id;
    }

    // setting id for database
    public void methode_setId(int id){
        this.id = id;
    }


    // getting PLZ
    public int methode_getPlz(){
        return this.plz;
    }

    // setting PLZ
    public void methode_setPlz(int plz){
        this.plz = plz;
    }

    // getting branche
    public String methode_getBranche(){
        return this.branche;
    }

    // setting branche
    public void methode_setBranche(String branche){
        this.branche = branche;
    }
}

