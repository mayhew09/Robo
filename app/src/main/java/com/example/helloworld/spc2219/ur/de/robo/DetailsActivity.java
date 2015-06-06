package com.example.helloworld.spc2219.ur.de.robo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Christine on 29.05.2015
 */
public class DetailsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (savedInstanceState == null) {
            // gets the ID from the intent from ListActivity
            Intent in = getIntent();
            String profileIDString = in.getStringExtra("JobId");
            int profileID = Integer.parseInt(profileIDString);

            // gets a jobs object with the profileID
            _DataBaseHandler db = new _DataBaseHandler(getApplicationContext());
            _Jobs job = db.getJob(profileID);

            // gets the data from the job object
            String jobTitle = job.methode_getJobTitle();
            String employer = job.methode_getEmployer() ;
            int plz = job.methode_getPlz();
            String plzString = Integer.toString(plz);
            String branche = job.methode_getBranche();

            // get all TextViews to fill them
            TextView text3 = (TextView) findViewById(R.id.textView3);
            TextView text4 = (TextView) findViewById(R.id.textView4);
            TextView text5 = (TextView) findViewById(R.id.textView5);

            // not needed right now
            TextView text6 = (TextView) findViewById(R.id.textView6);
            TextView text7 = (TextView) findViewById(R.id.textView7);

           // sets the data for the textviews
            text3.setText(jobTitle);
            text4.setText(employer);
            text5.setText(plzString);

     // requirements and tasks are not included at the moment
        /*  StringBuilder builder = new StringBuilder();
          for (String s : tasks) {
                builder.append(s + " ");
                text6.setText(builder.toString());
          }
          builder.setLength(0);
          for (String s2 : requirement) {
                builder.append(s2 + " ");
                text7.setText(builder.toString());
           */




        }
    }
}