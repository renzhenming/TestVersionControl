package com.example.renzhenming.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by renzhenming on 2017/6/15.
 */

public class GroupAdapter extends RecyclerView.Adapter {
    private final Map<Integer, List<String>> mSearchMap;
    private final Context context;


    public GroupAdapter(Context context, Map<Integer, List<String>> mSearMap) {
        this.context = context;
        this.mSearchMap = mSearMap;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_group,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final List<String> list = mSearchMap.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mChildView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ChildAdapter childAdapter = new ChildAdapter(context, list);
        viewHolder.mChildView.addItemDecoration(new SimpleItemDecoration(10));
        childAdapter.setOnChildItemClickListener(new ChildAdapter.OnChildItemClickListener() {
            @Override
            public void onChildItemClick(String value, int childPosition) {
                if (listener != null){
                    listener.onChildeItemClick(value,position,childPosition);
                }
            }
        });
        viewHolder.mChildView.setAdapter(childAdapter);
        viewHolder.mChildMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onChildMoreClick(list.get(position),position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSearchMap.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private final RecyclerView mChildView;
        private final TextView mChildMore;

        public ViewHolder(View itemView) {
            super(itemView);
            mChildView = (RecyclerView) itemView.findViewById(R.id.child_list_view);
            mChildMore = (TextView) itemView.findViewById(R.id.child_more);
        }
    }

    private OnGroupItemClickListener listener;

    public void setOnGroupItemClickListener(OnGroupItemClickListener listener) {
        this.listener = listener;
    }

    interface OnGroupItemClickListener{
        void onChildMoreClick(String value,int position);
        void onChildeItemClick(String value,int groupPosition,int childPosition);
    }
}
