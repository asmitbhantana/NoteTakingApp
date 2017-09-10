package com.example.asmit.takenote.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.asmit.takenote.database.NoteSchema.*;

/**
 * Created by asmit on 9/10/17.
 */

public class NoteSQLiteHelper extends SQLiteOpenHelper {
    private Context mContext;
    public NoteSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

      try{  sqLiteDatabase.execSQL("create table "+ NoteTable.NAME+"(_id integer primary key autoincrement, "
                +NoteTable.cols.Title+", "
                +NoteTable.cols.Desc+", "
                +NoteTable.cols.Id+");"
            );
          }
          catch (SQLException e){
              Toast.makeText(mContext,"Sorry cannot create database table",Toast.LENGTH_SHORT).show();
          }
      }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
