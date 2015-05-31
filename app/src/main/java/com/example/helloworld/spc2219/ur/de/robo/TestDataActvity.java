package com.example.helloworld.spc2219.ur.de.robo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.helloworld.spc2219.ur.de.robo.JobObject;

import java.util.Date;

/**
 * Created by Christine on 29.05.2015.
 * Just filled with getMethods.
 * After the intent from the MainActiviy the class sends an intent witha an StringArray with the IDs
 * to the ListActivity class
 *
 * Is used in ListActiviy and DetailsActivity
 */
public class TestDataActvity extends Activity{


    String[] ids = {"14","05","1995"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);
       if (savedInstanceState == null) {

           // gets the cityname/plznumber from the intent and starts an intent to the ListActivity with the ID Array.
            TextView text = (TextView) findViewById(R.id.textView);
            Intent i = getIntent();


            Intent nextScreen = new Intent(getApplicationContext(), ListActivity.class);

            Log.d("What", "ListStarten") ;
           nextScreen.putExtra("JobIds",ids);
            startActivity(nextScreen);


        }
    }

    public static int getNumber(){
        return 10;

    }
    public static String getEmployer(String st){
        if(st.equals("14")) {
            return "Krones";
        }
        else{
            return "Siemens";
        }
    }
    public static String getJobTitle(String st){
        if(st.equals("14")) {
            return "Programmierer";
        }
        else{
            return "Tester";
        }

    }
    public static String getCity(String st){
        if(st.equals("14")) {
            return "Regensburg";
        }
        else{
            return "Schwandorf";
        }

    }
   /* public static Date getBeginning(String st){
        if(st.equals("14")) {
            return ;
        }
        else{
            return "Tester";
        }

    }*/
    
    public static String[] getRequirements(String st){
        if(st.equals("14")) {
           String[] yo = {"Java","Programmierkentnisse"};
//
            return yo;
        }
        else{
            String[] no = {"C","SQL"};
            return no;
        }

    }
    public static String [] getTasks(String st){
        if(st.equals("14")) {
            String[] yo = {"Funktionalität","Design"};
            return yo;
        }
        else{
            String[] no = {"Doku","Leitung"};
            return no;
        }

    }

    public static String getPLZ(String st){
        if(st.equals("14")) {
            return "94567";
        }
        else{
            return "92421";
        }

    }

    public static String getStreet(String st){
        if(st.equals("14")) {
            return "Haydnstraße 5";
        }
        else{
            return "Krondorferstraße 10";
        }

    }
}