package com.example.renzhenming.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by renzhenming on 2017/6/15.
 */

public class ChildAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<String> list;

    public ChildAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View chlidView = LayoutInflater.from(context).inflate(R.layout.item_normal_view,parent,false);
        return new ChildViewHolder(chlidView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ChildViewHolder childViewHolder = (ChildViewHolder) holder;
        childViewHolder.mChildText.setText(list.get(position));
        childViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onChildItemClick(list.get(position),position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ChildViewHolder extends RecyclerView.ViewHolder{

        private final TextView mChildText;

        public ChildViewHolder(View itemView) {
            super(itemView);
            mChildText = (TextView) itemView.findViewById(R.id.card_name);
        }
    }

    private OnChildItemClickListener listener;

    public void setOnChildItemClickListener(OnChildItemClickListener listener) {
        this.listener = listener;
    }

    interface OnChildItemClickListener{
        void onChildItemClick(String value,int position);

    }
}
