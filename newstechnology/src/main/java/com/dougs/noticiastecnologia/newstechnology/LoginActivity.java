package com.dougs.noticiastecnologia.newstechnology;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import br.dougs.noticiastecnologia.adapter.AdapterList;

public class LoginActivity extends ListActivity  {

    //ListView listView;
    protected Object mActionMode;
    public int selectedItem = -1;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        //listView = (ListView) findViewById(R.id.listViewNews);

        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};

        //ArrayList<String> planetList = new ArrayList<String>();
        //planetList.addAll(Arrays.asList(planets) );

        AdapterList adapter = new AdapterList(this, planets);
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                if (mActionMode != null) {
                    return false;
                }
                selectedItem = position;
                return true;
            }
        });
    }

    private void show() {
        Toast.makeText(LoginActivity.this,
                String.valueOf(selectedItem), Toast.LENGTH_LONG).show();
    }
}
