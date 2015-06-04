package com.example.helloworld.spc2219.ur.de.robo;

/**
 * Created by Christine on 04.06.2015.
 */
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class _TestDataMainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("DATA","Test Klappt");
       _Jobs job1 = new _Jobs("Werksstudent im IT-Bereich", "XY GmbH", 93047, "IT");
        _Jobs job2 = new _Jobs("Studentische Aushilfe", "XY GmbH", 93047, "IT");
        _Jobs job3 = new _Jobs("Software-Entwickler", "Muster AG", 93049, "Entwicklung");
        _Jobs job4 = new _Jobs("Außendienstmitarbeiter", "LBS Bayern", 93049, "Finanzbereich");
        _Jobs job5 = new _Jobs("Tainee im Vertrieb", "easyCredit", 93053, "Finanzbereich");
        _Jobs job6 = new _Jobs("HR Business Partner", " ifp - Personalberatug", 93055, "Personalwesen");
        _Jobs job7 = new _Jobs("IT-Mitarbeiter / First Level Support", "Papier Liebl GmbH", 93055, "IT");
        _Jobs job8 = new _Jobs("Frontend-Entwickler", "myposter GmbH", 93055, "Entwicklung");

        _DataBaseHandler db = new _DataBaseHandler(this);
        Log.d("DATA","Test Klappt2");
        db.addJob(job1); db.addJob(job2); db.addJob(job3); db.addJob(job4);
        db.addJob(job5); db.addJob(job6); db.addJob(job7); db.addJob(job8);
        Log.d("DATA","Test Klappt3");



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
}