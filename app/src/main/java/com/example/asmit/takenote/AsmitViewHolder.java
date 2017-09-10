package com.example.asmit.takenote;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by asmit on 9/10/17.
 */

class AsmitViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    public AsmitViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.list_item_title_text_id);
       // textView.setText();
    }
}
