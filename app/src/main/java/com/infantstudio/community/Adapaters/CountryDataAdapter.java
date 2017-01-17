package com.infantstudio.community.Adapaters;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infantstudio.community.Fixed;
import com.infantstudio.community.Fragments.StateActivity;
import com.infantstudio.community.Pojo.CountryFeedProperites;
import com.infantstudio.community.R;

import java.security.PublicKey;
import java.util.ArrayList;


import static com.infantstudio.community.Fixed.test1;
/**
 * Created by venkataprasad.kukka on 02-01-2015.
 */



public class CountryDataAdapter extends RecyclerView.Adapter<CountryDataAdapter.ViewHolder>  {


    public Activity test;
    private static ArrayList<CountryFeedProperites> dataSet;




    public CountryDataAdapter(ArrayList<CountryFeedProperites> os_versions) {

        dataSet = os_versions;
    }


    @Override
    public CountryDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a newlogo view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.country_card_view, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryDataAdapter.ViewHolder viewHolder, int i) {

        CountryFeedProperites fp = dataSet.get(i);

        viewHolder.tvVersionName.setText(fp.getTitle());
        viewHolder.iconView.setImageResource(fp.getThumbnail());
        viewHolder.feed = fp;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvVersionName;
        public ImageView iconView;

        public CountryFeedProperites feed;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvVersionName = (TextView) itemLayoutView
                    .findViewById(R.id.tvVersionName);
            iconView = (ImageView) itemLayoutView
                    .findViewById(R.id.iconId);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    test1 = true;
                    Fragment frg = null;
                    frg = new StateActivity();

//                    Intent intent = newlogo Intent(v.getContext(), SecondActivity.class);
//                    v.getContext().startActivity(intent);
//                    Toast.makeText(v.getContext(), "os version is: " + feed.getTitle(), Toast.LENGTH_SHORT).show();


                }
            });


        }

    }



}
