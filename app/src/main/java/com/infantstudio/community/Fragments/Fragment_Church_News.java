package com.infantstudio.community.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.infantstudio.community.app.AppController;
import com.infantstudio.community.Pojo.ChurchNewsFeedItem;
import com.infantstudio.community.Adapaters.ChurchNewsFeedListAdapter;
import com.infantstudio.community.MainActivity;
import com.infantstudio.community.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;




public class Fragment_Church_News extends Fragment {

  String URL_FEED_CHURCH_NEWS = "http://52.89.46.93/singleChurchApp/admin/news_eng.json?random=888998";
   // String URL_FEED_CHURCH_NEWS = "http://52.89.46.93/communityApp/?methodName=search.country&search_key=india";
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private ChurchNewsFeedListAdapter listAdapter;
    private List<ChurchNewsFeedItem> feedItemschurchnews;

    public Fragment_Church_News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_church_news, container, false);

        listView = (ListView) rootView.findViewById(R.id.list);

        feedItemschurchnews = new ArrayList<ChurchNewsFeedItem>();

        listAdapter = new ChurchNewsFeedListAdapter(getActivity(), feedItemschurchnews);
        listView.setAdapter(listAdapter);





        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_FEED_CHURCH_NEWS);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // making fresh volley request and getting json
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                    URL_FEED_CHURCH_NEWS, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(jsonReq);
        }


        return rootView;
    }
    private void parseJsonFeed(JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("news");//news


            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                ChurchNewsFeedItem item = new ChurchNewsFeedItem();
//                item.setId(feedObj.getInt("id"));
                item.setNews_title(feedObj.getString("news_title"));

                // Image might be null sometimes
               String image = feedObj.isNull("news_image") ? null : feedObj
                        .getString("news_image");
                item.setNews_image(image);
                item.setNews_details(feedObj.getString("news_details"));//news_details
//                item.setProfilePic(feedObj.getString("profilePic"));
//                item.setTimeStamp(feedObj.getString("timeStamp"));

                // url might be null sometimes
//                String feedUrl = feedObj.isNull("url") ? null : feedObj
//                        .getString("url");
//                item.setUrl(feedUrl);

                feedItemschurchnews.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}