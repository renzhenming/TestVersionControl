package com.example.renzhenming.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainGridActivity extends AppCompatActivity {

    private Map<Integer,List<String>> mSearMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);
        for (int i = 0; i < 5; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add("第"+i+"条数据，搜索结果"+j);
                mSearMap.put(i,list);
            }

        }

        RecyclerView mGroupView = (RecyclerView) findViewById(R.id.group_list_view);
        mGroupView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mGroupView.setLayoutManager(new LinearLayoutManager(this));
        GroupAdapter mGroupAdapter = new GroupAdapter(this,mSearMap);
        mGroupAdapter.setOnGroupItemClickListener(new GroupAdapter.OnGroupItemClickListener() {

            @Override
            public void onChildMoreClick(String value, int position) {
                Toast.makeText(getApplicationContext(),"点击了更多,"+"group position="+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildeItemClick(String value, int groupPosition, int childPosition) {
                Toast.makeText(getApplicationContext(),"点击了child"+value+",group position="+groupPosition+",child Position="+childPosition,Toast.LENGTH_SHORT).show();
            }
        });
        mGroupView.setAdapter(mGroupAdapter);
    }
}
