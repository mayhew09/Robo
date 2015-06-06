package com.example.helloworld.spc2219.ur.de.robo;

/**
 * Created by Christine on 04.06.2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniela on 26.05.15.
 */
public class _DataBaseHandler extends SQLiteOpenHelper {


    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Table names
    private static final String TABLE_SEARCH = "search";
    private static final String TABLE_USER = "users";
    private static final String TABLE_JOBS = "jobs";

    // Search Table - column names
    private static final String KEY_PLZ = "plz";
    private static final String KEY_BRANCHE = "branche";

    // User Table - column names
    private static final String KEY_USER = "user";
    private static final String KEY_GRADUATION = "graduation";

    // Job Table - column names
    private static final String KEY_JOB_TITLE = "job_title";
    private static final String KEY_EMPLOYER = "employer";
    private static final String KEY_JOB_PLZ = "plz";
    private static final String KEY_JOB_BRANCHE = "branche";

    // User_Job Table - column names
    private static final String KEY_SEARCH_ID = "search_id";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_JOB_ID = "job_id";


    // Table Create Statements
    // Search table create statement
    private static final String CREATE_TABLE_SEARCH = "CREATE TABLE "
            + TABLE_SEARCH + "(" + KEY_SEARCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_PLZ
            + " TEXT," + KEY_BRANCHE + " TEXT,"  + ")";

    // User table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USER
            + " TEXT," + KEY_GRADUATION + " TEXT,"  + ")";

    // Job table create statement
    private static final String CREATE_TABLE_JOB = "CREATE TABLE " + TABLE_JOBS
            + "(" + KEY_JOB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_JOB_TITLE + " TEXT,"
            + KEY_EMPLOYER + "TEXT" + KEY_JOB_PLZ + " TEXT" + KEY_JOB_BRANCHE + " TEXT" + ")";




