package com.infantstudio.community.Adapaters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infantstudio.community.Pojo.StateFeedProperites;
import com.infantstudio.community.R;

import java.util.ArrayList;

/**
 * Created by venkataprasad.kukka on 02-01-2015.
 */
public class StateDataAdapter extends RecyclerView.Adapter<StateDataAdapter.ViewHolder> {

    private static ArrayList<StateFeedProperites> dataSet;

    public StateDataAdapter(ArrayList<StateFeedProperites> os_versions) {

        dataSet = os_versions;
    }


    @Override
    public StateDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a newlogo view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.state_card_view, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StateDataAdapter.ViewHolder viewHolder, int i) {

        StateFeedProperites fp = dataSet.get(i);

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

        public StateFeedProperites feed;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvVersionName = (TextView) itemLayoutView
                    .findViewById(R.id.tvVersionName);
            iconView = (ImageView) itemLayoutView
                    .findViewById(R.id.iconId);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Intent intent = newlogo Intent(v.getContext(), SecondActivity.class);
//                    v.getContext().startActivity(intent);
//                    Toast.makeText(v.getContext(), "os version is: " + feed.getTitle(), Toast.LENGTH_SHORT).show();



                }
            });


        }

    }
}
