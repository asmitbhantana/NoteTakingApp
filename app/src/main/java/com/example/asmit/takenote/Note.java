package com.example.asmit.takenote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.asmit.takenote.database.Data;
import com.example.asmit.takenote.database.DatabaseIO;

public class Note extends AppCompatActivity {
    EditText mTitleText,mDescriptionText;
    Data data;
    DatabaseIO mDataBaseIO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mDataBaseIO =  DatabaseIO.get(getApplicationContext());
        data = new Data();
        mTitleText = (EditText) findViewById(R.id.title_text);
        mDescriptionText = (EditText) findViewById(R.id.desc_text);
        mTitleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    data.setTitle(mTitleText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mDescriptionText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    data.setDesc(mDescriptionText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_note_fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseIO.addCrime(data);
                Snackbar.make(view, "Saving!!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }
}
