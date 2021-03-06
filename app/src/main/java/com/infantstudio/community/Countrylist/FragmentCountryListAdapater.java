package com.infantstudio.community.Countrylist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.infantstudio.community.app.AppController;
import com.infantstudio.community.ChurchNewsFeedImageView;

import com.infantstudio.community.R;

import java.util.List;


public class FragmentCountryListAdapater extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<FragmentCountryListFeedItem> churhcnewsfeedItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    private String[] bgColors;
    public FragmentCountryListAdapater(Activity activity, List<FragmentCountryListFeedItem> feedItems) {
        this.activity = activity;
        this.churhcnewsfeedItems = feedItems;
        bgColors = activity.getApplicationContext().getResources().getStringArray(R.array.movie_serial_bg);

    }

    @Override
    public int getCount() {
        return churhcnewsfeedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return churhcnewsfeedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.countrylistfeeditem, null);

//        if (imageLoader == null)
//            imageLoader = AppController.getInstance().getImageLoader();

        TextView newstitle = (TextView) convertView.findViewById(R.id.news_title);
        TextView Personid = (TextView) convertView.findViewById(R.id.person_id);
//        TextView timestamp = (TextView) convertView
//                .findViewById(R.id.timestamp);
//        TextView newdetails = (TextView) convertView
//                .findViewById(R.id.news_details);
        String color = bgColors[position % bgColors.length];


        ChurchNewsFeedImageView feedImageView = (ChurchNewsFeedImageView) convertView
                .findViewById(R.id.news_feedImage);

        FragmentCountryListFeedItem item = churhcnewsfeedItems.get(position);

        newstitle.setText(item.getNews_title());

        String m =newstitle.getText().toString().trim();
        System.out.println("ema"+m);

        Personid.setText(item.getPerson_id());




        // Converting timestamp into x ago format
//        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
//                Long.parseLong(item.getTimeStamp()),
//                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
//        timestamp.setText(timeAgo);

        // Chcek for empty status message
//        if (!TextUtils.isEmpty(item.getNews_details())) {
//            newdetails.setText(item.getNews_details());
//            newdetails.setVisibility(View.VISIBLE);
//        } else {
//            // status is empty, remove from view
//            newdetails.setVisibility(View.GONE);
//        }

//        if (item.getNews_image() != null) {
//            feedImageView.setImageUrl(item.getNews_image(), imageLoader);
//            feedImageView.setVisibility(View.VISIBLE);
//            feedImageView
//                    .setResponseObserver(new ChurchNewsFeedImageView.ResponseObserver() {
//                        @Override
//                        public void onError() {
//                        }
//
//                        @Override
//                        public void onSuccess() {
//                        }
//                    });
//        } else {
//            feedImageView.setVisibility(View.GONE);
//        }

        return convertView;
    }
}
