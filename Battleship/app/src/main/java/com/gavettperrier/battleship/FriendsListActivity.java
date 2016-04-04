package com.gavettperrier.battleship;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.Templates;

public class FriendsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.friendsListView);
        String[] friends = new String[]{"Bob", "Joe","Steve","Sally","Linda"};
        final ArrayList<String> list = new ArrayList<String>();
        for(int i = 0;i<friends.length;++i){
            list.add(friends[i]);
        }
        //final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        //listView.setAdapter(adapter);
    }

    private class StableArrayAdapter extends ArrayAdapter<User>{
        HashMap<User,Integer> mIDmap = new HashMap<User,Integer>();
        public StableArrayAdapter(Context context, int textViewResourceID, List<User> objects){
            super(context, textViewResourceID,objects);
            for(int i = 0; i<objects.size();++i){
                mIDmap.put(objects.get(i),i);
            }
        }
        @Override
        public long getItemId(int position){
            User item = getItem(position);
            return mIDmap.get(item);
        }
        @Override
        public boolean hasStableIds() {return true;}
    }

}
