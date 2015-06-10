package com.example.helloworld.spc2219.ur.de.robo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christine on 29.05.2015
 *
 * contains the Listview with JobObjects
 *
 */

public class ListActivity extends Activity {

    List<_Jobs> list ;
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (savedInstanceState == null) {
            TextView text = (TextView) findViewById(R.id.textView2);

            // not needed right now
            // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            // gets the Search Data Array from the Intent from the MainActivity
            Intent in = getIntent();
            String[] quickSearchData = in.getStringArrayExtra("SearchData");
            list = method_executeQuickSearch(quickSearchData);
        }


        // isn't necessary anymore as the DataBaseHandler class gives an list of the jobs back

            /*for (int i = 0; i < IDs.length; i++) {
                _Jobs job =  new JobObject(IDs[i]);
                ob.setEmployer(TestDataActvity.getEmployer(IDs[i]));
                ob.setTitle(TestDataActvity.getJobTitle(IDs[i]));
                list.add(i,ob);
                Log.d("ids", IDs[i]);
                }
                */


        // creates new JobObject Array Adapter and sets the Adaper to the ListView of the activity.
        // IF getallJobs() works, does  it need the SimpleCurserAdapter???

        final ArrayAdapter<_Jobs> ad = new ArrayAdapter<_Jobs>(this, android.R.layout.simple_list_item_1, list);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(ad);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // gets the item that is selected and starts an Intent to the DetailsActivity
            // with the selected JobID
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                final _Jobs job = (_Jobs) parent.getItemAtPosition(position);

                //Integer id2 = job.methode_getId();
                int id2;
                // FÜR ZWISCHENPRÄSENTATION
                if (job.methode_getJobTitle().equals("Werksstudent im IT-Bereich")){
                  id2 = 1;
                }
                else{
                    if(job.methode_getJobTitle().equals("Studentische Aushilfe")){
                        id2 = 2;
                    }
                    else{
                        id2 = 3;
                    }
                }


                Intent nextScreen = new Intent(getApplicationContext(), DetailsActivity.class);

                nextScreen.putExtra("JobId", Integer.toString(id2));
                startActivity(nextScreen);


                // I'm not sure for what that is needed? Maybe Animation :)

                    /*view.animate().setDuration(2000).alpha(0)
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    list.remove(item);
                                    ad.notifyDataSetChanged();
                                    view.setAlpha(1);
                                }
                            });*/
            }

        });

    }

        private List<_Jobs> method_executeQuickSearch (String[] quickSearchData) {
            // creates a QuickSearch Object with the Searchdata (plz, branche)
            // the method where it is handed over needs to be done
            _QuickSearch quick = new _QuickSearch(Integer.parseInt(quickSearchData[0]),quickSearchData[1]);

            // gets all Jobs of the database
            _DataBaseHandler db = new _DataBaseHandler(getApplicationContext());
            List<_Jobs> jobList= db.method_getAllJobs();
            return jobList;
        }


        // not used!
/*private class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
                              List<String> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
*/

}