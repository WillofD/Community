package com.infantstudio.community.Countrylist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.infantstudio.community.AppController;
import com.infantstudio.community.DisplayUser;
import com.infantstudio.community.MainActivity;
import com.infantstudio.community.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


import static com.infantstudio.community.statics_demo.URL_STATE;

public class FragmentStateList extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private FragmentStateListAdapater listAdapter;
    private List<FragmentStateListFeedItem> feedItemschurchnews;
    public FrameLayout Statelayout;
     public  JSONArray feedArray;
    private ProgressDialog mProgressDialog;
    public  String fCountryvalue,fStateValue,fCityValue,fCommunityValue,fProfestionValue;
    public FragmentStateList() {

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_state_list);

        Statelayout = (FrameLayout) findViewById(R.id.state_list_layout_id);
        Intent intent1 = getIntent();
        mProgressDialog = new ProgressDialog(this);


//         fCountryvalue = intent1.getStringExtra("CountryValue");
//        fStateValue = intent1.getStringExtra("StateValue");
//       fCityValue = intent1.getStringExtra("CityValue");
//       fCommunityValue = intent1.getStringExtra("CommunityValue");
//        fProfestionValue = intent1.getStringExtra("ProfestionValue");



      // URL_COUNTRY = "http://52.89.46.93/communityApp/?methodName=search.country&search_key="+fvalue;
//        CountryLink(fCountryvalue);
//        StateLink(fStateValue);
//        CityLink(fCityValue);
//        CommunityLink(fCommunityValue);
//        ProfestionLink(fProfestionValue);



        listView = (ListView) findViewById(R.id.list);

        feedItemschurchnews = new ArrayList<FragmentStateListFeedItem>();

        listAdapter = new FragmentStateListAdapater(FragmentStateList.this, feedItemschurchnews);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 1){

                  Intent testIntent = new Intent(FragmentStateList.this, DisplayUser.class);
                    startActivity(testIntent);
                    //Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                            //Toast.LENGTH_SHORT).show();
                    TextView c = (TextView) view.findViewById(R.id.news_title);
                    String a = c.toString().trim();

                }
            }
        });



        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_STATE);
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
                    URL_STATE, null, new Response.Listener<JSONObject>() {

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



    }


    public static void StateLink(String val)
    {
        URL_STATE = "http://52.89.46.93/communityApp/?methodName=search.state&search_key="+val;
        System.out.println("yodaaaaaaaaaaaaaa"+val);

    }


    private void parseJsonFeed(JSONObject response) {
        try {
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setMessage("Loding Data...");
            mProgressDialog.show();
             feedArray = response.getJSONArray("responseMsg");//news


            if(feedArray != null && feedArray.length() > 0 ) {

                for (int i = 0; i < feedArray.length(); i++) {
                    JSONObject feedObj = (JSONObject) feedArray.get(i);

                    FragmentStateListFeedItem item = new FragmentStateListFeedItem();
//
                    String id = feedObj.getString("name");
                    item.setNews_title(id);


//                    item.setNews_details(feedObj.getString("person_id"));//news_details


                    feedItemschurchnews.add(item);
                }


            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
                mProgressDialog.dismiss();
            }else
            {
                mProgressDialog.dismiss();
                Snackbar snackbar = Snackbar
                        .make(Statelayout, "Sorry there are no users in the country", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
