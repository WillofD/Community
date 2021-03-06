package com.infantstudio.community.Countrylist;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.infantstudio.community.DisplayUser;
import com.infantstudio.community.app.AppController;
import com.infantstudio.community.MainActivity;
import com.infantstudio.community.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.infantstudio.community.statics_demo.URL_COUNTRY;

public class FragmentCountryList  extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{


    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private FragmentCountryListAdapater listAdapter;
    private List<FragmentCountryListFeedItem> feedItemschurchnews;


    private String uniq_id;
    ArrayList<String> stringArray = new ArrayList<String>();
     public  JSONArray feedArray;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressDialog mProgressDialog;
    public  String fCountryvalue,fStateValue,fCityValue,fCommunityValue,fProfestionValue;
    public FragmentCountryList() {

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_country_list);

       // Countrylayout = (FrameLayout) findViewById(R.id.country_list_layout_id);
        Intent intent1 = getIntent();
        mProgressDialog = new ProgressDialog(this);


        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        listView = (ListView) findViewById(R.id.list);

        feedItemschurchnews = new ArrayList<FragmentCountryListFeedItem>();

        listAdapter = new FragmentCountryListAdapater(FragmentCountryList.this, feedItemschurchnews);

        listView.setAdapter(listAdapter);




        swipeRefreshLayout.setOnRefreshListener(this);

        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        feedItemschurchnews.clear();
                                        fetchMovies();
                                    }
                                }
        );






        listAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView c = (TextView) view.findViewById(R.id.person_id);
                String idfromtextview = c.getText().toString().trim();

                  Intent testIntent = new Intent(FragmentCountryList.this, DisplayUser.class);
                  testIntent.putExtra("txtpersonid",idfromtextview);
                    startActivity(testIntent);
                    //Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                            //Toast.LENGTH_SHORT).show();




            }
        });


        listAdapter.notifyDataSetChanged();
        // We first check for cached request


    }

    public static void CountryLink(String val)
    {

        URL_COUNTRY = "http://52.89.46.93/communityApp/?methodName=search.country&search_key="+val;


    }
    public static void StateLink(String val)
    {
        URL_COUNTRY = "http://52.89.46.93/communityApp/?methodName=search.state&search_key="+val;

    }
    public static void CityLink(String val)
    {

        URL_COUNTRY = "http://52.89.46.93/communityApp/?methodName=search.city&search_key="+val;
    }

    public static void CommunityLink(String val)
    {

        URL_COUNTRY = "http://52.89.46.93/communityApp/?methodName=search.community&search_key="+val;
    }
    public static   void ProfestionLink(String val)
    {
        URL_COUNTRY = "http://52.89.46.93/communityApp/?methodName=search.profession&search_key="+val;
    }


    private void parseJsonFeed(JSONObject response) {
        try {

            listAdapter.notifyDataSetChanged();
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setMessage("Loding Data...");
            mProgressDialog.show();
             feedArray = response.getJSONArray("responseMsg");//news


            if(feedArray != null && feedArray.length() > 0 ) {

                for (int i = 0; i < feedArray.length(); i++) {
                    int count = 1;
                    JSONObject feedObj = (JSONObject) feedArray.get(i);

                    FragmentCountryListFeedItem item = new FragmentCountryListFeedItem();
//
                    String name= feedObj.getString("name");
                    uniq_id = feedObj.getString("person_id");
                    stringArray.add(uniq_id.toString());
                    item.setNews_title(name);
                    item.setPerson_id(uniq_id);
                    System.out.println("kaaaaaaaaaaaaaaaaaa"+""+stringArray);
//                    item.setNews_details(feedObj.getString("person_id"));//news_details


                    feedItemschurchnews.add(item);
                    count++;
                    System.out.println("jaaaaaaaaa"+count);
                }

                swipeRefreshLayout.setRefreshing(false);
            // notify data changes to list adapater

                mProgressDialog.dismiss();
            }else
            {
                mProgressDialog.dismiss();
                Snackbar snackbar = Snackbar
                        .make(swipeRefreshLayout, "Sorry there are no users in the country", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
            listAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onRefresh() {
        feedItemschurchnews.clear();
        fetchMovies();
    }


    public void fetchMovies(){

        deleteCache(this);
        swipeRefreshLayout.setRefreshing(true);
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_COUNTRY);
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
                    URL_COUNTRY, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        parseJsonFeed(response);


                    }
                    listAdapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                }


            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());


                    swipeRefreshLayout.setRefreshing(false);
                }
            });

            // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(jsonReq);
        }

    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
        } catch (Exception e) {}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }



}
