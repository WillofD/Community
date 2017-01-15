package com.infantstudio.community.SearchFragmentPack;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.infantstudio.community.Adddata;
import com.infantstudio.community.Lists.SearchCity;
import com.infantstudio.community.Lists.SearchCommunity;
import com.infantstudio.community.Lists.SearchProfestion;
import com.infantstudio.community.Lists.SearchState;
import com.infantstudio.community.R;
import com.infantstudio.community.Lists.SearchCountry;

import java.util.List;


public class FragmentSearchMainAdapter extends RecyclerView.Adapter<FragmentSearchMainAdapter.MyViewHolder> {

    private Context mContext;
    private List<FragmentSearchMainPojo> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
//            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
//            overflow = (ImageView) view.findViewById(R.id.overflow);

            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Context context = v.getContext();
//                    Snackbar.make(v, "Click detected on item " + position,
//                            Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                    if(position == 0) {

                        context.startActivity(new Intent(context, SearchCountry.class));
                    }
                    if(position == 1){

                        context.startActivity(new Intent(context, SearchState.class));
                    }
                    if(position == 3){

                        context.startActivity(new Intent(context, SearchCity.class));
                    }
                    if(position==4){

                        context.startActivity(new Intent(context, Adddata.class));

                    }
                    if(position == 5)
                    {
                        context.startActivity(new Intent(context, SearchProfestion.class));

                    }

                    if(position == 6){
                        context.startActivity(new Intent(context, SearchCommunity.class));
                    }

                }
            });


        }
    }


    public FragmentSearchMainAdapter(Context mContext, List<FragmentSearchMainPojo> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_search_album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        FragmentSearchMainPojo album = albumList.get(position);
        holder.title.setText(album.getName());
//        holder.count.setText(album.getNumOfSongs() + " songs");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPopupMenu(holder.overflow);
//            }
//        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
//    private void showPopupMenu(View view) {
//        // inflate menu
//        PopupMenu popup = new PopupMenu(mContext, view);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menu_album, popup.getMenu());
//        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
//        popup.show();
//    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
//                case R.id.action_add_favourite:
//                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.action_play_next:
//                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
//                    return true;
//                default:
            }
            return false;
        }
    }



    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