    public _DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SEARCH);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_JOB);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /*  // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEARCH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);

        // create new tables
        onCreate(db);*/

        // Laut Vorlesungsunterlagen wahrscheinlich besser:
        if (newVersion > oldVersion) {
            db.execSQL("ALTER TABLE search ADD COLUMN search_column INTEGER DEFAULT 0");
            db.execSQL("ALTER TABLE user ADD COLUMN user_column INTEGER DEFAULT 0");
            db.execSQL("ALTER TABLE job ADD COLUMN job_column INTEGER DEFAULT 0");
        }
    }







    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */




    //For Search
    // Add search
    public void addSearch(_QuickSearch search) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLZ, search.methode_getPlz());
        values.put(KEY_BRANCHE, search.methode_getBranche());

        // insert row
        db.insert(TABLE_SEARCH, null, values);
        db.close();

    }


    // Getting single search
    public _QuickSearch getSearch(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SEARCH, new String[]{KEY_SEARCH_ID, KEY_PLZ, KEY_BRANCHE}, KEY_JOB_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        _QuickSearch search = new _QuickSearch(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        // return searches
        return search;
    }

    // Getting all searches
    // Diese Methode ist wahrscheindlich nicht notwendig... ??
    public List<_QuickSearch> getAllSearches() {
        List<_QuickSearch> searchList = new ArrayList<_QuickSearch>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SEARCH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                _QuickSearch search = new _QuickSearch();
                search.methode_setPlz(Integer.parseInt(cursor.getString(0)));
                search.methode_setBranche(cursor.getString(1));

                searchList.add(search);
            } while (cursor.moveToNext());
        }

        // return search list
        return searchList;
    }

    // Updating single search
    public int updateSearch(_QuickSearch search) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLZ, search.methode_getPlz());
        values.put(KEY_BRANCHE, search.methode_getBranche());

        // updating row
        return db.update(TABLE_SEARCH, values, KEY_SEARCH_ID + " = ?",
                new String[] { String.valueOf(search.methode_getId()) });
    }

    // Deleting single search
    public void deleteSearch(_QuickSearch search) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SEARCH, KEY_SEARCH_ID + " = ?",
                new String[]{String.valueOf(search.methode_getId())});
        db.close();
    }


    // Getting search count
    // Diese Methode ist wahrscheindlich nicht notwendig... ??
    public int getSearchCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SEARCH;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }






    // For User
    // Adding new user
    public void addUser(_ProfileSearch user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER, user.getName()); // User Name
        values.put(KEY_GRADUATION, user.getGraduation()); // User graduation

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection
    }

    // Getting single user
    public _ProfileSearch  getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[]{
                        KEY_USER, KEY_GRADUATION}, KEY_USER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        _ProfileSearch  user = new _ProfileSearch (cursor.getString(0), cursor.getString(1));
        // return user
        return user;
    }

    // Getting All users
    public List<_ProfileSearch > getAllUsers() {
        List<_ProfileSearch > userList = new ArrayList<_ProfileSearch >();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                _ProfileSearch  user = new _ProfileSearch ();
                user.setName(cursor.getString(0));
                user.setGraduation(cursor.getString(1));
                // Adding user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return user list
        return userList;
    }

    // Updating single user
    public int updateUser(_ProfileSearch  user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER, user.getName());
        values.put(KEY_GRADUATION, user.getGraduation());

        // updating row
        return db.update(TABLE_USER, values, KEY_USER_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    // Deleting single user
    public void deleteUser(_ProfileSearch  user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }


    // Getting user Count
    public int getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }







    //For Job
    // Add jobs
    public void addJob(_Jobs jobs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_JOB_TITLE, jobs.methode_getJobTitle());
        values.put(KEY_EMPLOYER, jobs.methode_getEmployer());
        values.put(KEY_JOB_PLZ, jobs.methode_getPlz());
        values.put(KEY_JOB_BRANCHE, jobs.methode_getBranche());

        // insert row
        db.insert(TABLE_JOBS, null, values);
        db.close();

    }


    // Getting single job
    public _Jobs getJob(int id) {

        _Jobs job1 = new _Jobs("Werksstudent im IT-Bereich", "XY GmbH", 93047, "IT");

        return  job1;
       /* SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_JOBS, new String[]{KEY_JOB_ID,
                        KEY_JOB_TITLE, KEY_EMPLOYER, KEY_JOB_PLZ, KEY_JOB_BRANCHE}, KEY_JOB_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        _Jobs jobs = new _Jobs(cursor.getString(0),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3));
        // return single job
        return jobs;
        */



    }

    public List<_Jobs> method_getAllJobs() {
        List<_Jobs> jobList = new ArrayList<_Jobs>();
        _Jobs job1 = new _Jobs("Werksstudent im IT-Bereich", "XY GmbH", 93047, "IT");
        _Jobs job2 = new _Jobs("Studentische Aushilfe", "XY GmbH", 93047, "IT");
        _Jobs job3 = new _Jobs("Software-Entwickler", "Muster AG", 93049, "Entwicklung");
        jobList.add(job1);
        jobList.add(job2);
        jobList.add(job3);
        return jobList;
    }





    // Getting all jobs
    // Funktioniert am Ende etwas anders --> muss von XML/JSON ausgelesen werden --> Nur für Test


  /*  public List<_Jobs> getAllJobs() {
        List<_Jobs> jobList = new ArrayList<_Jobs>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_JOBS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                _Jobs jobs = new _Jobs();
                jobs.methode_setJobTitle(cursor.getString(0));
                jobs.methode_setEmployer(cursor.getString(1));
                jobs.methode_setPlz(Integer.parseInt(cursor.getString(2)));
                jobs.methode_setBranche(cursor.getString(3));
                // Adding contact to list
                jobList.add(jobs);
            } while (cursor.moveToNext());
        }

        // return job list
        return jobList;
    } */

    // Updating single job offer
    public int updateJob(_Jobs jobs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_JOB_TITLE, jobs.methode_getJobTitle());
        values.put(KEY_EMPLOYER, jobs.methode_getEmployer());
        values.put(KEY_JOB_PLZ, jobs.methode_getPlz());
        values.put(KEY_JOB_BRANCHE, jobs.methode_getBranche());

        // updating row
        return db.update(TABLE_JOBS, values, KEY_JOB_ID + " = ?",
                new String[] { String.valueOf(jobs.methode_getId()) });
    }

    // Deleting single job offer
    public void deleteJob(_Jobs jobs) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_JOBS, KEY_JOB_ID + " = ?",
                new String[]{String.valueOf(jobs.methode_getId())});
        db.close();
    }


    // Getting job Count
    public int getJobCount() {
        String countQuery = "SELECT  * FROM " + TABLE_JOBS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
