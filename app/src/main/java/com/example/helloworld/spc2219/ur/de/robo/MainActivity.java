package com.example.helloworld.spc2219.ur.de.robo;

import android.content.Intent;
import android.os.Parcel;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import java.lang.Integer;
import java.util.List;

import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
//

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            // creates the First Fragment which contains the normal search interface
            method_createFirstFragment();

            method_setUp();
        }
    }


    // was used to test if the DataBaseHandler class worked. There was an error report.

    private void method_setIntentToDataMain() {
        Intent nextScreen = new Intent(getApplicationContext(), _TestDataMainActivity.class);
        Log.d("What","SearchData") ;
        startActivity(nextScreen);
    }


    // to be finished by Patrick
    private void method_setUp() {
        method_setGpsButtonListener();


    }

    private void method_setGpsButtonListener() {

    }

     // creates normal qucikSearch Fragment
    private void method_createFirstFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new FirstFragment())
                .commit();
    }



      // creats OptionsMenu, nothing changed from the original setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * The Fragment which contains the QucikSearch view
    */
    public class FirstFragment extends Fragment {

        public FirstFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Sets listener on Search Button
            Button buttonSearch = (Button) rootView.findViewById(R.id.buttonSearch);
            buttonSearch.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    method_createQuickSearchInput();
                }
            });
            // sets listener on profile button
            Button buttonProfile = (Button) rootView.findViewById(R.id.buttonProfile);
            buttonProfile.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction().replace
                            (R.id.container,new ProfileFragment ())
                            .commit();
                }
            });

            return rootView;
        }

            // gets the data from the editTexts of the QuickSearch
        private void method_createQuickSearchInput() {
            EditText editCity = (EditText) findViewById(R.id.editCity);
            String plzString = editCity.getText().toString();


            EditText editBranche = (EditText) findViewById(R.id.editBranche);
            String branche = editBranche.getText().toString();
            Log.e("textblub", branche);



            method_startIntentToListActivity(plzString,branche);

        }
        // starts intent that has the searchData Array to the List Activity
        private void method_startIntentToListActivity(String plz, String branche) {
            Intent nextScreen = new Intent(getApplicationContext(), ListActivity.class);
            String [] searchData = {plz,branche};
            nextScreen.putExtra("SearchData",searchData);
            Log.d("What","SearchData") ;
            startActivity(nextScreen);
        }




    }

   /*
       sets up the Profile View
    */
    public class ProfileFragment extends Fragment{

        public ProfileFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_profile, container, false);

            //sets Listener to the Button Suche mit Profildaten starten
            Button buttonProfileSearch = (Button) rootView.findViewById(R.id.buttonProfileSearch);
            buttonProfileSearch.setOnClickListener(new View.OnClickListener() {
                                        // to be finished
                                          public void onClick(View v) {
                                             // method_createProfileSearchInput();

                                          }
                                      });
            // sets Listener on the Button Quick which goes back to the quickSearchFragment
            Button buttonBack = (Button) rootView.findViewById(R.id.quickSearchButton);
            buttonBack.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction().replace
                            (R.id.container,new FirstFragment ())
                            .commit();

                }
            });


            return rootView;
        }

       // to be finished
    /*
        private void method_createProfileSearchInput() {
            EditText editText1 = (EditText) findViewById(R.id.editText);
            String name = editText1.getText().toString();

            EditText editText2 = (EditText) findViewById(R.id.editText2);
            String graduation = editText2.getText().toString();

            // EditText3 and 4 are not used as the constructor is not updated

            Log.e("textblub", graduation);



            method_startIntentToListActivity(name,graduation);

        }

        private void method_startIntentToListActivity(String name, String graduation) {
            Intent nextScreen = new Intent(getApplicationContext(), ListActivity.class);
            String [] searchData = {name,graduation};
            nextScreen.putExtra("SearchData",searchData);
            Log.d("What","SearchData") ;
            startActivity(nextScreen);
        }

        */
    }

}
