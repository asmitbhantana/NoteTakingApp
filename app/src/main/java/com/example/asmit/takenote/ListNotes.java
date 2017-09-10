package com.example.asmit.takenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asmit.takenote.database.Data;

import java.util.ArrayList;
import java.util.List;

public class ListNotes extends AppCompatActivity {
    RecyclerView mRecyclerView;
    public List<Data> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.notes_list_recycler_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent =new Intent(ListNotes.this,Note.class);
                startActivity(intent);
            }
        });
        datas = new ArrayList<>();
        for(int i=0;i<100;i++){
            Log.d("Asmit","adding " +i);
            Data data = new Data();
            data.setTitle("Title " + i);
            data.setDesc("Desc " + i);
            datas.add(data);
        }

        AsmitRecyclerViewAdapter mAsmitRecyclerViewAdapter = new AsmitRecyclerViewAdapter(getApplicationContext(),datas);
        mRecyclerView.setAdapter(mAsmitRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_notes, menu);
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
