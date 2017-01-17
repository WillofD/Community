package com.infantstudio.community.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infantstudio.community.Adapaters.CountryDataAdapter;
import com.infantstudio.community.Adapaters.StateDataAdapter;
import com.infantstudio.community.Pojo.CountryFeedProperites;
import com.infantstudio.community.Pojo.StateFeedProperites;
import com.infantstudio.community.R;

import java.util.ArrayList;

public class StateActivity extends Fragment {
    private RecyclerView recyclerView;
    private CardView cardView;

    private ArrayList<StateFeedProperites> os_versions;

    private RecyclerView.Adapter mAdapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_state_fragment, container, false);


        //  cardView = (CardView) findViewById(R.id.cardList);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_state);


        final String[] versions = {"French", "Canada", "Italy", "Dubai",
        };
        final int[] icons = {R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1, R.drawable.hum1};


        os_versions = new ArrayList<StateFeedProperites>();

        for (int i = 0; i < versions.length; i++) {
            StateFeedProperites feed = new StateFeedProperites();

            feed.setTitle(versions[i]);
            feed.setThumbnail(icons[i]);
            os_versions.add(feed);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Grid View
        // recyclerView.setLayoutManager(newlogo GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(newlogo StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new StateDataAdapter(os_versions);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);





return rootView;
    }

}
