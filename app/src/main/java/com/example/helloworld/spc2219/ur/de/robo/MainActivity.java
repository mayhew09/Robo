package com.example.helloworld.spc2219.ur.de.robo;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
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


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            createFirstFragment();

            setUp();
        }

    }

    private void setUp() {
        setGpsButtonListener();
       // setProfileCheckBox();
    }

    private void setGpsButtonListener() {

    }

    private void startIntentToDataBase(String city) {
        Intent nextScreen = new Intent(getApplicationContext(), TestDataActvity.class);
        nextScreen.putExtra("City",city);
        Log.d("What","CityStarten") ;
        startActivity(nextScreen);

    }

    private void createFirstFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new FirstFragment())
                .commit();
    }




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
     * Ap laceholder fragment containing a simple view.
    */
    public  class FirstFragment extends Fragment implements View.OnClickListener{

        public FirstFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button button = (Button) rootView.findViewById(R.id.buttonSearch);
            // button.setText("sdfs");
            button.setOnClickListener(this);
            Log.d("XE","SER");

            return rootView;
        }

            public void onClick(View v) {
             EditText edittext = (EditText) findViewById(R.id.editCity);
              String city =  edittext.getText().toString();
                Log.e("textblub", city);
                startIntentToDataBase(city);
            }

    }

    public  class FavoriteFragment extends Fragment implements View.OnClickListener{

        public FavoriteFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_favorite, container, false);
            Button button = (Button) rootView.findViewById(R.id.buttonSearch);
            // button.setText("sdfs");
            button.setOnClickListener(this);
            Log.d("XE","SER");

            return rootView;
        }

        public void onClick(View v) {
            EditText edittext = (EditText) findViewById(R.id.editCity);
            String city =  edittext.getText().toString();
            Log.e("textblub", city);
            startIntentToDataBase(city);
        }

    }

    public  class ProfileFragment extends Fragment implements View.OnClickListener{

        public ProfileFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_profile, container, false);
            Button button = (Button) rootView.findViewById(R.id.buttonSearch);
            // button.setText("sdfs");
            button.setOnClickListener(this);
            Log.d("XE","SER");

            return rootView;
        }

        public void onClick(View v) {
            EditText edittext = (EditText) findViewById(R.id.editCity);
            String city =  edittext.getText().toString();
            Log.e("textblub", city);
            startIntentToDataBase(city);
        }

    }
}
