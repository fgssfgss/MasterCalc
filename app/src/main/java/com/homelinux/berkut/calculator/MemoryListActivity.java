package com.homelinux.berkut.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MemoryListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_list);

        ListView lw = (ListView) findViewById(R.id.listView);

        List<String> mem = (List<String>)getIntent().getSerializableExtra("list");

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>)mem);
        lw.setAdapter(adapt);
    }
}
