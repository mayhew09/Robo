package com.example.helloworld.spc2219.ur.de.robo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Christine on 29.05.2015.
 */
public class DetailsActivity extends Activity {
    JobObject job;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (savedInstanceState == null) {
            Intent in = getIntent();
    // Gets all the Data from TestDataActiviy
            String profileID = in.getStringExtra("JobId");

            String city = TestDataActvity.getCity(profileID);
            String plz = TestDataActvity.getPLZ(profileID);
            String street = TestDataActvity.getStreet(profileID);
            String[] tasks = TestDataActvity.getTasks(profileID);
            String[] requirement = TestDataActvity.getRequirements(profileID);
            String employer = TestDataActvity.getEmployer(profileID);
            String jobTitle = TestDataActvity.getJobTitle(profileID);
            // needed? Meeting on Tuesday
            //  Date beginning = TestDataActvity.getBeginnning(profileID);
            Log.d("Detaisl", "Details funktioniert1");
            // not necessary at the moment
            //job = new JobObject(profileID, jobTitle, employer, requirement, tasks, street, plz, city);
            // get all TextViews to fill them
            TextView text3 = (TextView) findViewById(R.id.textView3);
            TextView text4 = (TextView) findViewById(R.id.textView4);
            TextView text5 = (TextView) findViewById(R.id.textView5);
            TextView text6 = (TextView) findViewById(R.id.textView6);
            TextView text7 = (TextView) findViewById(R.id.textView7);

           // sets the data for the Textviews
            text3.setText(jobTitle);
            text4.setText(employer);
            text5.setText(street);
          StringBuilder builder = new StringBuilder();
          for (String s : tasks) {
                builder.append(s + " ");
                text6.setText(builder.toString());
          }
          builder.setLength(0);
          for (String s2 : requirement) {
                builder.append(s2 + " ");
                text7.setText(builder.toString());


          }


        }
    }
}