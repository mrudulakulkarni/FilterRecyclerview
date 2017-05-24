package com.example.admin.filterrecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = "MainActivity";
    private ArrayList<ListItem> allList;

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter adapter;
    private SearchView mSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchView = (SearchView) findViewById(R.id.search_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setList();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyRecyclerAdapter(this, allList);
        mRecyclerView.setAdapter(adapter);

        setupSearchView();
    }

    public void setList() {

        allList = new ArrayList<ListItem>();

        ListItem item = new ListItem();
        item.setData("Captiva", "Florida", R.drawable.beach1);
        allList.add(item);

        item = new ListItem();
        item.setData("Clearwater", "Florida", R.drawable.beach2);
        allList.add(item);

        item = new ListItem();
        item.setData("Palm", "Florida", R.drawable.beach3);
        allList.add(item);

        item = new ListItem();
        item.setData("Keywest", "Florida", R.drawable.beach4);
        allList.add(item);

        item = new ListItem();
        item.setData("Laguna", "California", R.drawable.beach5);
        allList.add(item);


        item = new ListItem();
        item.setData("Siesta", "Florida", R.drawable.beach6);
        allList.add(item);

        item = new ListItem();
        item.setData("Sanibel", "Florida", R.drawable.beach7);
        allList.add(item);

        item = new ListItem();
        item.setData("SouthBeach", "Florida", R.drawable.beach8);
        allList.add(item);


        item = new ListItem();
        item.setData("Naples", "Florida", R.drawable.beach9);
        allList.add(item);

        item = new ListItem();
        item.setData("Delrays", "Florida", R.drawable.beach10);
        allList.add(item);


        for (int i = 0; i < 10; i++) {
            item = new ListItem();
            item.setData("Clearwater" + i, "Florida " + i, R.drawable.beach4);
            allList.add(item);
        }

    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }

    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

}
