package com.example.asmit.takenote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by asmit on 9/10/17.
 */

public class DatabaseIO {

    private static DatabaseIO mDatabaseIO;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private static final int VERSION = 1;

    private DatabaseIO(Context context) {
        this.mContext = context.getApplicationContext();
        //This gives us the database
        mDatabase = new NoteSQLiteHelper(mContext,NoteSchema.NoteTable.NAME,null,VERSION).getWritableDatabase();
    }

    public static DatabaseIO get(Context context)
    {
        //
        if (mDatabaseIO==null){
            return new DatabaseIO(context); 
        }
        return mDatabaseIO;
    }

    //Add crime in database
    public void addCrime(Data data){

        ContentValues mContentValues = getContentValues(data);
        long checkSucess = mDatabase.insert(NoteSchema.NoteTable.NAME,null,mContentValues);
        if(checkSucess<0){
            Toast.makeText(mContext,"Failed to save Note",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(mContext,"Sucess to save Note",Toast.LENGTH_SHORT).show();
        }

    }

    private ContentValues getContentValues(Data data) {

        /*
            Content values provides us the capability of adding data in our database
         */

        ContentValues values = new ContentValues();
        values.put(NoteSchema.NoteTable.cols.Title,data.getTitle());
        values.put(NoteSchema.NoteTable.cols.Desc,data.getDesc());
        values.put(NoteSchema.NoteTable.cols.Id, String.valueOf(data.getUuid()));

        return values;
    }


}
