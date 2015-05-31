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

/**
 * Created by Christine on 29.05.2015.
 */

public class ListActivity extends Activity {

    ArrayList<JobObject> list = new ArrayList<>();
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d("Ha", "zumindest das klappt");
        if (savedInstanceState == null) {
            TextView text = (TextView) findViewById(R.id.textView2);
            // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            Intent in = getIntent();
            String[] IDs = in.getStringArrayExtra("JobIds");




            for (int i = 0; i < IDs.length; i++) {
               JobObject ob =  new JobObject(IDs[i]);
                ob.setEmployer(TestDataActvity.getEmployer(IDs[i]));
                ob.setTitle(TestDataActvity.getJobTitle(IDs[i]));
                list.add(i,ob);
                Log.d("ids", IDs[i]);


            }



            final ArrayAdapter<JobObject> ad = new ArrayAdapter<JobObject>(this, android.R.layout.simple_list_item_1,list );

            listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(ad);
            Log.d("s", "Arraylist geht");

            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, final View view,
                                        int position, long id) {
                    final String item = (String) parent.getItemAtPosition(position).toString();
                    Log.d("yeó", item);

                    final JobObject item2 = (JobObject) parent.getItemAtPosition(position);
                    String id2 = item2.getID();
                    Log.d("id",id2); Intent nextScreen = new Intent(getApplicationContext(), DetailsActivity.class);

                    Log.d("What", "ListStarten") ;
                    nextScreen.putExtra("JobId",id2);
                    startActivity(nextScreen);


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
}