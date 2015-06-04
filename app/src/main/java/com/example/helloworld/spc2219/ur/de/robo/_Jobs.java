package com.example.helloworld.spc2219.ur.de.robo;

import java.util.Map;

/**
 * Created by Christine on 04.06.2015.
 */
public class _Jobs {

    //variables
    //we will get the necessary variables from the Server/Client-Group
    int plz;
    String branche;
    String jobTitle;
    String employer;

    int id;
    String adress; // seperated into PLZ, Ort, Straße, ... ???
    String requirements;
    String workTasks;
    int rating; // or String???



    // Empty constructor
    public _Jobs(){

    }
    // constructor
    public _Jobs(String jobTitle, String employer, int plz, String branche)  {
        this.jobTitle = jobTitle;
        this.employer = employer;
        this.plz = plz;
        this.branche = branche;

    }

    // constructor
    public _Jobs(int id, String jobTitle, String branche, String adress, String requirements, String workTasks, int rating){
        this.id = id;
        this.jobTitle = jobTitle;
        this.branche = branche;
        this.adress = adress;
        this.requirements = requirements;
        this.workTasks = workTasks;
        this.rating = rating;
    }



    // getting id for database
    public int methode_getId(){
        return this.id;
    }

    // setting id for database
    public void methode_setId(int id){
        this.id = id;
    }


    // getting name
    public String methode_getJobTitle(){
        return this.jobTitle;
    }

    // setting name
    public void methode_setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    // getting employer
    public String methode_getEmployer(){
        return this.employer;
    }

    // setting employer
    public void methode_setEmployer(String employer){
        this.employer = employer;
    }

    // getting plz
    public int methode_getPlz(){
        return this.plz;
    }

    // setting plz
    public void methode_setPlz(int plz){
        this.plz = plz;
    }

    // getting branche
    public String methode_getBranche(){
        return this.branche;
    }

    // setting employer
    public void methode_setBranche(String branche){
        this.branche = branche;
    }


    //getting and setting methods for all attributes etc.....
    @Override
    public String toString(){
        return jobTitle;
    }
}
