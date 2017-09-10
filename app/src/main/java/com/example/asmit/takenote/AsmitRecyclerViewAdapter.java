package com.example.asmit.takenote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmit.takenote.database.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asmit on 9/10/17.
 */

public class AsmitRecyclerViewAdapter extends RecyclerView.Adapter<AsmitViewHolder> {
    public LayoutInflater mLayoutInflater;
    List<Data> dataList;

    public AsmitRecyclerViewAdapter(Context context,List<Data> dataList1){
        mLayoutInflater = LayoutInflater.from(context);
        this.dataList = dataList1;
        Log.d("Asmit", String.valueOf(dataList.size()));
    }

    @Override
    public AsmitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = mLayoutInflater.inflate(R.layout.custom_list_item,parent,false);
        return new AsmitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AsmitViewHolder holder, int position) {
        Data currentData = dataList.get(position);
        holder.textView.setText(currentData.getTitle());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }



}
